using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using OnlineFoodOrderingSystemWebAPI.Models;
using FoodOrdering.DTO;

namespace FoodOrdering.Controllers
{
    [ApiController]
    [Route("order")]
    [Authorize]
    public class OrdersController : ControllerBase
    {
        private readonly AppDbContext _context;

        public OrdersController(AppDbContext context)
        {
            _context = context;
        }

        // ================= POST ORDER =================

        [HttpPost]
        public async Task<IActionResult> PlaceOrder(
            [FromBody] PlaceOrderDto dto)
        {
            try
            {
                var uidClaim = User.FindFirst("uid");

                if (uidClaim == null)
                {
                    return Unauthorized(
                        ResultHelper.error<string>(
                            "Invalid Token"));
                }

                int uid =
                    Convert.ToInt32(uidClaim.Value);

                var order = new Order
                {
                    Uid = uid,
                    Odate = DateTime.Now,
                    Deldate = DateTime.Now.AddDays(3),
                    TotalAmount = dto.TotalAmount
                };

                _context.Orders.Add(order);

                await _context.SaveChangesAsync();

                foreach (var item in dto.CartItems)
                {
                    var detail = new OrderDetail
                    {
                        Oid = order.Oid,
                        Fid = item.Fid,
                        Quantity = item.Quantity
                    };

                    _context.OrderDetails.Add(detail);
                }

                await _context.SaveChangesAsync();

                return Ok(
                    ResultHelper.Success(
                        "Order placed successfully"));
            }
            catch (Exception ex)
            {
                return BadRequest(
                    ResultHelper.error<string>(
                        ex.Message));
            }
        }

        // ================= GET ORDERS =================
        [HttpGet]
        public async Task<IActionResult> GetOrders()
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

                var orders = await _context.Orders
                    .Where(o => o.Uid == uid)
                    .Select(o => new
                    {
                        o.Oid,
                        o.Odate,
                        o.Deldate,
                        o.TotalAmount,

                        Items = o.OrderDetails.Select(d => new
                        {
                            d.Fid,
                            d.Quantity
                        })
                    })
                    .ToListAsync();

                return Ok(
                    ResultHelper.Success(orders));
            }
            catch (Exception ex)
            {
                return BadRequest(
                    ResultHelper.error<string>(ex.Message));
            }
        }




    }
}