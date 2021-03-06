package player;

import java.util.ArrayList;

public class Player
{
    private ArrayList<Frame> Log = new ArrayList<Frame>();

    public Player()
    {
        // 초기화 작업
        for (int i = 0; i < 10; i++)
        {
            Frame temp = new Frame();
            Log.add(i, temp);
        }
    }

    public void AddLog(int fNumber, int bNumber, int bResult)
    {
        if (bNumber == 1) // 첫볼일때 프레임 생성해서 넣어줌
        {
            Frame temp;
            if (fNumber != 10)
            {
                temp = new Frame();
            }
            else
            {
                temp = new LastFrame();
            }
            temp.SetBowlResult(bNumber, bResult);
            Log.add(fNumber - 1, temp);
        }
        else
        {
            Frame temp = Log.get(fNumber - 1);
            temp.SetBowlResult(bNumber, bResult);
        }
    }

    public int GetLog(int fNumber, int bNumber)
    {
        return Log.get(fNumber - 1).GetBowlResult(bNumber);
    }

    public int GetBowlSum(int fNumber) // 10번째 프레임이라도 앞의 두개만 더함
    {
        return Log.get(fNumber - 1).GetBowlResult(1) + Log.get(fNumber - 1).GetBowlResult(2);
    }

    public void SetFrameResult(int fNumber, int fResult)
    {
        Frame temp = Log.get(fNumber - 1);
        temp.frameResult = fResult;
    }

    public int GetFrameResult(int fNumber)
    {
        return Log.get(fNumber - 1).frameResult;
    }
}