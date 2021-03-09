import array.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        var object = new GameWithNOS();
        var input = new int[]{5, 9, 7, 6};
        System.out.println(Arrays.toString(object.game_with_number(input, input.length)));
    }
    
}