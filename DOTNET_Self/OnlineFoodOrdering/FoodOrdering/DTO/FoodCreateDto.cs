using Microsoft.AspNetCore.Http;

namespace FoodOrdering.DTO
{
    public class FoodCreateDto
    {
        public string Name { get; set; } = string.Empty;

        public decimal Price { get; set; }

        public string Description { get; set; } = string.Empty;

        public IFormFile? Image { get; set; }
    }
}