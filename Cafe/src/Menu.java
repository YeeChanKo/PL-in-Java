class Menu
{
    String name;
    int price;
    String[] process = new String[4];

    Menu(String name, int price)
    {
        this.name = name;
        this.price = price;
        process[0] = "물 끓이는 중";
        process[2] = "컵에 따르는 중";
    }
}
