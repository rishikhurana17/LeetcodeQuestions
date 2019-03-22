package LeetcodePrograms;
import java.util.*;
/**
 * Created by rkhurana on 3/21/19.
 */
public class NaryTreeNode {
    String data;
    List<NaryTreeNode> children = null;
    public NaryTreeNode(String data) {
        this.data = data;
        this.children = new ArrayList<NaryTreeNode>();
    }
    public void addChild(NaryTreeNode child) {
        this.children.add(child);
    }
}
