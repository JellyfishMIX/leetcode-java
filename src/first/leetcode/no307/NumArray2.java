package first.leetcode.no307;

/**
 * @author JellyfishMIX
 * @date 2020/10/2 14:32
 */
class NumArray2 {

    interface Merger<E> {
        E merge(E a, E b);
    }

    /**
     * Use an array to represent a SegmentTree
     * Recursively specified a SegmentTree requires three data: treeIndex, left boundary of the interval, right boundary of the interval.
     *
     * @author JellyfishMIX
     * @date 2020/9/28 14:01
     */
    public class SegmentTree<E> {
        /**
         * Inside the SegmentTree, organize the data into a tree form. Use an array to represent this tree.
         * The SegmentTree is regarded as a full binary tree, and the deepest non-existent nodes are regarded as empty.
         * length: 4n
         */
        private E[] tree;
        /**
         * store a copy of the entire array in the SegmentTree
         * length: n
         */
        private E[] data;
        /**
         * Defined by the user to define the relationship between the parent node and the child nodes in the segment tree.
         */
        private Merger<E> merger;

        public SegmentTree(E[] arr, Merger<E> merger) {
            this.merger = merger;

            data = arr;
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }
            tree = (E[]) new Object[4 * arr.length];
            buildSegmentTree(0, 0, arr.length - 1);
        }

        /**
         * At the treeIndex position, build a segment tree representing the interval [l, r]
         *
         * @param treeIndex the index of the node in the tree
         * @param l left boundary of the interval
         * @param r right boundary of the interval
         */
        private void buildSegmentTree(int treeIndex, int l, int r) {
            if (l == r) {
                tree[treeIndex] = data[l];
                return;
            }

            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);

            // prevent overflow
            int mid = l + (r - l) / 2;
            buildSegmentTree(leftTreeIndex, l, mid);
            buildSegmentTree(rightTreeIndex, mid + 1, r);

            tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
        }

        public int getSize() {
            return data.length;
        }

        public E get(int index) {
            if (index < 0 || index >= data.length)  {
                throw new IllegalArgumentException("Index is illegal.");
            }
            return data[index];
        }

        /**
         * Returns the index of the left child node of an element represented by an index in the array representation of the complete binary tree.
         *
         * @param index index
         * @return
         */
        public int leftChild(int index) {
            return 2 * index + 1;
        }

        /**
         * Returns the index of the right child node of an element represented by an index in the array representation of the complete binary tree.
         *
         * @param index index
         * @return
         */
        public int rightChild(int index) {
            return 2 * index + 2;
        }

        /**
         * return the interval [queryL, queryR]
         *
         * @param queryL left boundary wanted to query
         * @param queryR right boundary wanted to query
         * @return
         */
        public E query(int queryL, int queryR) {
            if (queryL <0 || queryL >= data.length || queryR <0 || queryR >= data.length) {
                throw new IllegalArgumentException("Index is illegal.");
            }
            return query(0, 0, data.length - 1, queryL, queryR);
        }

        /**
         * search the interval [queryL, queryR] in the interval [queryL, queryR].
         *
         * @param treeIndex tree index
         * @param l left boundary of the interval
         * @param r right boundary of the interval
         * @param queryL left boundary wanted to query
         * @param queryR right boundary wanted to query
         * @return
         */
        private E query(int treeIndex, int l, int r, int queryL, int queryR) {
            if (l == queryL && r == queryR) {
                return tree[treeIndex];
            }

            int mid = l + (r - l) / 2;
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);

            if (queryL >= mid + 1) {
                return query(rightTreeIndex, mid + 1, r, queryL, queryR);
            } else if (queryR <= mid) {
                return query(leftTreeIndex, l, mid, queryL, queryR);
            }

            E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
            E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
            return merger.merge(leftResult, rightResult);
        }

        /**
         * update the value of the specified location
         *
         * @param index specified location
         * @param e element to be replaced
         */
        public void set(int index, E e) {
            if (index < 0 || index >= data.length) {
                throw new IllegalArgumentException("Index is illegal.");
            }

            data[index] = e;
            set(0, 0, data.length - 1, index, e);
        }

        /**
         * update the value of the specified location
         *
         * @param treeIndex specified SegmentTree index
         * @param l left boundary
         * @param r right boundary
         * @param index index of the element to be replaced
         * @param e element
         */
        private void set(int treeIndex, int l, int r, int index, E e) {
            if (l == r) {
                tree[treeIndex] = e;
                return;
            }

            int mid = l + (r - l) / 2;
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            if (index >= mid + 1) {
                set(rightTreeIndex, mid + 1, r, index, e);
            } else {
                set(leftTreeIndex, l, mid, index, e);
            }
            tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
        }
    }

    private SegmentTree<Integer> segmentTree;

    public NumArray2(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        Integer[] data = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }
        segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
    }

    /**
     * time complexity implemented by SegmentTree: O(logn)
     */
    public void update(int i, int val) {
        segmentTree.set(i, val);
    }

    /**
     * time complexity implemented by SegmentTree: O(logn)
     */
    public int sumRange(int i, int j) {
        if (segmentTree == null) {
            throw new IllegalArgumentException("Segment Tree is null.");
        }

        return segmentTree.query(i, j);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
