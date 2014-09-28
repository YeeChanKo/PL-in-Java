package test;

import java.util.Scanner;

public class runner
{
    static Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        String a = "wowow: ";
        int b = GetInt(a);
        System.out.println(b);
    }
    
    private static int GetInt(String request) // 1~10 사이의 값을 받음
    {
        int temp = 0;
        do
        {
            try
            {
                System.out.print(request);
                temp = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e)
            {
                System.out.println("1~10 사이의 값을 입력해주세요!");
            }
        } while (!(temp > 0 && temp < 11));
        return temp;
    }
}