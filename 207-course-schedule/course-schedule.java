class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            preMap.get(pair[0]).add(pair[1]);
        }

        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, preMap, visiting, visited)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int course, Map<Integer, List<Integer>> preMap,
                        Set<Integer> visiting, Set<Integer> visited) {
        if (visiting.contains(course)) return false; // cycle detected
        if (visited.contains(course)) return true;   // already verified

        visiting.add(course);
        for (int prereq : preMap.get(course)) {
            if (!dfs(prereq, preMap, visiting, visited)) {
                return false;
            }
        }   // if it does not return false then there is no cycle 
        visiting.remove(course); // remove from visiting
        visited.add(course); // add to visited
        return true;
    }
}