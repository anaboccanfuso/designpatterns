package state;
import java.util.Scanner;

public class ArithemeticGame {
    private State easyState;
    private State mediumState;
    private State hardState;

    private State state;
    private int score = 0;
    Scanner keyboard;

    public ArithemeticGame() {
        easyState = new Easy(this);
        mediumState = new Medium(this);
        hardState = new Hard(this);

        state = new Easy(this);
        keyboard = new Scanner(System.in);

        this.score = 0;
    }

    public void pressQuestionButton() {
        int num1 = state.getNum();
        int num2 = state.getNum();
        String op = state.getOperation();
        System.out.print(num1 + " " + op + " " + num2 + ": ");
        int answer = keyboard.nextInt();
        keyboard.nextLine();
        if(op.equals("+")) {
            if(answer == (num1+num2)) {
                System.out.println("Correct");
                score++;
            }
            else {
                System.out.println("Incorrect");
                score--;
            }
        }
        else if(op.equals("-")) {
            if(answer == (num1-num2)) {
                System.out.println("Correct");
                score++;
            }
            else {
                System.out.println("Incorrect");
                score--;
            }
        }
        else if(op.equals("*")) {
            if(answer == (num1*num2)) {
                System.out.println("Correct");
                score++;
            }
            else {
                System.out.println("Incorrect");
                score--;
            }
        }
        else {
            if(answer == (num1/num2)) {
                System.out.println("Correct");
                score++;
            }
            else {
                System.out.println("Incorrect");
                score--;
            }
        }
        if(score >= 3) {
            state.levelUp();
            score = 0;
        }
        else if(score <= -3) {
            state.levelDown();
            score = 0;
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getEasyState() {
        return easyState;
    }

    public State getMediumState() {
        return mediumState;
    }

    public State getHardState() {
        return hardState;
    }
}
