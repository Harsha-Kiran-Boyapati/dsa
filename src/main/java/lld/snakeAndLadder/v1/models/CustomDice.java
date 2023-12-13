package lld.snakeAndLadder.v1.models;

public class CustomDice extends Dice{
    public int roll(){
        int roll1 = super.roll();
        if(roll1!=6) return roll1;
        int roll2 = super.roll();
        if(roll2 !=6) return roll2 + 6;
        int roll3 = super.roll();
        return roll3 == 6 ? 0: roll3+12;
    }
}
