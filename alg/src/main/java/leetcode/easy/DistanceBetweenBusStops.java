package leetcode.easy;

/**
 *
 * @Author jiahao
 * @Date 2020/8/29 17:15
 */
public class DistanceBetweenBusStops {
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(distance == null || distance.length == 0){
            return 0;
        }
        // 求顺时针
        int sum = 0;
        for(int each : distance){
            sum += each;
        }
        int res1 = 0;
        for(int i = start;(i) % distance.length != destination;i++){
            i = i % distance.length;
            res1 += distance[i];

        }
//        int res2 = 0;
//        for(int i = destination; i > start;i--){
//            res2 += distance[i];
//            if((i + 1) % distance.length == start){
//                break;
//            }
//        }
        return Math.min(res1,sum - res1);

    }

    public static void main(String[] args) {

        int[] arr = {7,10,1,12,11,14,5,0};
        System.out.println(distanceBetweenBusStops(arr,7,2));
    }
}
