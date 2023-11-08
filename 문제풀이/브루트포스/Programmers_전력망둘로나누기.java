package 브루트포스;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Programmers_전력망둘로나누기 {

  // https://school.programmers.co.kr/learn/courses/30/lessons/86971

  public static void main(String[] args) {
    int n = 9;
    int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};

    // wires = 간선 정보. 1,3 or 3,1 두 경우는 없음
    // wires 를 전부 탐색하여, 1번째 간선이 없을 때
    // 간선에 연결된 두 노드 각각의 하위 노드 개수 차이 중
    // 가장 적은 값을 return

    List<LinkedList<Integer>> towerTree = makeTowerTree(n, wires);

    int answer = 999;
    for (int[] wire : wires) {
      towerTree.get(wire[0]-1).remove(Integer.valueOf(wire[1]-1));
      towerTree.get(wire[1]-1).remove(Integer.valueOf(wire[0]-1));

      int first = getConnectedTowerCountByBfs(towerTree, wire[0]-1);
      int second = getConnectedTowerCountByBfs(towerTree, wire[1]-1);

      answer = Math.min(answer, Math.abs(first - second));

      towerTree.get(wire[0]-1).add(wire[1]-1);
      towerTree.get(wire[1]-1).add(wire[0]-1);
    }

    System.out.println(answer);
  }

  public static int getConnectedTowerCountByBfs(List<LinkedList<Integer>> towerTree, Integer rootNode) {
    Queue<Integer> bfsQueue = new LinkedList<>();
    boolean[] visited = new boolean[towerTree.size()];
    int count = 0;

    //root node 추가
    bfsQueue.add(rootNode);

    while (!bfsQueue.isEmpty()) {
      int nextNode = bfsQueue.poll();
      visited[nextNode] = true;
      count++;

      for (Integer node : towerTree.get(nextNode)) {
        if (visited[node]) {
          continue;
        }

        bfsQueue.add(node);
      }
    }

    return count;
  }

  public static int getConnectedTowerCountByDfs(List<LinkedList<Integer>> towerTree, Integer rootNode) {
    Queue<Integer> bfsQueue = new LinkedList<>();
    boolean[] visited = new boolean[towerTree.size()];
    int count = 0;

    //root node 추가
    bfsQueue.add(rootNode);

    while (!bfsQueue.isEmpty()) {
      int nextNode = bfsQueue.poll();
      visited[nextNode] = true;
      count++;

      for (Integer node : towerTree.get(nextNode)) {
        if (visited[node]) {
          continue;
        }

        bfsQueue.add(node);
      }
    }

    return count;
  }

  public static List<LinkedList<Integer>> makeTowerTree(int totalNodeCount, int[][] wires) {
    List<LinkedList<Integer>> towerTree = new ArrayList<>();

    for (int i = 0; i < totalNodeCount; i++) {
      towerTree.add(new LinkedList<>());
    }

    for (int[] wire : wires) {
      towerTree.get(wire[0] - 1).add(wire[1] - 1);
      towerTree.get(wire[1] - 1).add(wire[0] - 1);
    }

    return towerTree;
  }
}
