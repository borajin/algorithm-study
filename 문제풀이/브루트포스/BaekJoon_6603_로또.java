package 브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BaekJoon_6603_로또 {
  // https://www.acmicpc.net/problem/6603

  private static BufferedWriter bufferedWriter;

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer stringTokenizer;

    while (true) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());

      int numberCount = Integer.parseInt(stringTokenizer.nextToken());

      if (numberCount == 0) {
        break;
      }

      int[] numbers = new int[numberCount];
      for (int i = 0; i < numberCount; i++) {
        numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
      }

      makeLottoNumbers(numbers, 0, new Stack<>());
      bufferedWriter.write("\n");
    }

    bufferedWriter.flush();

    bufferedReader.close();
    bufferedWriter.close();
  }

  public static void makeLottoNumbers(int[] numbers, int currentIndex, Stack<Integer> lottoNumbers)
      throws IOException {

    if (lottoNumbers.size() == 6) {
      StringBuilder stringBuilder = new StringBuilder();
      for (int lottoNumber : lottoNumbers) {
        stringBuilder.append(lottoNumber).append(" ");
      }
      bufferedWriter.write(stringBuilder + "\n");
      return;
    }

    //조합 => 순서 상관 없이 기존에 사용한 숫자 사용 x => currentIndex를 하나씩 증가시켜 이전에 사용한 숫자 제외시키기
    for (int i = currentIndex; i < numbers.length; i++) {
      lottoNumbers.add(numbers[i]);
      makeLottoNumbers(numbers, i + 1, lottoNumbers);
      lottoNumbers.pop();
    }
  }
}
