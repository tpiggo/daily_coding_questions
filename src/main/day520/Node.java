package main.day520;

public class Node {
    public Node left = null;
    public Node right = null;
    public Node parent = null;
    private int checked = 0;
    public Node(Node p){
        this.parent = p;
    }

    public void moveRight() {
        if (this.checked > 1) {
            throw new Error("Going too far right!");
        }
        this.checked++;
    }

    public Node appendNode(Node aNode){
        switch(this.checked){
            case 0:
                this.left = aNode;
                break;
            case 1:
                this.right = aNode;
                break;
        }
        this.checked++;
        return aNode;
    }
}
