package practice0723;

public class Person
{
    String name;
    int age;

    Person()
    {
        this("tkfka", 1);
    }

    Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    String message()
    {
        return "Message: ["+introduce()+"]";
    }
    String introduce()
    {
        return "�̸�: " + name + ", ����: " + age + "��";
    }

    public static void main(String[] args)
    {
        Person yotsuba = new Person("������", 5);
        System.out.println(yotsuba.message());
    }
}
