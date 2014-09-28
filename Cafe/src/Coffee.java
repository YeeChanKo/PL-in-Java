class Coffee extends Menu
{
    Coffee(String name, int price)
    {
        super(name, price);
        process[1] = "필터로 커피를 우려내는 중";
        process[3] = "설탕과 커피를 추가하는 중";
    }
}

class HouseBlend extends Coffee
{
    HouseBlend()
    {
        super("하우스 블렌드", 1000);
    }
}

class DarkRoast extends Coffee
{
    DarkRoast()
    {
        super("다크 로스트", 1500);
    }
}

class Decaf extends Coffee
{
    Decaf()
    {
        super("디캐프", 1200);
    }
}

class Espresso extends Coffee
{
    Espresso()
    {
        super("에스프레소", 900);
    }
}