import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon_2609_소인수분해 {

  //https://www.acmicpc.net/problem/2609

  /*

  최대공약수, 최소 공배수 구하기 : 서로소가 될 때까지 공약수로 나누기
  최대 공약수 = 공약수들의 곱
  최소 공배수 = 최대 공약수 * 서로소

  */

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int a = Integer.parseInt(stringTokenizer.nextToken());
    int b = Integer.parseInt(stringTokenizer.nextToken());

    int gcd = 1;
    int lcd = 1;

    for (int i = Math.min(a, b); i >= 2; i--) {
      if (a % i == 0 && b % i == 0) {
        a /= i;
        b /= i;

        gcd *= i;
      }
    }

    lcd = gcd * a * b;

    bufferedWriter.write(gcd + "\n" + lcd);

    bufferedWriter.flush();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
