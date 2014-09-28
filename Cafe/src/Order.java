import java.util.Scanner;

class Order
{
    Menu menu;
    String[] condiment;
    int discount;
    int price;
    
    Scanner keyboard = new Scanner(System.in);

    void SelectMenu()
    {
        System.out.print("■메뉴를 선택하세요: ");
        String input = keyboard.nextLine();
        switch (input)
        {
            case "하우스 블렌드":
                menu = new HouseBlend();
                break;
            case "다크 로스트":
                menu = new DarkRoast();
                break;
            case "디캐프":
                menu = new Decaf();
                break;
            case "에스프레소":
                menu = new Espresso();
                break;
            case "녹차":
                menu = new GreenTea();
                break;
            case "밀크 티":
                menu = new MilkTea();
                break;
        }
        price = menu.price;
    }

    void SelectCondiment()
    {
        System.out.print("■추가 재료를 선택하세요(우유 모카 두유 크림): ");
        String input = keyboard.nextLine();
        condiment = input.split(" ");
        price = Condiment.AddPrice(this);
    }

    void SelectDiscount()
    {
        System.out.print("■할인종류를 입력하세요(1-쿠폰,2-카드,3-이벤트): ");
        discount = Integer.parseInt(keyboard.nextLine());
        price = Discount.PriceCalculation(this);
    }

    void ShowProcess()
    {
        for (String s : menu.process)
        {
            System.out.println("- " + s);
        }
    }

    void ShowPrice()
    {
        System.out.print("■구매가격: ");
        System.out.println(price);
        keyboard.close();
    }
}
