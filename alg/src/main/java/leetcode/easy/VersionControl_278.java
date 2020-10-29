package leetcode.easy;

/**
 *
 * @Author jiahao
 * @Date 2020/10/29 21:44
 */
public class VersionControl_278 {

    public int firstBadVersion(int n) {
        int low = 0;
        int high = n;
        while (low <= high){
           int mid = low + (high - low) / 2;
           if(isBadVersion(mid)){
                // 左
                high = mid - 1;
           }else {
               low = mid + 1;
           }
        }
        return low;
    }

    private boolean isBadVersion(int mid) {
    }
}
