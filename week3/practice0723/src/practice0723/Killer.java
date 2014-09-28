package practice0723;

public class Killer extends Person
{
    String weapon;
    String warning;

    Killer(String name, int age, String weapon, String warning)
    {
        super(name,age);
        this.weapon = weapon;
        this.warning = warning;
    }
    
    String introduce()
    {
        return "¹«±â: "+weapon+", "+super.introduce();
    }

    String getWeapon()
    {
        return weapon;
    }

    public static void main(String[] args)
    {
        Person yotsuba = new Killer("¿äÃ÷¹Ù", 5, "ÃÑ", "You can tell me in hell.");
        Killer a = yotsuba;
        System.out.println(yotsuba.message());
        //System.out.println(killerYotsuba.getWeapon());
    }
}
