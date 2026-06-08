using System;
using System.Collections.Generic;

namespace OnlineFoodOrderingSystemWebAPI.Models;

public partial class Order
{
    public int Oid { get; set; }

    public int? Uid { get; set; }

    public DateTime? Odate { get; set; }

    public DateTime? Deldate { get; set; }

    public decimal? TotalAmount { get; set; }

    public virtual ICollection<OrderDetail> OrderDetails { get; set; } = new List<OrderDetail>();

    public virtual User? UidNavigation { get; set; }
}
