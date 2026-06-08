//using Microsoft.AspNetCore.Mvc;

namespace FoodOrdering.Controllers
{
    public class RegisterDto
    {
        public string Password { get; internal set; }
        public string Name { get; internal set; }
        public string Email { get; internal set; }
        public string Mobile { get; internal set; }
    }
}