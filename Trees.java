import java.util.*;

public class Trees {

    /* ===================== TREE NODE ===================== */
    class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int d){
            val = d;
            left = right = null;
        }
    }

    class BSTNode{
        int data;
        BSTNode left, right;
        BSTNode(int d){
            data = d;
            left = right = null;
        }
    }

    class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode n,int l){
            node = n;
            level = l;
        }
    }

    /* ===================== PREORDER ===================== */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        pre(root,ans);
        return ans;	
    }
    public void pre(TreeNode root,List<Integer> ans){
        if(root == null) return;
        ans.add(root.val);
        pre(root.left,ans);
        pre(root.right,ans);
    }

    /* ===================== INORDER ===================== */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root,ans);
        return ans;
    }
    public void inOrder(TreeNode root,List<Integer> ans){
        if(root == null) return ;
        inOrder(root.left,ans);
        ans.add(root.val);
        inOrder(root.right,ans);
    }

    /* ===================== POSTORDER ===================== */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postOrder(root,ans);
        return ans;
    }
    public void postOrder(TreeNode root,List<Integer> ans){
        if(root == null) return ;
        postOrder(root.left,ans);
        postOrder(root.right,ans);
        ans.add(root.val);
    }

    /* ===================== LEVEL ORDER ===================== */
    List<List<Integer>> levelOrder(TreeNode r){
        List<List<Integer>> ans = new ArrayList<>();
        if(r==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(r);
        while(!q.isEmpty()){
            List<Integer> inner = new ArrayList<>();
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode curr = q.remove();
                inner.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            ans.add(inner);
        }
        return ans;
    }

    /* ===================== ZIGZAG ===================== */
    public List<Integer> getZigZagLevel(BSTNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<BSTNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;
        while(!q.isEmpty()){
            List<Integer> inner = new ArrayList<>();
            int n = q.size();
            for(int i=0;i<n;i++){
                BSTNode curr = q.remove();
                inner.add(curr.data);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(flag) Collections.reverse(inner);
            flag=!flag;
            ans.addAll(inner);
        }
        return ans;
    }

    /* ===================== VERTICAL ORDER ===================== */
    public List<List<Integer>> verticalOrderTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Pair> q = new LinkedList<>();
        Map<Integer,List<Integer>> mp = new TreeMap<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p = q.remove();
            TreeNode curr = p.node;
            int lvl = p.level;
            mp.putIfAbsent(lvl,new ArrayList<>());
            mp.get(lvl).add(curr.val);
            if(curr.left!=null) q.add(new Pair(curr.left,lvl-1));
            if(curr.right!=null) q.add(new Pair(curr.right,lvl+1));
        }
        for(List<Integer> l : mp.values()){
            ans.add(l);
        }
        return ans;
    }

    /* ===================== LEFT VIEW ===================== */
    public List<Integer> leftViewOfTree(BSTNode r){
        List<Integer> ans = new ArrayList<>();
        if(r == null) return ans;
        Queue<BSTNode> q = new LinkedList<>();
        q.add(r);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0;i<n;i++){
                BSTNode curr = q.remove();
                if(i==0) ans.add(curr.data);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
        return ans;
    }

    /* ===================== RIGHT VIEW ===================== */
    public List<Integer> rightViewOfTree(BSTNode r){
        List<Integer> ans = new ArrayList<>();
        if(r == null) return ans;
        Queue<BSTNode> q = new LinkedList<>();
        q.add(r);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0;i<n;i++){
                BSTNode curr = q.remove();
                if(i==n-1) ans.add(curr.data);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
        return ans;
    }

    /* ===================== DIAMETER ===================== */
    int diameterOfTree(TreeNode r){
        if(r ==  null) return 0;
        return diameter(r);
    }
    public int height(TreeNode r){
        if(r==null) return 0;
        int l = height(r.left);
        int ri = height(r.right);
        return 1+Math.max(l,ri);
    }
    public int diameter(TreeNode r){
        if(r==null) return 0;
        int l = height(r.left);
        int ri = height(r.right);
        int d1 = diameter(r.left);
        int d2 = diameter(r.right);
        return Math.max(l+ri+1, Math.max(d1,d2));
    }

    /* ===================== LCA (BT) ===================== */
    public TreeNode lowestCommonAncestor(TreeNode r, int p, int q) {
        if(r == null) return null;
        if(r.val == p || r.val == q) return r;
        TreeNode left = lowestCommonAncestor(r.left,p,q);
        TreeNode right = lowestCommonAncestor(r.right,p,q);
        if(left!=null && right!=null) return r;
        return (left!=null)?left:right;
    }
}
