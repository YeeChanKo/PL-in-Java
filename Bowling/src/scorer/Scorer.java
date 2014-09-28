package scorer;

import player.Player;

// 입력된 값을 조회해서 스크린에 표시될 값을 계산(string)

public class Scorer
{
    public static void ShowScoreBoard(Player[] playersTable, int pNumber, int fNumber, int bNumber) // 어디까지 진행됐는지 pNumber로 체크
    {
        String top = "[선수]\t[1]     [2]     [3]     [4]     [5]     [6]     [7]     [8]     [9]     [10]     [총점]";
        System.out.println(top);

        //----------------------------------------------------------------------------진행중선수전
        for (int p = 1; p < pNumber; p++) // pNumber가 현재 진행중인 선수의 번호
        {
            Player player = playersTable[p-1];
            String middle = p + "번" + "\t";

            for (int f = 1; f <= fNumber; f++)
            {
                if(f != 10)
                {
                    middle += ShowFirstBowlResult(player, f) + " " + ShowSecondBowlResult(player, f) + "     ";    
                }
                else
                {
                    middle += LastFrameCalculator(player);
                }
            }
            System.out.println(middle);
        }
        
        //----------------------------------------------------------------------------진행중선수
        for(int a = 1; a < 2; a++) // 딱한번만실행됨 지역변수로만들어주기위해
        {
            Player player = playersTable[pNumber-1];
            String middle = pNumber + "번" + "\t";
            
            for (int f = 1; f < fNumber; f++)
            {
                middle += ShowFirstBowlResult(player, f) + " " + ShowSecondBowlResult(player, f) + "     ";
            }
            
            if(fNumber != 10)
            {
                if (bNumber == 1)
                {
                    middle += ShowFirstBowlResult(player, fNumber);
                }
                else
                {
                    middle += ShowFirstBowlResult(player, fNumber) + " " + ShowSecondBowlResult(player, fNumber) + "     ";            
                }
            }
            else
            {
                middle += LastFrameCalculator(player);
            }
            
            System.out.println(middle);
        }
        
        //----------------------------------------------------------------------------진행중선수후
        for (int p = pNumber + 1; p <= playersTable.length; p++) // pNumber가 현재 진행중인 선수의 번호
        {
            Player player = playersTable[p-1];
            String middle = p + "번" + "\t";

            for (int f = 1; f < fNumber; f++)
            {
                middle += ShowFirstBowlResult(player, f) + " " + ShowSecondBowlResult(player, f) + "     ";
            }
            System.out.println(middle);
        }
    }

    public static String ShowFirstBowlResult(Player player, int fNumber)
    {
        int bResult1 = player.GetLog(fNumber, 1);
        return FirstBowlCharacter(bResult1);
    }

    public static String ShowSecondBowlResult(Player player, int fNumber)
    {
        int bResult1 = player.GetLog(fNumber, 1);
        int bResult2 = player.GetLog(fNumber, 2);
        return SecondBowlCharacter(bResult1, bResult2);
    }
    
    public static String FirstBowlCharacter(int bResult1)
    {
        String bResultToScreen1;
        if (bResult1 == 10)
        {
            bResultToScreen1 = "X"; // 스트라이크
        }
        else if (bResult1 == 0)
        {
            bResultToScreen1 = "-";
        }
        else
        {
            bResultToScreen1 = "" + bResult1;
        }
        return bResultToScreen1;
    }
    
    public static String SecondBowlCharacter(int bResult1, int bResult2)
    {
        String bResultToScreen2;
        if (bResult1 == 10)
        {
            bResultToScreen2 = " "; // 공백 들어감
        }
        else if (bResult2 == 0)
        {
            bResultToScreen2 = "-";
        }
        else if (bResult1 + bResult2 == 10)
        {
            bResultToScreen2 = "/"; // 앞에서 10과 0에 대해 처리해줬기 때문에 (10,0)같은 경우는 들어오지 않음
        }
        else
        {
            bResultToScreen2 = "" + bResult2;
        }
        return bResultToScreen2;
    }
    
    public static String LastFrameCalculator(Player player)
    {
        String bResultToScreen;
        int bResult1 = player.GetLog(10, 1);
        int bResult2 = player.GetLog(10, 2);
        int bResult3 = player.GetLog(10, 3);
        
        if(player.GetBowlSum(10) < 10 && player.GetLog(10, 3) == 0) // 두번 밖에 못 굴린 경우
        {
            bResultToScreen = FirstBowlCharacter(bResult1) + " " + SecondBowlCharacter(bResult1, bResult2) + "     ";
        }
        else if(player.GetBowlSum(10) == 10 && bResult1 != 10) // 두번째 볼로 스페어 처리한 경우
        {
            bResultToScreen = FirstBowlCharacter(bResult1) + " " + SecondBowlCharacter(bResult1, bResult2) + " " + FirstBowlCharacter(bResult3) + "   ";            
        }
        else if(bResult1 == 10 && bResult2 != 10) // 첫번째 볼 스트라이크, 두번째 볼 노스트라이크
        {
            bResultToScreen = FirstBowlCharacter(bResult1) + " " + FirstBowlCharacter(bResult2) + " " + SecondBowlCharacter(bResult2, bResult3) + "   ";
        }
        else // 첫번째, 두번째 볼 스트라이크
        {
            bResultToScreen = FirstBowlCharacter(bResult1) + " " + FirstBowlCharacter(bResult2) + " " + FirstBowlCharacter(bResult3) + "   ";
        }
        
        return bResultToScreen;
    }
    
    public static void FrameResultCalculator(Player player, int fNumber)
    {
        int fResult;

        if (player.GetBowlSum(fNumber) == 10) // 스트라이크나 스페어인 경우
        {
            if (player.GetLog(fNumber, 1) == 10) // 스트라이크
            {
                fResult = StrikeCalculator(player, fNumber);
            }
            else
            // 스페어
            {
                fResult = SpareCalculator(player, fNumber);
            }
        }
        else
        {
            fResult = player.GetBowlSum(fNumber);
        }

        player.SetFrameResult(fNumber, fResult);
    }

    private static int SpareCalculator(Player player, int fNumber)
    {
        int bowlResult1 = player.GetLog(fNumber, 1);
        int bowlResult2 = player.GetLog(fNumber, 2);
        int nextFrameBowlResult1 = player.GetLog(fNumber + 1, 1);
        int fResult = bowlResult1 + bowlResult2 + nextFrameBowlResult1;
        return fResult;
    }

    private static int StrikeCalculator(Player player, int fNumber)
    {
        int bowlResult1 = player.GetLog(fNumber, 1);
        int bowlResult2 = player.GetLog(fNumber, 2);
        int nextFrameBowlResult1 = player.GetLog(fNumber + 1, 1);
        int nextFrameBowlResult2;

        if (nextFrameBowlResult1 == 10) // 다음 프레임에 스트라이크가 났을 때
        {
            nextFrameBowlResult2 = player.GetLog(fNumber + 2, 1); // 다다음 프레임 첫번째 볼 결과
        }
        else
        {
            nextFrameBowlResult2 = player.GetLog(fNumber + 1, 2); // 다음 프레임의 두번째 볼 결과
        }

        int fResult = bowlResult1 + bowlResult2 + nextFrameBowlResult1 + nextFrameBowlResult2;
        return fResult;
    }
}