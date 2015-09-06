package otros2.amazon.v2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Solution {

  private static final List<Integer> scoreHistory = new LinkedList<Integer>();

  static int totalScore(String[] balls) {
    int totalScore = 0;
    int index = 0;
    for (String ball : balls) {
      int currentScore = 0;
        if (ball.equalsIgnoreCase("z")) { // remove last score
          if (index > 0) {
            int scoreToRemove = scoreHistory.get(index - 1);
            scoreHistory.remove(index - 1);
            currentScore = -1 * scoreToRemove;
            index--;
            totalScore += currentScore;
            continue;
          }
        } else if (ball.equalsIgnoreCase("+")) { // sum of the two last scores
          if (index >= 2) {
            currentScore = scoreHistory.get(index - 1) + scoreHistory.get(index - 2);
          }
        } else if (ball.equalsIgnoreCase("x")) { // double last score
          if (index > 0) {
            currentScore = 2 * scoreHistory.get(index - 1);
          }
        } else {
          try {
            currentScore = Integer.parseInt(ball);
          } catch (NumberFormatException nfe) {
            continue;
          }
        }
        index++;
        scoreHistory.add(currentScore);
        totalScore += currentScore;
    }
    return totalScore;
  }

  public static void main(String[] args) throws IOException {
    System.out.println(totalScore(new String[]{"1", "2", "3", "4", "5", "6", "+", "Z", "X", "+",
        "+" }));
  }
}
