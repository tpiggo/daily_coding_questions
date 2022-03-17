package main.day520;

public class StringToTree {

    public static Tree newTree(String s) {
        Tree aTree = new Tree(s);
        return aTree;
    }

    public static Tree headOnly(){
        String a = "(00)";
        return newTree(a);
        
    }

    public static Tree leftChild(){
        String a = "((00)0)";
        return newTree(a);
    }

    public static Tree rightTree(){
        String a = "(0(00))";
        return newTree(a);
    }

    public static Tree unbalanced(){
        String a = "((((00)0)0)0)";
        return newTree(a);
    }

    public static Tree balancedDepth2Tree() {
        String a = "((00)(00))";
        return newTree(a);
    }
    public static void main(String [] args) {
        Tree aTree = balancedDepth2Tree();
        System.out.println(aTree.findDepth());
    }
}
