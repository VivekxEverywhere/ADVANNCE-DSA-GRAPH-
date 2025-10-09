class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        int indegree[] = new int[numCourses];
        for (int pre[] : prerequisites) {
            int u = pre[0];
            int v = pre[1];

            list.get(v).add(u);
            indegree[u]++;
        }

        int arr[] = new int[numCourses];
        int t = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {

            int curr = q.remove();
            arr[t++] = curr;
            for (int i = 0; i < list.get(curr).size(); i++) {
                int nei = list.get(curr).get(i);

                indegree[nei]--;

                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        return numCourses == t ? arr : new int[]{};
    }
}