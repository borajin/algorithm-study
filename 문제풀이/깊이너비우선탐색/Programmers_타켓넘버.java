package 깊이너비우선탐색;

public class Programmers_타켓넘버 {

  //https://school.programmers.co.kr/learn/courses/30/lessons/43165

  public static void main(String[] args) {
    int[] numbers = {1,1,1,1,1};
    int target = 3;

    int answer = getAnswer(numbers, target, 0, 0);

    System.out.println(answer);
  }

  public static int getAnswer(int[] numbers, int target, int position, int sum) {
    if (position == numbers.length) {
      if (sum == target) {
        return 1;
      }

      return 0;
    }

    return getAnswer(numbers, target, position + 1, sum + numbers[position]) + getAnswer(numbers, target, position + 1, sum - numbers[position]);
  }
}
