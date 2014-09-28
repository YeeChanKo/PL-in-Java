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
        return "무기: "+weapon+", "+super.introduce();
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
        Person y = new Killer("요츠바", 5, "총", "You can tell me in hell.");
        IronMan newbe = new IronMan(y);
        System.out.println(newbe.introduce());
        
        // Person yotsuba = new Killer("요츠바", 5, "총", "You can tell me in hell.");
        // System.out.println(yotsuba.introduce());
        // System.out.println(yotsuba.greetings()); // person으로 선언을 했을 때 person 안에 해당되는 메소드가 없으면 참조를 못한다.
    }
}
