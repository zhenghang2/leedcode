package problem1;

import java.util.ArrayList;
import java.util.LinkedList;

public class CourseSchedule207 {

  public static void main(String[] args) {
    CourseSchedule207 c = new CourseSchedule207();
    int[][] prerequisites = {{1,0}};
    System.out.println(c.canFinish(2,prerequisites));
  }
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (numCourses <= 0) {
      return false;
    }
    int row = prerequisites.length;

    if (row == 0) {
      return true;
    }

    int[] inDegree = new int[numCourses];
    for (int[] p : prerequisites) {
      inDegree[p[0]]++;
    }

    LinkedList<Integer> queue = new LinkedList<Integer>();
    for (int i = 0; i<numCourses; i++) {
      if (inDegree[i] == 0) {
        queue.addLast(i);
      }
    }
    ArrayList<Integer> res = new ArrayList<Integer>();
    while (!queue.isEmpty()) {
      int i = queue.removeFirst();
      res.add(i);
      for (int[] p: prerequisites) {
        if (p[1] == i) {
          inDegree[p[0]]--;
          if (inDegree[p[0]] == 0) {
            queue.addLast(p[0]);
          }
        }
      }
    }
    return res.size() == numCourses;
  }
}
