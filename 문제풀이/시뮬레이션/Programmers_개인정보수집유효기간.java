package 시뮬레이션;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Programmers_개인정보수집유효기간 {
  //https://school.programmers.co.kr/learn/courses/30/lessons/150370

  public static void main(String[] args) {
    // 1. type with month 구하기 - map 이용
    // 2. 유효기간 지난 개인정보 index 검색 후 저장 - 걍... for문과 localdate 이용
    // 3. 오름차순 sort

    String today = "2022.05.19";
    String[] terms = {"A 6", "B 12", "C 3"};

    String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

    Map<String, Integer> typeWithExpirationMonths = new HashMap<>();
    for (String term : terms) {
      String[] termSplit = term.split(" ");
      typeWithExpirationMonths.put(termSplit[0], Integer.parseInt(termSplit[1]));
    }

    ArrayList<Integer> answerList = new ArrayList<>();  // array 사용 시 빈 공간이 0 으로 초기화 됨.

    for (int i = 0; i < privacies.length; i++) {
      String[] privacySplit = privacies[i].split(" ");
      String type = privacySplit[1];
      LocalDate collectionDate = LocalDate.parse(privacySplit[0],
          DateTimeFormatter.ofPattern("yyyy.MM.dd"));

      LocalDate expirationDate = collectionDate.plusMonths(typeWithExpirationMonths.get(type));
      LocalDate todayDate = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"));

      if (todayDate.isEqual(expirationDate) || todayDate.isAfter(expirationDate)) {
        answerList.add(i + 1);
      }
    }

    int[] answer = answerList.stream().mapToInt(i -> i).toArray();
    Arrays.sort(answer);

    System.out.println(answer.toString());
  }
}