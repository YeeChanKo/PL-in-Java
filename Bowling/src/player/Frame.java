package player;

public class Frame
{
    protected int[] bowlResult;
    protected int frameResult;
    
    Frame()
    {
        bowlResult = new int[2]; // bowlResult[0],[1]은 0으로 초기화됨
    }
    
    public void SetBowlResult(int bNumber, int bResult) // bNumber: 몇번째 볼인지. 참고로 b는 bowl, f는 frame.
    {
        bowlResult[bNumber-1] = bResult;
    }
    
    public void SetFrameResult(int fResult)
    {
        frameResult = fResult;
    }
    
    public int GetBowlResult(int bNumber)
    {
        return bowlResult[bNumber-1];
    }
    
    public int GetFrameResult()
    {
        return frameResult;
    }
}