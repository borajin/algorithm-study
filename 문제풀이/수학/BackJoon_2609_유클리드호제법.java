package 수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BackJoon_2609_유클리드호제법 {

  //https://www.acmicpc.net/problem/2609

  /* 유클리드 호제법
   *
   * 최대 공약수를 구하는 알고리즘
   *
   * a>b 일 때, a를 b로 나눈 나머지를 r이라고 하면
   * a, b의 최대 공약수와 b, r의 최대 공약수가 같다는 성질을 이용한 알고리즘이다.
   *
   * b를 r로 나눈 나머지를 다시 r로 나누는 과정을 반복하여
   * r이 0이 되었을 때, 나누는 수가 a와 b의 최대 공약수가 된다.
   *
   * => gcd(1071, 1029) = gcd(1029, 42) = gcd(42, 21) = gcd(21, 0), gcd = 21
   *
   * 소인수분해하는 방법은 a, b 의 수가 커질 수록 소인수분해가 어려워진다는 단점이 있다.
   * 유클리드 호제법을 이용하면 효율적으로 최대 공약수를 구할 수 있다.
   *
   * */

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int a = Integer.parseInt(stringTokenizer.nextToken());
    int b = Integer.parseInt(stringTokenizer.nextToken());

    int gcd = gcd(Math.max(a, b), Math.min(a, b));

    bufferedWriter.write(gcd + "\n" + lcm(a, b, gcd));

    bufferedWriter.flush();

    bufferedReader.close();
    bufferedWriter.close();
  }

  public static int gcd(int a, int b) {
    return a % b == 0 ? b : gcd(b, a % b);
  }

  public static int lcm(int a, int b, int gcd) {
    return (a * b) / gcd;
  }
}
