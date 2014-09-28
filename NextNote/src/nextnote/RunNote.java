package nextnote;

import java.util.Scanner;

public class RunNote
{
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args)
    {
        NextNote test = new NextNote();
        showMenu(test);
        closeKeyboard();
    }

    public static void showMenu(NextNote notebook)
    {
        int whatmenu = 0;

        while (whatmenu != 5)
        {
            // 추가해야할것:
            // 1. 폰트수정에 이탤릭체 옵션
            // 2. 새노트에 카테고리 설정 부분
            // 3. 카테고리생성,삭제,열람

            System.out.println("ㅁㅁㅁㅁㅁㅁ  WELCOME TO THE NEXT NOTE!!!  ㅁㅁㅁㅁㅁㅁ");
            System.out.println();
            System.out.println("\t MENU:");
            System.out.println("\t\t 1. 새노트");
            System.out.println("\t\t 2. 노트열람");
            System.out.println("\t\t 3. 폰트수정");
            System.out.println("\t\t 4. 노트삭제");
            System.out.println("\t\t 5. 노트수정");
            System.out.println("\t\t 6. 종료");
            System.out.print("\t\t\t           ? ");
            whatmenu = Integer.parseInt(keyboard.nextLine());
            switch (whatmenu)
            {
            case 1:
                inputNote(notebook);
                break;
            case 2:
                viewNoteList(notebook);
                break;
            case 3:
                inputFont(notebook);
                break;
            case 4:
                removeNote(notebook);
                break;
            }
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

    public static void inputNote(NextNote notebook)
    {
        String title, contents, font, category;
        int fontsize;

        System.out.println("-----새노트-----");
        System.out.print("제목: ");
        title = keyboard.nextLine();
        System.out.print("카테고리: "); // 안넣는경우 처리해주기
        category = keyboard.nextLine();
        System.out.print("내용: ");
        contents = keyboard.nextLine();
        System.out.print("폰트: ");
        font = keyboard.nextLine();
        System.out.print("폰트 사이즈: ");
        fontsize = Integer.parseInt(keyboard.nextLine());

        notebook.createNote(title, contents, font, fontsize, category);
    }

    public static void inputFont(NextNote notebook)
    {
        String font;
        int targetId, fontsize;

        System.out.println("-----폰트수정-----");
        System.out.print("수정할 노트의 아이디: ");
        targetId = Integer.parseInt(keyboard.nextLine());
        System.out.print("폰트: ");
        font = keyboard.nextLine();
        System.out.print("폰트 사이즈: ");
        fontsize = Integer.parseInt(keyboard.nextLine());

        notebook.modifyNoteFont(targetId, font, fontsize);
    }

    public static void viewNoteList(NextNote notebook)
    {
        int targetId;

        System.out.println("-----노트열람-----");
        System.out.println("아이디\t제목\t\t\t\t생성날짜");
        System.out.println(notebook.viewNoteList());

        System.out.print("열람할 노트의 아이디: ");
        targetId = Integer.parseInt(keyboard.nextLine());
        System.out.println(notebook.viewNote(targetId));
    }

    public static void removeNote(NextNote notebook)
    {
        int targetId;

        System.out.println("-----노트삭제-----");
        System.out.print("삭제할 노트의 아이디: ");
        targetId = Integer.parseInt(keyboard.nextLine());
        notebook.removeNote(targetId);
    }

    public void ShowFont(String[] availableFonts)
    {
        System.out.println("-----폰트목록-----");
        for (String s : availableFonts)
        {
            System.out.println(s);
        }
    }

    public static void closeKeyboard()
    {
        keyboard.close();
    }
}
