package state;
import java.util.Random;

public class Medium implements State {
    private ArithemeticGame game;

    public Medium(ArithemeticGame game) {
        this.game = game;
    }

    public int getNum() {
        Random r = new Random();
        return r.nextInt(50) + 1;
    }

    public String getOperation() {
        Random r = new Random();
        int result = r.nextInt(3);
        if(result == 0) {
            return "+";
        }
        else if(result == 1) {
            return "-";
        }
        else {
            return "*";
        }
    }

    public void levelUp() {
        System.out.println("You've been advanced to the hardest mode.");
        game.setState(game.getHardState());  
    }

    public void levelDown() {
        System.out.println("You are struggling, let's go to easy mode.");
        game.setState(game.getEasyState());  
    }
}
