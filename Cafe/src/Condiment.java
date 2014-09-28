class Condiment
{
    static int milk = 100;
    static int mocha = 50;
    static double soy = 0.001;
    static double whip = 0.0001;

    static int AddPrice(Order order)
    {
        String[] condiment = order.condiment;
        int price = order.menu.price;
        for (String s : condiment)
        {
            switch (s)
            {
                case "��ũ":
                    price += milk;
                    break;
                case "��ī":
                    price += mocha;
                    break;
                case "����":
                    price += order.menu.price * soy;
                    break;
                case "ũ��":
                    price += order.menu.price * whip;
                    break;
            }
        }
        return price;
    }
}
