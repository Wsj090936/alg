package leetcode.interview;

import java.util.List;

/**
 * TODO
 *
 * @Author jiahao
 * @Date 2021/2/3 21:22
 */
public class FindLocation {
    //

    private int findLocation(LocationNode locationNode){
        if(locationNode.getLevel() != 1){
            return 0;
        }
        // 取到所有市
        List<LocationNode> locationList = locationNode.getLocationList();
        int res = 0;
        for(LocationNode each : locationList){
            // 理论上这一层是市
            if(each.getLevel() == 2){
                res = each.getLocationList().size() > 5 ? res + 1 : res;
            }
        }
        return res;
    }

}
