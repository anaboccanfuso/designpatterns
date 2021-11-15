package state;
import java.util.Random;

public class Hard implements State {
    private ArithemeticGame game;

    public Hard(ArithemeticGame game) {
        this.game = game;
    }

    public int getNum() {
        Random r = new Random();
        return r.nextInt(100) + 1;
    }

    public String getOperation() {
        Random r = new Random();
        int result = r.nextInt(4);
        if(result == 0) {
            return "+";
        }
        else if(result == 1) {
            return "-";
        }
        else if(result == 2) {
            return "*";
        }
        else {
            return "/";
        }
    }

    public void levelUp() {
        System.out.println("You are doing so well!!!");
    }

    public void levelDown() {
        System.out.println("You are struggling, let's go to medium mode.");
        game.setState(game.getMediumState());
    }
}
