package 브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_1759_브루트포스2 {

  // https://www.acmicpc.net/problem/1759

  private static BufferedWriter bufferedWriter;
  private static char[] chars;
  private static int L = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    L = Integer.parseInt(stringTokenizer.nextToken());
    int C = Integer.parseInt(stringTokenizer.nextToken());

    chars = new char[C];

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    for (int i = 0; i < stringTokenizer.countTokens(); i++) {
      chars[i++] = (stringTokenizer.nextToken().charAt(0));
    }

    Arrays.sort(chars); //사전 순으로 출력되어야 함.

    generatePassword("", 0);

    bufferedWriter.flush();

    bufferedReader.close();
    bufferedWriter.close();
  }

  public static void generatePassword(String password, int currentIndex)
      throws IOException {

    if (password.length() == L) {
      int vowelCount = 0, consonantCount = 0;

      for (char c : password.toCharArray()) {
        //검사하려는 문자의 개수가 적어서 성능 차이 미미하므로 가독성을 위해 "aeiou".contains(String.valueOf(c) 로 작성 해도 되지만 코딩 테스트 환경이므로 if 문을 사용.
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
          vowelCount++;
        } else {
          consonantCount++;
        }
      }

      if (vowelCount >= 1 && consonantCount >= 2) {
        bufferedWriter.write(password + "\n");
      }

      return;
    }

    // chars가 사전 순으로 정렬되어 있고, 암호 배열의 순서도 사전순이므로 currentIndex 를 조정하여 현재 문자보다 이전 순서의 문자는 체크 x
    for (int i = currentIndex; i < chars.length; i++) {
      generatePassword(password + chars[i], i + 1);
    }
  }
}
