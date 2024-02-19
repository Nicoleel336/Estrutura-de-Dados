public class MyBST2<Value extends Comparable<Value>>{
    public Node root;

    private class Node{
        private Value info;
        private Node left, right;

        public Node(Value info){
            this.info = info;
        }
    }

    // constructor of BST -> initializes it
    public MyBST2(){
        this.root = null;
    }

    // checks if the BST is empty
    public boolean isEmpty(){
        return root == null;
    }

    // returns the size(int) of the BST
    // without declarar a variable; it's a recursive method
    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x == null) return 0;
        else return 1 + size(x.left) + size(x.right);
    }

    // returns a certain value from the BST
    // also recursive
    public Value get(Value info){
        return get(root, info);
    }

    private Value get(Node x, Value info){
        if (info == null) throw new IllegalArgumentException("You can't search for a null value! Duh :P");
        if (x == null) return null; // empty tree
        if (info.equals(x.info)) return x.info;
        else if (info.compareTo(x.info) < 0) return get(x.left, info);
        else return get(x.right, info);
    }

    // inserts a value into the BST
    public void put(Value info){
        if (info == null) throw new IllegalArgumentException("You can't insert a null value! Duh :P");
        root = put(root, info);
    }

    private Node put(Node x, Value info){
        if(x == null) return new Node(info);
        if(info.compareTo(x.info) < 0) x.left = put(x.left, info);
        if(info.compareTo(x.info) > 0) x.right = put(x.right, info);
        else throw new IllegalArgumentException("You can't insert a duplicate value! Duh :P");
        return x; // I can't forget this part
    }

    // returns the height of the BST
    public int height(){
        return height(root);
    }

    private int height(Node x){
        if(x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    // show the BST
    public void show(){
        show(root);
    }

    private void show(Node x){
        if(x != null){
            show(x.left);
            System.out.println(x.info);
            show(x.right);
        }
    }

    // pre - order
    public void preOrder(){
        preOrder_(root);
    }
    
    private void preOrder_(Node x){
        if(x != null){
            System.out.println(x.info);
            preOrder_(x.left);
            preOrder_(x.right);
        }
    }

    // in order
    public void inOrder(){
        inOrder_(root);
    }

    private void inOrder_(Node x){
        if(x != null){
            inOrder_(x.left);
            System.out.println(x.info);
            inOrder_(x.right);
        }
    }

    // post - order
    public void postOrder(){
        postOrder_(root);
    }

    private void postOrder_(Node x){
        if(x != null){
            postOrder_(x.left);
            postOrder_(x.right);
            System.out.println(x.info);
        }
    }

    // mostra o comprimento interno da árvore
    public int internalPathLength(){
        return internalPathLength(root, 0);
    }
    
    private int internalPathLength(Node x, int depth){
        if(x == null) return 0;
        return depth + internalPathLength(x.left, depth + 1) + internalPathLength(x.right, depth + 1);
    }

    // check if it's balanced or not
    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node x){
        if(x == null) return true;
        int lh = height(x.left);
        int rh = height(x.right);
        if(Math.abs(lh - rh) <= 1 && isBalanced(x.left) && isBalanced(x.right)) return true;
        return false;
    }

    // function m1
    public void m1(Node x){
        if(x != null){
            m1(x.left);
            System.out.println(x.info);
            m1(x.right);
        }
    }

}