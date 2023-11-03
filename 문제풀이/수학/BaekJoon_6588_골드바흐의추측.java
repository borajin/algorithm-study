package 수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class BaekJoon_6588_골드바흐의추측 {

  // https://www.acmicpc.net/problem/6588

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = 1000000;
    boolean isNothing = true;

    List<Boolean> primaryList = getPrimaryList(1000000);  // 입력받을 때마다 2 ~ n 까지의 소수를 구하는 것보다 한번에 최대범위까지 구해놓고 사용하는 것이 시간복잡도상 효율적이다.

    while (n != 0) {
      n = Integer.parseInt(bufferedReader.readLine());

      for (int a = 3; a <= n; a++) { // 홀수 소수의 합을 구해야 하므로 유일한 짝수 소수인 2 제외
        int b = n - a; // b-a 가 가장 큰 경우는 a가 가장 작은 값일 때다.

        if (primaryList.get(a) && primaryList.get(b)) {
          isNothing = false;
          bufferedWriter.write(n + " = " + a + " + " + b + "\n");
          break;
        }
      }

      if (isNothing) {
        bufferedWriter.write("Goldbach's conjecture is wrong.\n");
      }
    }

    bufferedWriter.flush();

    bufferedReader.close();
    bufferedWriter.close();
  }

  public static List<Boolean> getPrimaryList(int n) {
    List<Boolean> primaryList = new ArrayList<>(n + 1);

    primaryList.add(false);
    primaryList.add(false);

    for (int i = 2; i <= n; i++) {
      primaryList.add(true);
    }

    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (primaryList.get(i)) {
        for (int j = i * i; j <= n; j += i) {
          primaryList.set(j, false);
        }
      }
    }

    return primaryList;
  }
}
