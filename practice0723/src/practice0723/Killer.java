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
    
    public String introduce()
    {
        return "����: "+weapon+", "+super.introduce();
    }

    String getWeapon()
    {
        return weapon;
    }
    
    String greetings()
    {
        return "wow";
    }

    public static void main(String[] args)
    {
        Person y = new Killer("������", 5, "��", "You can tell me in hell.");
        IronMan newbe = new IronMan(y);
        System.out.println(newbe.introduce());
        
        // Person yotsuba = new Killer("������", 5, "��", "You can tell me in hell.");
        // System.out.println(yotsuba.introduce());
        // System.out.println(yotsuba.greetings()); // person���� ������ ���� �� person �ȿ� �ش�Ǵ� �޼ҵ尡 ������ ������ ���Ѵ�.
    }
}
