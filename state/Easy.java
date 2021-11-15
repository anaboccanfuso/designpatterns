package state;
import java.util.Random;

public class Easy implements State {
    private ArithemeticGame game;

    public Easy(ArithemeticGame game) {
        this.game = game;
    }

    public int getNum() {
        Random r = new Random();
        return r.nextInt(10) + 1;
    }

    public String getOperation() {
        Random r = new Random();
        int result = r.nextInt(2);
        if(result == 0) {
            return "+";
        }
        else {
            return "-";
        }
    }

    public void levelUp() {
        System.out.println("You've been advanced to medium mode.");
        game.setState(game.getMediumState());
    }

    public void levelDown() {
        System.out.println("You seem to be struggling, you may want to study.");
    }
}
