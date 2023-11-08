package 이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon_2805_나무자르기 {

  //https://www.acmicpc.net/problem/2805

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    int N = Integer.parseInt(stringTokenizer.nextToken());
    int M = Integer.parseInt(stringTokenizer.nextToken());

    String treeString = bufferedReader.readLine();
    stringTokenizer = new StringTokenizer(treeString);

    int[] trees = new int[N];
    int maxTree = 0;
    for (int i = 0; i < N; i++) {
      trees[i] = Integer.parseInt(stringTokenizer.nextToken());
      maxTree = Math.max(maxTree, trees[i]);
    }

    //'적어도' M미터를 가져가야 하므로 sum >= M 를 만족하는 높이의 범위 low ~ high 중, 최댓값(high) 를 구한다.
    int low = 0;
    int high = maxTree;
    while (low <= high) {
      int mid = (low + high) / 2;
      long sum = 0; //제한 : 10억

      for (int tree : trees) {
        sum += (Math.max(tree - mid, 0));
      }

      if (sum >= M) {
        //너무 많이 잘랐다 = 높이가 작다 = 지금 보다 큰 범위를 탐색한다
        low = mid + 1;
      } else {
        //남는게 없다 = 높이가 크다 = 지금보다 작은 범위를 탐색한다.
        high = mid - 1;
      }
    }

    bufferedWriter.write(high + "\n"); //높이의 '최댓값' 이므로 high 를 return
    bufferedWriter.flush();

    bufferedWriter.close();
    bufferedReader.close();
  }
}
