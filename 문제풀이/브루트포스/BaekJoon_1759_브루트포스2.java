package 브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon_1759_브루트포스2 {

  // https://www.acmicpc.net/problem/1759

  private static int L = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    List<Character> chars = new LinkedList<>();

    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    L = Integer.parseInt(stringTokenizer.nextToken());
    int C = Integer.parseInt(stringTokenizer.nextToken());

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    while (stringTokenizer.countTokens() != 0) {
      chars.add(stringTokenizer.nextToken().charAt(0));
    }

    Collections.sort(chars); //사전 순으로 출력되어야 함.

    solve(chars, "", bufferedWriter);

    bufferedWriter.flush();

    bufferedReader.close();
    bufferedWriter.close();
  }

  public static void solve(List<Character> chars, String answers,
      BufferedWriter bufferedWriter)
      throws IOException {

    if (answers.length() == L) {
      int vowelCount = 0, consonantCount = 0;
      for (char c : answers.toCharArray()) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
          vowelCount++;
        } else {
          consonantCount++;
        }
      }

      if (vowelCount >= 1 && consonantCount >= 2) {
        bufferedWriter.write(answers + "\n");
      }

      return;
    }

    ArrayList<Character> newChars;
    char lastChar = answers.isBlank() ? ' ' : answers.charAt(answers.length() - 1);

    for (Character c : chars) {
      if (lastChar > c) {
        continue;
      }

      newChars = new ArrayList<>(chars);
      newChars.remove(c);

      solve(newChars, answers + c, bufferedWriter);
    }
  }
}
