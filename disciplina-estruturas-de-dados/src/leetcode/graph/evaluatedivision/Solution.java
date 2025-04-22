package leetcode.graph.evaluatedivision;
//https://leetcode.com/problems/evaluate-division/description/

import java.util.*;

class Solution {
    private Map<String, List<Pair>> div = new HashMap<>();

    private static class Pair {
        String node;
        double value;

        Pair(String node, double value) {
            this.node = node;
            this.value = value;
        }
    }

    private double bfs(String target, String start) {
        Queue<Pair> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new Pair(start, 1.0));
        visited.add(start);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String currentNode = current.node;
            double currentValue = current.value;

            if (!div.containsKey(currentNode)) {
                break;
            }

            for (Pair neighbor : div.get(currentNode)) {
                if (visited.contains(neighbor.node)) {
                    continue;
                }

                if (neighbor.node.equals(target)) {
                    return currentValue * neighbor.value;
                }

                visited.add(neighbor.node);
                queue.offer(new Pair(neighbor.node, currentValue * neighbor.value));
            }
        }

        return -1.0;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            div.putIfAbsent(a, new ArrayList<>());
            div.putIfAbsent(b, new ArrayList<>());

            div.get(a).add(new Pair(b, value));
            div.get(b).add(new Pair(a, 1.0 / value));
        }

        double[] ans = new double[queries.size()];
        Arrays.fill(ans, -1.0);

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String target = queries.get(i).get(1);

            if (start.equals(target)) {
                if (div.containsKey(start)) {
                    ans[i] = 1.0;
                } else {
                    ans[i] = -1.0;
                }
            } else if (div.containsKey(start)) {
                ans[i] = bfs(target, start);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        double[] values = {2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));

        double[] result = solution.calcEquation(equations, values, queries);

        System.out.println("Output: " + Arrays.toString(result));
    }
}
