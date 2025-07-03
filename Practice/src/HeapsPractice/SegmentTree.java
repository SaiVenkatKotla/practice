package HeapsPractice;

public class SegmentTree {
    private int[] tree;    // Segment Tree array
    private int n;         // Size of the input array

    public SegmentTree(int[] nums) {
        this.n = nums.length;
        int size = 4 * n;  // Safe upper bound
        tree = new int[size];
        build(nums, 0, 0, n - 1);
    }

    // Build the segment tree
    private void build(int[] nums, int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start];
        } else {
            int mid = (start + end) / 2;
            build(nums, 2 * node + 1, start, mid);
            build(nums, 2 * node + 2, mid + 1, end);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    // Query the sum in range [l, r]
    public int query(int l, int r) {
        return query(0, 0, n - 1, l, r);
    }

    private int query(int node, int start, int end, int l, int r) {
        // No overlap
        if (r < start || end < l) return 0;

        // Total overlap
        if (l <= start && end <= r) return tree[node];

        // Partial overlap
        int mid = (start + end) / 2;
        int leftSum = query(2 * node + 1, start, mid, l, r);
        int rightSum = query(2 * node + 2, mid + 1, end, l, r);
        return leftSum + rightSum;
    }

    // Point update: set index idx to value val
    public void update(int idx, int val) {
        update(0, 0, n - 1, idx, val);
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
        } else {
            int mid = (start + end) / 2;
            if (idx <= mid) {
                update(2 * node + 1, start, mid, idx, val);
            } else {
                update(2 * node + 2, mid + 1, end, idx, val);
            }
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }


    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 7, 8, 9};
        SegmentTree st = new SegmentTree(arr);

        System.out.println("Sum of [1, 4]: " + st.query(1, 4));  // Output: 4+5+7+8 = 24

        st.update(2, 10); // arr[2] = 10
        System.out.println("After update, sum of [1, 4]: " + st.query(1, 4));  // Output: 4+10+7+8 = 29
    }
}

