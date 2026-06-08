
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using OnlineFoodOrderingSystemWebAPI.Models;
using FoodOrdering.DTO;

namespace FoodOrdering.Controllers
{
    [ApiController]
    [Route("food")]
    public class FoodController : ControllerBase
    {
        private readonly AppDbContext _context;
        private readonly IWebHostEnvironment _environment;

        public FoodController(AppDbContext context, IWebHostEnvironment environment)
        {
            _context = context;
            _environment = environment;
        }

        // ================= GET FOOD =================

        [HttpGet]
        public async Task<IActionResult> GetFood()
        {
            try
            {
                var foods = await _context.Foods.ToListAsync();

                return Ok(ResultHelper.Success(foods));
            }
            catch (Exception ex)
            {
                return BadRequest(
                    ResultHelper.error<string>(ex.Message));
            }
        }

        // ================= POST FOOD =================

        [HttpPost]
        public async Task<IActionResult> AddFood(
            [FromForm] FoodCreateDto dto)
        {
            try
            {
                string fileName = "";

                if (dto.Image != null)
                {
                    fileName =
                        Guid.NewGuid().ToString() +
                        Path.GetExtension(dto.Image.FileName);

                    string folderPath =
                        Path.Combine(
                            _environment.WebRootPath,
                            "foodImages");

                    if (!Directory.Exists(folderPath))
                    {
                        Directory.CreateDirectory(folderPath);
                    }

                    string filePath =
                        Path.Combine(folderPath, fileName);

                    using var stream =
                        new FileStream(filePath, FileMode.Create);

                    await dto.Image.CopyToAsync(stream);
                }

                var food = new Food
                {
                    Name = dto.Name,
                    Price = dto.Price,
                    Description = dto.Description,
                    Image = fileName
                };

                _context.Foods.Add(food);
                await _context.SaveChangesAsync();

                return Ok(
                    ResultHelper.Success(food));
            }
            catch (Exception ex)
            {
                return BadRequest(
                    ResultHelper.error<string>(ex.Message));
            }
        }
    }
}