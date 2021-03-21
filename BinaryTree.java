package java42_0318;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}

public class BinaryTree {
    // 通过 lca 这个成员变量来记录最终的结果
    public TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 递归尝试查找 p 和 q
        // 搞一个辅助的方法来进行递归
        findNode(root, p, q);
        return lca;
    }

    // 如果 root 中能够找到 p 或者 q, 找到一个就返回 true.
    // 如果 p 和 q 都没找到, 此时返回 false
    public boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        // 从三个渠道分别查找
        // 判定根节点是不是 p 或者 q
        int mid = (root == p || root == q) ? 1 : 0;
        // 在左子树中查找 p 和 q
        int left = findNode(root.left, p, q) ? 1 : 0;
        // 在右子树中查找 p 和 q
        int right = findNode(root.right, p, q) ? 1 : 0;
        // 最重要的步骤! 判定该节点是否是 lca
        // 如果 p 和 q 是来自于三个渠道中的两个, 就认为该节点是 lca
        if (mid + left + right == 2) {
            lca = root;
        }
        // 方法的最终返回, 找到 p 或者 q 就返回 true
        return (mid + left + right) > 0;
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        // 判定特殊情况
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        // 处理一般情况
        // 1. 先递归的把左子树转成链表
        //    得到的 leftHead 可能是 null, 下面在使用的时候要考虑到这个细节
        TreeNode leftHead = Convert(pRootOfTree.left);
        // 2. 把根节点尾插到 leftHead 这个链表中
        //    需要找到 leftHead 的末尾节点才能尾插
        TreeNode leftTail = leftHead;
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        if (leftHead != null) {
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        // 3. 递归的转换右子树了
        TreeNode rightHead = Convert(pRootOfTree.right);
        // 4. 把当前节点头插到右侧链表的前面
        if (rightHead != null) {
            pRootOfTree.right = rightHead;
            rightHead.left = pRootOfTree;
        }
        // 需要返回这个最终链表的头结点.
        // 注意, leftHead 可能是空链表. 如果是空链表
        // 整体的头结点就应该是 pRootOfTree 了
        return leftHead != null ? leftHead : pRootOfTree;
    }

    // 成员变量, index 表示当前访问到 先序 中的第几个元素
    public int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 由于输入的用例可能有多组, 此处在方法入口这里,
        // 把 index 还原成 0, 防止多个用例之间干扰
        index = 0;
        // 辅助递归方法中多出来的两个参数就表示当前这个子树对应的中序遍历结果是啥.
        // 使用这一对下标表示当前子树的中序遍历结果是在 inorder 的那个部分上.
        List<Integer> inorderList = new ArrayList<>();
        for (int x : inorder) {
            inorderList.add(x);
        }
        return _buildTree(preorder, inorderList);
    }

    // [inorderLeft, inorderRight) 标注了一个前闭后开的区间.
    // inorder 数组上的这个区间中的内容, 就正是当前子树的中序遍历结果
    public TreeNode _buildTree(int[] preorder, List<Integer> inorder) {
        if (inorder.isEmpty()) {
            return null;
        }
        if (index >= preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        int pos = inorder.indexOf(root.val);
        index++;

        root.left = _buildTree(preorder, inorder.subList(0, pos));
        root.right = _buildTree(preorder, inorder.subList(pos + 1, inorder.size()));
        return root;
    }

    // 还是使用一个成员变量, 通过这个成员变量来记录最终结果
    // 随时在递归过程中把得到的结果拼接到 result 里面
    public StringBuilder result = null;
    public String tree2str(TreeNode t) {
        result = new StringBuilder();
        if (t == null) {
            return "";
        }
        // 通过 helper 方法辅助进行先序遍历的递归
        // 在递归过程中逐渐构造出 result 了
        helper(t);
        // 手动把最外层括号给删了!
        result.deleteCharAt(0);
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        // 访问当前根节点
        result.append("(");
        result.append(root.val);
        helper(root.left);
        if (root.left == null && root.right != null) {
            result.append("()");
        }
        helper(root.right);
        result.append(")");
    }

    public static void preOrderByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        // 创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        // 把根节点入闸
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.print(cur);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public static void inOrderByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            // 里层循环负责 cur 往左走并入栈这件事
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 当上面循环结束, cur 就已经是 null
            // 取出栈顶元素, 并且访问
            if (stack.isEmpty()) {
                // 遍历完了
                break;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val);

            // 让 cur 从 top 的右子树出发重复上述过程
            cur = top.right;
        }
   }

    public static TreeNode build() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        c.right = f;
        return a;
    }

    public static void postOrderByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        // 1. 创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        // 2. 创建一个引用 cur, 从 root 出发
        TreeNode cur = root;
        // 使用 prev 表示遍历结果的前一个元素
        TreeNode prev = null;
        while (true) {
            // 3. 让 cur 往左走, 遇到非空节点就入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 4. 取出栈顶元素判断下能不能访问
            if (stack.isEmpty()) {
                // 遍历结束了
                break;
            }
            // 此处不能直接 pop, 该节点能不能访问还不知道呢.
            // 必须是访问了才能出栈
            TreeNode top = stack.peek();
            if (top.right == null || top.right == prev) {
                // 都能访问该节点
                System.out.print(top.val);
                stack.pop();
                prev = top; // 更新 prev 的指向
            } else {
                cur = top.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = build();
//        preOrderByLoop(root);
        inOrderByLoop(root);
        System.out.println();
        postOrderByLoop(root);
    }
}
