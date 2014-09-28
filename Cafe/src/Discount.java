class Discount
{
    static int CouponDiscount = 100;
    static double CardDiscount = 0.03;
    static int EventDiscount = 0;

    static int PriceCalculation(Order order)
    {
        int price = order.price;

        switch (order.discount)
        {
            case 1:
                price -= CouponDiscount;
                break;
            case 2:
                price *= (1 - CardDiscount);
                break;
            case 3:
                price = EventDiscount;
                break;
        }

        return price;
    }
}