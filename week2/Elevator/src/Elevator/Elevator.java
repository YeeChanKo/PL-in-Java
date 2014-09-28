// TO DO
// P209 [6-1~5]

package Elevator;

public class Elevator
{
    int floor;

    Elevator()
    {
        // this.floor = 1; ¶Ç´Â...
        this(1);
    }

    Elevator(int floor)
    {
        this.floor = floor;
    }

    void moveUp()
    {
        moveUp(10);
    }

    void moveUp(int floor)
    {
        if (floor <= this.floor || floor > 10)
        {
            return;
        }
        this.floor = floor;
    }

    void moveDown()
    {
        moveDown(1);
    }

    void moveDown(int floor)
    {
        if (floor >= this.floor || floor < 1)
        {
            return;
        }
        this.floor = floor;
    }

    public static void main(String[] args)
    {
        Elevator ev1 = new Elevator(1);

    }

}
