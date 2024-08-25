public class Main {
    public static void main(String[] args) {
        Tree<Integer> Tree = new Tree<>(0);

        TreeNode<Integer> Node1 = new TreeNode<>(1);
        TreeNode<Integer> Node2 = new TreeNode<>(2);
        TreeNode<Integer> Node3 = new TreeNode<>(3);
        TreeNode<Integer> Node4 = new TreeNode<>(4);
        TreeNode<Integer> Node5 = new TreeNode<>(5);
        TreeNode<Integer> Node6 = new TreeNode<>(6);
        TreeNode<Integer> Node7 = new TreeNode<>(7);

        Tree.addNode(Tree.root, Node1);
        Tree.addNode(Tree.root, Node2);

        Tree.addNode(Node1, Node3);
        Tree.addNode(Node1, Node4);

        Tree.addNode(Node2, Node5);
        Tree.addNode(Node2, Node6);

        Tree.preOrderTraversal(Tree.root);

        Tree.deleteNode(Node2);
        System.out.println("BFS");
        Tree.BFS(Node7);
        
        Tree.preOrderTraversal(Tree.root);
    }
}
