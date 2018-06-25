class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites)
            indegree[prerequisite[0]]++;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++){
            if (indegree[i] == 0)
                queue.offer(i);
        }
        int j = 0;
        while (!queue.isEmpty()){
            int course = queue.poll();
            res[j] = course;
            for(int[] prerequisite: prerequisites){
                if (course == prerequisite[1]){
                    indegree[prerequisite[0]]--;
                    if (indegree[prerequisite[0]] == 0)
                        queue.offer(prerequisite[0]);
                }
            }
            j++;
        }

        for (int i : indegree){
            if (i != 0) return new int[0];
        }
        return res;
    }
}
