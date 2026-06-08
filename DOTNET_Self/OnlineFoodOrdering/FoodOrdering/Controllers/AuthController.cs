
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.IdentityModel.Tokens;
using OnlineFoodOrderingSystemWebAPI.Models;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;
using FoodOrdering.DTO;

namespace FoodOrdering.Controllers
{
    [ApiController]
    [Route("user")]
    public class AuthController : ControllerBase
    {
        private readonly AppDbContext _context;
        private readonly IConfiguration _configuration;

        public AuthController(AppDbContext context, IConfiguration configuration)
        {
            _context = context;
            _configuration = configuration;
        }

        // ================= SIGNUP =================

        [AllowAnonymous]
        [HttpPost("signup")]
        public async Task<IActionResult> Signup([FromBody] RegisterDTO dto)
        {
            try
            {
                bool exists = await _context.Users
                    .AnyAsync(x => x.Email == dto.Email);

                if (exists)
                {
                    return BadRequest(
                        ResultHelper.error<string>("Email already registered"));
                }

                var user = new User
                {
                    Name = dto.Name,
                    Email = dto.Email,
                    Password = BCrypt.Net.BCrypt.HashPassword(dto.Password),
                    Mobile = dto.Mobile
                };

                _context.Users.Add(user);
                await _context.SaveChangesAsync();

                return Ok(
                    ResultHelper.Success("Signup successful"));
            }
            catch (Exception ex)
            {
                return BadRequest(
                    ResultHelper.error<string>(ex.Message));
            }
        }

        // ================= SIGNIN =================

        [AllowAnonymous]
        [HttpPost("signin")]
        public async Task<IActionResult> Signin([FromBody] LoginDto dto)
        {
            try
            {
                var dbUser =
                    await _context.Users
                    .FirstOrDefaultAsync(
                        x => x.Email == dto.Email);

                if (dbUser == null)
                {
                    return BadRequest(
                        ResultHelper.error<string>(
                            "Invalid Email or Password"));
                }

                bool valid =
                    BCrypt.Net.BCrypt.Verify(
                        dto.Password,
                        dbUser.Password);

                if (!valid)
                {
                    return BadRequest(
                        ResultHelper.error<string>(
                            "Invalid Email or Password"));
                }

                string token =
                    GenerateJwtToken(dbUser);

                var response = new
                {
                    Uid = dbUser.Uid,
                    Name = dbUser.Name,
                    Email = dbUser.Email,
                    Token = token
                };

                return Ok(
                    ResultHelper.Success(response));
            }
            catch (Exception ex)
            {
                return BadRequest(
                    ResultHelper.error<string>(
                        ex.Message));
            }
        }

        // ================= GET PROFILE =================

        [Authorize]
        [HttpGet]
        public async Task<IActionResult> GetProfile()
        {
            try
            {
                var uidClaim = User.FindFirst("uid");

                if (uidClaim == null)
                {
                    return Unauthorized(
                        ResultHelper.error<string>("Invalid Token"));
                }

                int uid = Convert.ToInt32(uidClaim.Value);

                var user = await _context.Users
                    .FirstOrDefaultAsync(x => x.Uid == uid);

                if (user == null)
                {
                    return NotFound(
                        ResultHelper.error<string>("User Not Found"));
                }

                var response = new
                {
                    user.Name,
                    user.Email,
                    user.Mobile
                };

                return Ok(ResultHelper.Success(response));
            }
            catch (Exception ex)
            {
                return BadRequest(
                    ResultHelper.error<string>(ex.Message));
            }
        }


        // ================= Update Mobile ===============================


        [Authorize]
        [HttpPut]
        public async Task<IActionResult> UpdateMobile(
    [FromBody] UpdateMobileDto dto)
        {
            try
            {
                var uidClaim = User.FindFirst("uid");

                if (uidClaim == null)
                {
                    return Unauthorized(
                        ResultHelper.error<string>("Invalid Token"));
                }

                int uid = Convert.ToInt32(uidClaim.Value);

                var user = await _context.Users
                    .FirstOrDefaultAsync(x => x.Uid == uid);

                if (user == null)
                {
                    return NotFound(
                        ResultHelper.error<string>("User Not Found"));
                }

                user.Mobile = dto.Mobile;

                await _context.SaveChangesAsync();

                return Ok(
                    ResultHelper.Success(
                        "Mobile number updated successfully"));
            }
            catch (Exception ex)
            {
                return BadRequest(
                    ResultHelper.error<string>(ex.Message));
            }
        }


        // ============ Delete User ===============================

        [Authorize]
        [HttpDelete]
        public async Task<IActionResult> DeleteAccount()
        {
            try
            {
                var uidClaim = User.FindFirst("uid");

                if (uidClaim == null)
                {
                    return Unauthorized(
                        ResultHelper.error<string>("Invalid Token"));
                }

                int uid = Convert.ToInt32(uidClaim.Value);

                var user = await _context.Users
                    .FirstOrDefaultAsync(x => x.Uid == uid);

                if (user == null)
                {
                    return NotFound(
                        ResultHelper.error<string>("User Not Found"));
                }

                _context.Users.Remove(user);

                await _context.SaveChangesAsync();

                return Ok(
                    ResultHelper.Success(
                        "Account deleted successfully"));
            }
            catch (Exception ex)
            {
                return BadRequest(
                    ResultHelper.error<string>(ex.Message));
            }
        }






        // ================= HELPER METHODS =================
        private string GenerateJwtToken(User user)
        {
            var claims = new[]
            {
        new Claim("uid", user.Uid.ToString()),
        new Claim(
            ClaimTypes.Email,
            user.Email ?? "")
    };

            var key = new SymmetricSecurityKey(
                Encoding.UTF8.GetBytes(
                    _configuration["Jwt:Key"]!));

            var creds = new SigningCredentials(
                key,
                SecurityAlgorithms.HmacSha256);

            var token = new JwtSecurityToken(
                issuer: _configuration["Jwt:Issuer"],
                audience: _configuration["Jwt:Audience"],
                claims: claims,
                expires: DateTime.UtcNow.AddHours(2),
                signingCredentials: creds);

            return new JwtSecurityTokenHandler()
                .WriteToken(token);
        }
    }
}

