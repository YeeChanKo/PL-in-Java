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
        System.out.print("��޴��� �����ϼ���: ");
        String input = keyboard.nextLine();
        switch (input)
        {
            case "�Ͽ콺 ����":
                menu = new HouseBlend();
                break;
            case "��ũ �ν�Ʈ":
                menu = new DarkRoast();
                break;
            case "��ĳ��":
                menu = new Decaf();
                break;
            case "����������":
                menu = new Espresso();
                break;
            case "����":
                menu = new GreenTea();
                break;
            case "��ũ Ƽ":
                menu = new MilkTea();
                break;
        }
        price = menu.price;
    }

    void SelectCondiment()
    {
        System.out.print("���߰� ��Ḧ �����ϼ���(���� ��ī ���� ũ��): ");
        String input = keyboard.nextLine();
        condiment = input.split(" ");
        price = Condiment.AddPrice(this);
    }

    void SelectDiscount()
    {
        System.out.print("������������ �Է��ϼ���(1-����,2-ī��,3-�̺�Ʈ): ");
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
        System.out.print("�ᱸ�Ű���: ");
        System.out.println(price);
        keyboard.close();
    }
}
