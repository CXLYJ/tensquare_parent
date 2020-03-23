package cycOffer;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/12/10
 *
 * 二维数组中的查找
 */
public class Offer4 {

    /**
     * 题目描述
     * @param target
     * @param matrix
     * @return
     */
    /**
     * 解题思路 （动态规划）
     *
     * 要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
     *
     * 该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。因此，从右上角开始查找，
     * 就可以根据 target 和当前元素的大小关系来缩小查找区间，当前元素的查找区间为左下角的所有元素。
     * @param target
     * @param matrix
     * @return
     */
    public static boolean find(int target, int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1; //从右上角开始
        while (r < rows - 1 && c > 0){
            if (target == matrix[r][c])
                return true;
            else if (target > matrix[r][c])
                r ++;
            else
                c --;
        }
        return false;
    }

    public static void main(String[] args) {
      int[][] matrix = {
              {11,4,7,11,15},
              {2,5,8,12,19},
              {3,   6,  9, 16, 22},
              {10, 13, 14, 17, 24},
              {18, 21, 23, 26, 30}
      };

      int target = 9;
        System.out.println(find(target,matrix));

    }

}
                                                                  