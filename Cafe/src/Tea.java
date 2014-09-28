class Tea extends Menu
{
    Tea(String name, int price)
    {
        super(name, price);
        process[1] = "차를 우려내는 중";
        process[3] = "레몬을 추가하는 중";
    }
}

class GreenTea extends Tea
{
    GreenTea()
    {
        super("녹차", 1000);
    }
}

class MilkTea extends Tea
{
    MilkTea()
    {
        super("밀크 티", 1200);
    }
}
