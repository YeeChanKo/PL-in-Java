class Coffee extends Menu
{
    Coffee(String name, int price)
    {
        super(name, price);
        process[1] = "���ͷ� Ŀ�Ǹ� ������� ��";
        process[3] = "������ Ŀ�Ǹ� �߰��ϴ� ��";
    }
}

class HouseBlend extends Coffee
{
    HouseBlend()
    {
        super("�Ͽ콺 ����", 1000);
    }
}

class DarkRoast extends Coffee
{
    DarkRoast()
    {
        super("��ũ �ν�Ʈ", 1500);
    }
}

class Decaf extends Coffee
{
    Decaf()
    {
        super("��ĳ��", 1200);
    }
}

class Espresso extends Coffee
{
    Espresso()
    {
        super("����������", 900);
    }
}