package scorer;

import player.Player;

// 입력된 값을 조회해서 스크린에 표시될 값을 계산(string)

public class Scorer
{
    public static void ShowScoreBoard(Player[] playersTable, int pNumber, int fNumber, int bNumber) // 어디까지 진행됐는지 pNumber로 체크
    {
        int frameResultSum[] = new int[10]; // 사람 수만큼

        String top = "[선수]\t[1]\t[2]\t[3]\t[4]\t[5]\t[6]\t[7]\t[8]\t[9]\t[10]";
        System.out.println(top);

        // ----------------------------------------------------------------------------진행중선수전
        for (int p = 1; p < pNumber; p++) // pNumber가 현재 진행중인 선수의 번호
        {
            Player player = playersTable[p - 1];
            String middle = "  \t";
            String bottom = " " + p + "번" + "\t";

            for (int f = 1; f <= fNumber; f++)
            {
                FrameResultCalculator(player, f);
                frameResultSum[p - 1] += player.GetFrameResult(f);
                bottom += frameResultSum[p - 1] + "\t";

                if (f != 10)
                {
                    middle += ShowFirstBowlResult(player, f) + " " + ShowSecondBowlResult(player, f) + "\t";
                }
                else
                {
                    middle += ShowLastFrameBowlResult(player, 3, p, frameResultSum); // 마지막 프레임: 세번째 볼까지 나오게
                }
            }
            System.out.println(middle);
            System.out.println(bottom);
        }

        // ----------------------------------------------------------------------------진행중선수
        for (int a = 1; a < 2; a++) // 딱한번만실행됨 지역변수로만들어주기위해for에의도적으로넣음
        {
            Player player = playersTable[pNumber - 1];
            String middle = "  \t";
            String bottom = " " + pNumber + "번" + "\t";

            for (int f = 1; f < fNumber; f++)
            {
                middle += ShowFirstBowlResult(player, f) + " " + ShowSecondBowlResult(player, f) + "\t";
                FrameResultCalculator(player, f);
                frameResultSum[pNumber - 1] += player.GetFrameResult(f);
                bottom += frameResultSum[pNumber - 1] + "\t";
            }

            if (fNumber != 10)
            {
                if (bNumber == 1)
                {
                    middle += ShowFirstBowlResult(player, fNumber);
                }
                else
                {
                    middle += ShowFirstBowlResult(player, fNumber) + " " + ShowSecondBowlResult(player, fNumber) + "\t";
                    FrameResultCalculator(player, fNumber);
                    frameResultSum[pNumber - 1] += player.GetFrameResult(fNumber);
                    bottom += frameResultSum[pNumber - 1] + "\t";
                }
            }
            else
            {
                middle += ShowLastFrameBowlResult(player, bNumber, pNumber, frameResultSum);
                FrameResultCalculator(player, fNumber);
                frameResultSum[pNumber - 1] += player.GetFrameResult(fNumber);
                bottom += frameResultSum[pNumber - 1] + "\t";
            }

            System.out.println(middle);
            System.out.println(bottom);
        }

        // ----------------------------------------------------------------------------진행중선수후
        for (int p = pNumber + 1; p <= playersTable.length; p++) // pNumber가 현재 진행중인 선수의 번호
        {
            Player player = playersTable[p - 1];
            String middle = "  \t";
            String bottom = " " + p + "번" + "\t";

            for (int f = 1; f < fNumber; f++)
            {
                middle += ShowFirstBowlResult(player, f) + " " + ShowSecondBowlResult(player, f) + "\t";
                FrameResultCalculator(player, f);
                frameResultSum[p - 1] += player.GetFrameResult(f);
                bottom += frameResultSum[p - 1] + "\t";
            }
            System.out.println(middle);
            System.out.println(bottom);
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

    public static String ShowLastFrameBowlResult(Player player, int bNumber, int pNumber, int[] frameResultSum)
    {
        String bResultToScreen;
        int bResult1 = player.GetLog(10, 1);
        int bResult2 = player.GetLog(10, 2);
        int bResult3 = player.GetLog(10, 3);

        if (bNumber == 1)
        {
            bResultToScreen = FirstBowlCharacter(bResult1);
        }
        else if (bNumber == 2)
        {
            if (player.GetBowlSum(10) < 10 && bResult3 == 0) // 두번 밖에 못 굴린 경우
            {
                bResultToScreen = FirstBowlCharacter(bResult1) + " " + SecondBowlCharacter(bResult1, bResult2);
            }
            else if (player.GetBowlSum(10) == 10 && bResult1 != 10) // 두번째 볼로 스페어 처리한 경우
            {
                bResultToScreen = FirstBowlCharacter(bResult1) + " " + SecondBowlCharacter(bResult1, bResult2);
            }
            else if (bResult1 == 10 && bResult2 != 10) // 첫번째 볼 스트라이크, 두번째 볼 노스트라이크
            {
                bResultToScreen = FirstBowlCharacter(bResult1) + " " + FirstBowlCharacter(bResult2);
            }
            else
            // 첫번째, 두번째 볼 스트라이크
            {
                bResultToScreen = FirstBowlCharacter(bResult1) + " " + FirstBowlCharacter(bResult2);
            }
        }
        else
        {
            if (player.GetBowlSum(10) < 10 && bResult3 == 0) // 두번 밖에 못 굴린 경우
            {
                bResultToScreen = FirstBowlCharacter(bResult1) + " " + SecondBowlCharacter(bResult1, bResult2);
            }
            else if (player.GetBowlSum(10) == 10 && bResult1 != 10) // 두번째 볼로 스페어 처리한 경우
            {
                bResultToScreen = FirstBowlCharacter(bResult1) + " " + SecondBowlCharacter(bResult1, bResult2) + " " + FirstBowlCharacter(bResult3);
            }
            else if (bResult1 == 10 && bResult2 != 10) // 첫번째 볼 스트라이크, 두번째 볼 노스트라이크
            {
                bResultToScreen = FirstBowlCharacter(bResult1) + " " + FirstBowlCharacter(bResult2) + " " + SecondBowlCharacter(bResult2, bResult3);
            }
            else
            // 첫번째, 두번째 볼 스트라이크
            {
                bResultToScreen = FirstBowlCharacter(bResult1) + " " + FirstBowlCharacter(bResult2) + " " + FirstBowlCharacter(bResult3);
            }
        }

        return bResultToScreen;
    }

    public static void FrameResultCalculator(Player player, int fNumber)
    {
        int fResult;

        if (player.GetBowlSum(fNumber) == 10 && fNumber != 10) // 스트라이크나 스페어이고 마지막 프레임이 아니다
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
        else if (player.GetBowlSum(fNumber) >= 10 && fNumber == 10)
        {
            fResult = player.GetLog(10, 1) + player.GetLog(10, 2) + player.GetLog(10, 3);
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

        if (nextFrameBowlResult1 == 10 && fNumber + 1 != 10) // 다음 프레임에 스트라이크가 났고 다음 프레임은 마지막 프레임이 아니다
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