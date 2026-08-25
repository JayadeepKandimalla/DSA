class Solution {
    public String frequencySort(String s) {

        HashMap<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq =
            new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
            );

        pq.addAll(freq.entrySet());

        StringBuilder ans = new StringBuilder();

        while (!pq.isEmpty()) {

            Map.Entry<Character, Integer> entry = pq.poll();

            char c = entry.getKey();
            int count = entry.getValue();

            for (int i = 0; i < count; i++) {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}