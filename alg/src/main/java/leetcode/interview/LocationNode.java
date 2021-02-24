package leetcode.interview;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Author jiahao
 * @Date 2021/2/3 21:20
 */
public class LocationNode {
    private String location;// 地名
    private Integer level;// 表示当前城市的等级
    private List<LocationNode> locationList = new ArrayList<>();

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<LocationNode> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<LocationNode> locationList) {
        this.locationList = locationList;
    }
}
