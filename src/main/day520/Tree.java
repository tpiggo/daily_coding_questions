package main.day520;
import java.util.ArrayList;
import java.util.Optional; 


public class Tree {
    private static final char END = ')';
    private static final char START = '(';
    private static final char NULL = '0';
    private int count = 0;
    private Node head = null;

    public Tree(String s) {
        if (s.length() == 0) {
            return;
        } else if (s.charAt(0) != START || s.charAt(s.length() - 1) != END ){
            throw new Error("Invalid string.");
        }
        this.createTreeFromString(s);
    }

    private void createTreeFromString(String s){
        int index = 0;
        Node cur = this.head;
        while (index < s.length()){
            switch(s.charAt(index)) {
                case START:
                    count++;
                    Node aNode = new Node(cur);
                    if (head == null) {
                        this.head = aNode;
                    } else {
                        cur.appendNode(aNode);
                    }
                    cur = aNode;
                    break;
                case END:
                    count --;
                    if (count < 0) {
                        throw new Error("Invalid string! mismatch between ( and )");
                    }
                    if (cur != this.head){
                        cur = cur.parent;
                    }
                    break;
                default:
                    cur.moveRight();
            }
            index++;
        }
    }

    public Node getHead() {
        return this.head;
    }

    private int max(int a, int b) {
        return (a > b)? a: b;
    }

    private int depthSearch(Node cur, int currentDepth){
        if (cur == null) {
            return currentDepth;
        }
        int rightDepth = this.depthSearch(cur.right, currentDepth + 1);
        int leftDepth = this.depthSearch(cur.left, currentDepth + 1);
        return this.max(rightDepth, leftDepth);
    }

    public int findDepth() {
        return this.depthSearch(this.head, 0);
    }
}
