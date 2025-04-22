package leetcode.binarytree.serializeanddeserializenarytree;
//https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/description/
import java.util.*;
class Node {
    int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {val = _val;}

    public Node(int _val, List<Node> _children) {}

}

//dfs method

public class Solution {
    final String X = "X";
    final String COMMA = ",";

    StringBuilder sb = new StringBuilder();

    public String serialize(Node root) {
        if (root == null) {
            return X;
        }
        encode(root);
        int size = sb.length();
        sb.deleteCharAt(size - 1);
        return sb.toString();
    }

    private void encode(Node root) {
        //add current node
        sb.append(root.val);
        sb.append(COMMA);
        //traverse the children

        List<Node> children = root.children;
        if(children.size() > 0){
            for(Node child : root.children){
                encode(child);
            }
        }
        sb.append(X);
        sb.append(COMMA);
    }


    String[] dataArr;
    int index = 0;
    public Node deserialize(String data) {
        System.out.println(data);
        dataArr = data.split(COMMA);
        return decode();
    }

    private Node decode() {
        String currentItem = dataArr[index++];
        if(currentItem.equals(X)){
            return null;
        }
        //build the children
        List<Node> children = new LinkedList<>();
        while(index < dataArr.length){
            Node child = decode();
            if(child != null) {
                children.add(child);
            } else {
                break;
            }
        }
        // build the current node
        Node root = new Node(Integer.parseInt(currentItem), children);
        return root;
    }



}
