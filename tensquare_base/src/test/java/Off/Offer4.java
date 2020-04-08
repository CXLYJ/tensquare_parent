package Off;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/1/13
 */
public class Offer4 {

    public boolean searchArray(int[][] array, int tager){
       if (array == null || array.length < 1)
           return false;
       int m = array.length, n = array[0].length;
       int i = 0, j = n - 1;
       while (i < m && j >= 0){
           if (array[i][j] == tager)
               return true;
           if (array[i][j] < tager)
               ++j;
           else
               j --;
       }
       return false;
    }

}
