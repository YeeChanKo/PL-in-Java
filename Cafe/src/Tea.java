class Tea extends Menu
{
    Tea(String name, int price)
    {
        super(name, price);
        process[1] = "���� ������� ��";
        process[3] = "������ �߰��ϴ� ��";
    }
}

class GreenTea extends Tea
{
    GreenTea()
    {
        super("����", 1000);
    }
}

class MilkTea extends Tea
{
    MilkTea()
    {
        super("��ũ Ƽ", 1200);
    }
}
