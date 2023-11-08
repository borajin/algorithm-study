package 브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon_14888_연산자끼워넣기 {

  // https://www.acmicpc.net/problem/14888

  private static int max = Integer.MIN_VALUE;
  private static int min = Integer.MAX_VALUE;

  private static int[] numbers;

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    //숫자 개수
    int numberCount = Integer.parseInt(bufferedReader.readLine());
    numbers = new int[numberCount];

    //숫자 목록
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for (int i = 0; i < numberCount; i++) {
      numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    //연산자 개수
    int[] operatorCounts = new int[4];
    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for (int i = 0; i < operatorCounts.length; i++) {
      operatorCounts[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    getMaxAndMin(operatorCounts, 0, numbers[0]);

    bufferedWriter.write(max + "\n" + min);

    bufferedReader.close();
    bufferedWriter.close();
  }

  public static void getMaxAndMin(int[] operatorCounts, int depth, int result) {

    if (depth == numbers.length - 1) {
      max = Math.max(max, result);
      min = Math.min(min, result);
    }

    for (int i = 0; i < operatorCounts.length; i++) {
      if (operatorCounts[i] != 0) {
        operatorCounts[i]--;
        getMaxAndMin(operatorCounts, depth + 1, calculate(result, numbers[depth + 1], i));
        operatorCounts[i]++;
      }
    }
  }

  public static int calculate(int a, int b, int operatorIndex) {
    if (operatorIndex == 0) {
      return a + b;
    } else if (operatorIndex == 1) {
      return a - b;
    } else if (operatorIndex == 2) {
      return a * b;
    } else if (operatorIndex == 3) {
      return a / b;
    } else {
      return -999;
    }
  }
}
