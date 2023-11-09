package second.leetcode.no304;

/**
 * @link https://leetcode.cn/problems/range-sum-query-2d-immutable/description/
 * @author shijie.qian
 * @date 2023/11/9 23:41
 */
class NumMatrix {
    public final int[][] preSumMatrix;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] preSumMatrix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSumMatrix[i][j] = preSumMatrix[i][j - 1] + preSumMatrix[i - 1][j] - preSumMatrix[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        this.preSumMatrix = preSumMatrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSumMatrix[row2 + 1][col2 + 1] - preSumMatrix[row1][col2 + 1] - preSumMatrix[row2 + 1][col1] + preSumMatrix[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
