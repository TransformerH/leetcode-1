class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // BFS
        int[] indegree = new int[numCourses];
        for (int[] prerequisite: prerequisites){
            indegree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()){
            int pos = queue.poll();
            for (int[] prerequisite: prerequisites){
                if (pos == prerequisite[1]){
                    indegree[prerequisite[0]]--;
                    if (indegree[prerequisite[0]] == 0)
                        queue.offer(prerequisite[0]);
                }
            }
        }
        for (int i = 0; i < indegree.length; i++){
            if (indegree[i] != 0)
                return false;
        }
        return true;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        // how to solve this using DFS??
    }
}
