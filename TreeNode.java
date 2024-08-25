import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
    public T data;
    public TreeNode<T> parent;
    public List<TreeNode<T>> children;

    public TreeNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode<T> child) {
        this.children.add(child);
        child.parent = this;
    }

    public TreeNode<T> removeChild(TreeNode<T> child) {
        if(this.children.indexOf(child)<0) {
            return null;
        } else {
            this.children.remove(child);
            return child;
        }
    }

    public boolean isExternal() {
        if(this.children.isEmpty()) {
            return true;
        }
        return false;
    } 

    public boolean isInternal() {
        if(this.children.isEmpty()) {
            return false;
        }
        return true;
    } 
}