//•요구사항에 대한 모든 기능 구현을 완료했는가?
//•예외사항 처리는 완벽하게 하고 있는가?
//•중복 코드를 최소화하고 있는가?
//•9가지 객체 지향 생활 체조 원칙을 최대한 지키고 있는가?
//•객체 지향 설계 원칙을 최대한 고려하고 있는가?

// game 패키지 - 실행, UI
// player 패키지 - 데이터
// scorer 패키지 - 로직

// 네이밍 컨벤션: 변수는 소문자로 시작, 길어지면 카멜표기로.
// 메소드는 대문자로 시작, 역시 길어지면 카멜표기로.

package game;

import java.util.Scanner;

import player.Player;
import scorer.Scorer;

public class Play
{
    private static Scanner keyboard = new Scanner(System.in);
    private static Player[] playersTable;

    public static void main(String[] args)
    {
        System.out.println("ㅁㅁㅁ NHN NEXT 볼링장에 오신걸 환영합니다!!! ㅁㅁㅁ");
        System.out.println();
        String message = "* 카운터: \"몇분이시죠?\" ";

        int howManyPlayers = GetInt(message);
        playersTable = new Player[howManyPlayers];

        System.out.println();
        System.out.println("(경기가 시작되었다)");
        System.out.println();
        InitPlayersTable(playersTable);
        System.out.println();

        PlayGame(playersTable);

        System.out.println("(경기가 종료되었다)");
        System.out.println();
        
        CloseKeyBoard();
    }

    private static void InitPlayersTable(Player[] playersTable)
    {
        for (int i = 0; i < playersTable.length; i++)
        {
            Player temp = new Player();
            playersTable[i] = temp;
        }
        Scorer.ShowScoreBoard(playersTable, 1, 1, 1);
    }

    private static void PlayGame(Player[] playersTable)
    {
        for (int f = 1; f < 10; f++) // f - frame
        {
            for (int p = 1; p <= playersTable.length; p++) // p - person
            {
                for (int b = 1; b <= 2; b++) // b - bowl
                {
                    int bResult = PlayBowl(f, p, b);
                    System.out.println("---------------------------------");
                    Scorer.ShowScoreBoard(playersTable, p, f, b);
                    if (b == 1 && bResult == 10)
                    {
                        break; // 스트라이크일 경우 두번째 볼 진행 안하고 다음 선수로
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }
        // 마지막 10번째 프레임
        for (int p = 1; p <= playersTable.length; p++)
        {
            for (int b = 1; b <= 3; b++)
            {
                PlayBowl(10, p, b);
                Scorer.ShowScoreBoard(playersTable, p, 10, b);

                // 두번째 볼 끝났는데 스페어나 스트라이크가 안 떴을 때
                if (b == 2 && playersTable[p - 1].GetBowlSum(10) < 10)
                {
                    break;
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // 입력받은 결과값 반환함
    private static int PlayBowl(int fNumber, int pNumber, int bNumber)
    {
        String message = "[" + fNumber + "번째 프레임] " + pNumber + "번 선수의 " + bNumber + "번째 볼: ";
        int bResult = GetInt(message);

        Player player = playersTable[pNumber-1];
        int firstBowl = player.GetLog(fNumber, 1);
        int secondBowl = player.GetLog(fNumber, 2);
        
        // 스페어인 경우만 뽑아내서
        if(bNumber == 2 && fNumber != 10)
        {
            bResult = EnsureSecondBowl(bResult, firstBowl);
        }
        else if(bNumber == 2 && fNumber == 10 && firstBowl != 10)
        {
            bResult = EnsureSecondBowl(bResult, firstBowl);
        }
        else if(bNumber == 3 && fNumber == 10 && firstBowl == 10 && secondBowl != 10)
        {
            bResult = EnsureSecondBowl(bResult, secondBowl);
        }
        
        playersTable[pNumber - 1].AddLog(fNumber, bNumber, bResult);
        return bResult;
    }
    
    private static int EnsureSecondBowl(int secondBowlInput, int firstBowlResult) // 스패어일 경우 범위 제한
    {
        int secondBowlResult = secondBowlInput;
        while(secondBowlResult + firstBowlResult > 10)
        {
            secondBowlResult = GetInt("잘못된 숫자입니다: [한 프레임의 핀 수는 10개]\n다시 입력하세요: ");
        }
        return secondBowlResult;
    }

    private static void CloseKeyBoard()
    {
        keyboard.close();
    }

    private static int GetInt(String request) // 0~10 사이의 값을 받음
    {
        int temp = -1;
        do
        {
            try
            {
                System.out.print(request);
                temp = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e)
            {
                System.out.println("0~10 사이의 값을 입력해주세요!");
            }
        } while (!(temp > -1 && temp < 11));
        return temp;
    }
}