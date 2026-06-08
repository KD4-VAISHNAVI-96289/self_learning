namespace FoodOrdering.DTO
{
    public class OrderDetailDto
    {
        public int Fid { get; set; }
        public string FoodName { get; set; }

        public int Qty { get; set; }

        public decimal Price { get; set; }
    }
}
