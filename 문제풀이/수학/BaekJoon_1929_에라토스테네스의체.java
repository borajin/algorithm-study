package 수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon_1929_에라토스테네스의체 {

  //https://www.acmicpc.net/problem/1929

  /* 에라토스테네스의 체
   *
   * 소수를 구하는 알고리즘
   *
   * 2부터 구하고자 하는 구간의 모든 수를 격자에 나열한다.
   * 2를 오른쪽에 쓰고 2의 배수를 모두 지운다.
   * 지우지 않은 다음 수를 오른쪽에 쓰고 그 수의 배수를 모두 지운다.
   * 위 과정을 반복하면 구하는 구간의 소수만 남는다.
   *
   * 마치 체를 거르듯 구한다 하여 에라토스테네스의 체라는 이름을 가졌다.
   *
   */

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int a = Integer.parseInt(stringTokenizer.nextToken());
    int b = Integer.parseInt(stringTokenizer.nextToken());

    ArrayList<Boolean> primeList = new ArrayList<>();

    primeList.add(false); //0
    primeList.add(false); //1

    // 2 부터 수를 나열
    for (int i = 2; i <= b; i++) {
      primeList.add(true);
    }

    // 2의 배수를 지우고, 그 다음수의 배수를 지우기
    for (int i = 2; i <= Math.sqrt(b); i++) {  //구하려는 구간의 제곱근 이후로는 모든 배수가 지워지기 때문에 제곱근까지만 검사하면 된다.
      if (primeList.get(i)) {
        if (primeList.get(i)) {
          // i의 배수 모두 삭제
          for (int j = i*i; j <= b; j+=i) {   // 중복 처리를 없애기 위해 i*i 로 시작한다. (이미 i 이하의 배수들을 삭제 처리 했으므로)
            primeList.set(j, false);
          }
        }
      }
    }

    // 소수들을 출력한다.
    for (int i = a; i < primeList.size(); i++) {
      if (primeList.get(i)) {
        bufferedWriter.write(i + "\n");
      }
    }

    bufferedWriter.flush();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
