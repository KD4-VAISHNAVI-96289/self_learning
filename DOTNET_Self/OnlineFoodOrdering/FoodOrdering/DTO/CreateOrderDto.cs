namespace FoodOrdering.DTO
{
    public class CreateOrderDto
    {
        public decimal TotalAmount { get; set; }
        public List<CartItemDto> cartItems { get; set; }
    }
}
