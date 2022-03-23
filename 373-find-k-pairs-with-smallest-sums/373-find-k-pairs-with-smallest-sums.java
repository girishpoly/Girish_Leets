class Solution {
   public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> heap = new PriorityQueue<>((p1, p2) -> p2.getSum() - p1.getSum());
        for (int i = 0; i < Math.min(nums1.length, k); ++i) {
            for (int j = 0; j < Math.min(nums2.length, k); ++j) {
                Pair cur = new Pair(nums1[i], nums2[j]);
                if (heap.size() == k) {
                    if (heap.peek().getSum() > cur.getSum()) {
                        heap.poll();
                        heap.offer(cur);   
                    } else {
                        break;
                    }
                } else {
                    heap.offer(cur);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Pair p: heap) {
            res.add(Arrays.asList(p.x, p.y));
        }
        return res;
    }
    
    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getSum() {
            return x + y;
        }
    }
}
