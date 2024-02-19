public class App {
    public static void main(String[] args) throws Exception {
        MyBST2<String> bst = new MyBST2<>();

        bst.put("Marina");
        bst.put("Eduardo");
        bst.put("João");
        bst.put("Gilberto");
        bst.put("Paula");
        bst.put("Selma");
        bst.put("Teresa");

        bst.m1(bst.root);
    }
}
