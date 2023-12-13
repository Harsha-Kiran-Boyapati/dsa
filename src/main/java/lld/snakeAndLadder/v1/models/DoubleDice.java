package lld.snakeAndLadder.v1.models;

public class DoubleDice extends Dice{
    public int roll(){
        return super.roll() + super.roll();
    }
}
