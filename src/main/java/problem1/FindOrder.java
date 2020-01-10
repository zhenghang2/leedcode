package problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/** {@link problem1.CourseSchedule207}
 * 都是课程安排问题，通过DFS来进行拓扑排序*/
public class FindOrder {
  public static void main(String[] args) {
    FindOrder fo = new FindOrder();
//    int[][] prerequisite = {{1,0},{2,0},{3,1},{3,2}};
    int[][] prerequisite = {};
    int[] res = fo.findOrderFunction(2,prerequisite);
    for (int i : res) {
      System.out.println(i);
    }
  }

  public int[] findOrderFunction(int numCourses, int[][] prerequisites) {
    if (numCourses<0) {
      return new int[0];
    }
    int row = prerequisites.length;

    if (row == 0) {
      int[] res = new int[numCourses];
      for (int i=0; i<numCourses; i++) {
        res[i] = i;
      }
      return res;
    }
    int[] inDegree = new int[numCourses];
    Arrays.fill(inDegree,0);

    for (int[] p : prerequisites) {
      inDegree[p[0]]++;
    }

    LinkedList<Integer> queue = new LinkedList<Integer>();
    for (int i=0 ;i<numCourses;i++) {
      if (inDegree[i] == 0) {
        queue.addLast(i);
      }
    }
    List<Integer> path = new ArrayList<Integer>();
    while (!queue.isEmpty()) {
      int i = queue.removeFirst();
      path.add(i);
      for (int[] p : prerequisites) {
        if (p[1] == i) {
          inDegree[p[0]]--;
          if (inDegree[p[0]] == 0) {
            queue.addLast(p[0]);
          }
        }
      }
    }
    int[] res ;
    if (path.size() == numCourses) {
      res = new int[numCourses];
      for (int i=0; i<numCourses; i++) {
        res[i] = path.get(i);
      }
      return res;
    } else {
      res = new int[0];
      return res;
    }
  }
}
