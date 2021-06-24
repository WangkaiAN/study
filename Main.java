package day49;

import java.util.ArrayList;
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Main {
    public static void main(String[] args) {

    }
    public static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        result = new ArrayList<>();
        if(pRoot == null){
            return result;
        }
        helper(pRoot,0);
        for(int i = 0;i<result.size();i++){
            if(i%2 != 0){
                help(result.get(i));
            }
        }
        return result;
    }
    public void helper(TreeNode root,int level){
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if(root.left != null){
            helper(root.left,level+1);
        }
        if(root.right != null){
            helper(root.right,level+1);
        }
    }
    public void help(ArrayList list){
        int[] arr = new int[list.size()];
        for(int i =0;i<list.size();i++){
            arr[i] = (int)list.get(i);
        }
        for(int i = 0;i<list.size();i++){
            list.set(i,arr[arr.length-1-i]);
        }
    }
}
