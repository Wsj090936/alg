package leetcode.base;

import java.util.List;

/**
 *
 * @Author jiahao
 * @Date 2020/9/8 20:04
 */

public class Node {
    public int val;
    public List<Node> children;
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
