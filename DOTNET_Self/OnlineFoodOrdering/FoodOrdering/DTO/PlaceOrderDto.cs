namespace FoodOrdering.DTO
{
    public class PlaceOrderDto
    {
        public List<CartItemDto> CartItems { get; set; } = new();
        public decimal TotalAmount { get; set; }
    }
}