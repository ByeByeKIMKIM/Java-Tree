import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;


public class Tree<T> {
    TreeNode<T> root;
    ArrayList<TreeNode<T>> collection = new ArrayList<TreeNode<T>>();

    public Tree(T data) {
        this.root=new TreeNode<>(data);
    }

    public void addNode(TreeNode<T> parent, T childData) {
        TreeNode<T> newNode = new TreeNode<T>(childData);
        parent.addChild(newNode);
        collection.add(newNode);
    }

    public void addNode(TreeNode<T> parent, TreeNode<T> child) {
        parent.addChild(child);
        collection.add(child);
    }

    public TreeNode<T> getRoot() {
        return this.root;
    }

    public void preOrderTraversal(TreeNode<T> node) {
        if(node!=null) {
            System.out.print(node.data + " ");

            for(TreeNode<T> child: node.children) {
                preOrderTraversal(child);
            }
        }
    }

    public boolean searchNode(TreeNode<T> node, TreeNode<T> testNode) {
        if(testNode!=null) {
            if(testNode == node) {
                return true;
            } else {
                for(TreeNode<T> child: testNode.children) {
                    if (searchNode(node, child)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public TreeNode<T> deleteNode(TreeNode<T> deleteNode) {
        //first determine if the node exists in the tree
        //determine the index of the node to delete in the collection of nodes
        //add the children of the to-be deleted node after the node in the collection
        //remove the node from the collection

        if(this.searchNode(deleteNode, this.root) == true) {
            int index = this.collection.indexOf(deleteNode);
            for(TreeNode<T> child: deleteNode.children) {
                collection.add(index, child);
                deleteNode.parent.children.add(index, child);
                index++;
            }
            //removing children from deleteNode
            while(deleteNode.children.size() != 0) {
                deleteNode.children.remove(0);
            }

            deleteNode.parent.children.remove(deleteNode);

            //removing parent from deleteNode
            deleteNode.parent = null;

            //removing deletenode from collection
            this.collection.remove(deleteNode);


            //removing delete node from parent children
            return deleteNode;
        }

        return null;
    }

    public int nodeDepth(TreeNode<T> node) {
        if(this.searchNode(node, this.root) == true) {
            if(node == this.root) {
                return 0;
            } else {
                return 1 + nodeDepth(node.parent);
            }
        } else {
            return -1;
        }
    }

    public int inefficientTreeHeight() {
        int maxHeight = 0;
        for(TreeNode<T> node: collection) {
            if(node.isExternal()) {
                maxHeight = Math.max(maxHeight, nodeDepth(node));
            }
        }
        return maxHeight;
    }

    public int efficientNodeHeight(TreeNode<T> node) {
        if(node.isExternal()) {
            return 0;
        } else {
            int maxHeight = 0;
            for(TreeNode<T> child: node.children) {
                maxHeight = Math.max(maxHeight, efficientNodeHeight(child));
            }
            return maxHeight + 1;
        }
    }

    // public ArrayList<TreeNode> adjacentNodes(TreeNode node) {

    // }

    public TreeNode<T> BFS(TreeNode<T> search) {
        Queue<TreeNode<T>> Q = new LinkedList<>();
        Q.add(this.root);

        while(Q.peek() != null) {
            TreeNode<T> v = Q.remove();
            if(v == search) {
                return v;
            } else {
                for(TreeNode<T> node: v.children) {
                    Q.add(node);
                }
            }
        }
        System.out.println("Couldn't find the node");
        return null;
    } 


}
