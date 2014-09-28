public class Cafe
{
    public static void main(String[] args)
    {
        System.out.println("_______________Welcome_______________");
        System.out.println();

        Order newOrder = new Order();
        newOrder.SelectMenu();
        newOrder.SelectCondiment();
        newOrder.SelectDiscount();
        newOrder.ShowProcess();
        newOrder.ShowPrice();
    }
}