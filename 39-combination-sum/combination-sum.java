class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort — pruning-க்கு help ஆகும்
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int remaining,
                                   int start, List<Integer> current,
                                   List<List<Integer>> result) {
        // Base case — found!
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Prune — candidate too big, sorted ஆனதால் மத்தவையும் skip
            if (candidates[i] > remaining) break;

            current.add(candidates[i]);                      // Choose
            backtrack(candidates, remaining - candidates[i], // Explore
                      i, current, result);                   // i again! (reuse allowed)
            current.remove(current.size() - 1);             // Un-choose (backtrack)
        }
    }
}