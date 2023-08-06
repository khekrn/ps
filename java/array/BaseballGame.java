package array;

import java.util.Stack;

/**
 *  Baseball Game
 *
 * https://leetcode.com/problems/baseball-game/
 * You are keeping the scores for a baseball game with 
 * strange rules. At the beginning of the game, you start 
 * with an empty record.
 * 
 * You are given a list of strings operations, where 
 * operations[i] is the ith operation you must apply to 
 * the record and is one of the following:
 * 
 * An integer x.
 *  - Record a new score of x.
 * 
 * '+'.
 *  - Record a new score that is the sum of the previous two scores.
 * 
 * 'D'.
 *  - Record a new score that is the double of the previous score.
 * 
 * 'C'.
 *  - Invalidate the previous score, removing it from the record.
 * 
 * Return the sum of all the scores on the record after applying all the 
 * operations.
 * 
 * 
 * Example:
 * Input: ops = ["5","2","C","D","+"]
 * Output: 30
 * Explanation:
 * "5" - Add 5 to the record, record is now [5].
 * "2" - Add 2 to the record, record is now [5, 2].
 * "C" - Invalidate and remove the previous score, record is now [5].
 * "D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
 * "+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
 * The total sum is 5 + 10 + 15 = 30.
 * 
 */
public class BaseballGame {

    public int calPoints(String[] operations) {
        var stack = new Stack<Integer>();
        for(String op : operations){
            switch (op){
                case "+":
                    var p1 = stack.pop();
                    var p2 = stack.peek();
                    stack.push(p1);
                    stack.push(p1 + p2);
                    break;
                case "D":
                    stack.push(2 * stack.peek());
                    break;
                case "C":
                    stack.pop();
                    break;
                default :
                    stack.push(Integer.parseInt(op));
                    break;
            }
        }
        var sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        var baseBallGame = new BaseballGame();
        var operations = new String[]{"1","C"};
        System.out.println(baseBallGame.calPoints(operations));
    }
}
