package practice0723;

public abstract class Person implements Tellable 
{
    String name;
    int age;

    Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    String message()
    {
        return "Message: ["+introduce()+"]";
    }
    public String introduce()
    {
        return "�̸�: " + name + ", ����: " + age + "��";
    }
}
