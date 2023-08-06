package array

import (
	"strconv"
)

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

func CalPoints(operations []string) int {
	stack := make([]int, 0, len(operations))
	for i := 0; i < len(operations); i++ {
		switch operations[i] {
		case "C":
			stack = stack[0 : len(stack)-1]
		case "D":
			stack = append(stack, stack[len(stack)-1]*2)
		case "+":
			stack = append(stack, stack[len(stack)-1]+stack[len(stack)-2])
		default:
			value, _ := strconv.Atoi(operations[i])
			stack = append(stack, value)
		}
	}

	sum := 0
	for _, value := range stack {
		sum += value
	}
	return sum
}
