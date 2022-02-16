package main.day517;


public class IntersectionLists {
    private LinkedList fList;
    private LinkedList sList;
    private int intersection;

    IntersectionLists(LinkedList firstlist, LinkedList secondList) {
        this.fList = firstlist;
        this.sList = secondList;
        this.intersection = this.findIntersection();

    }

    private int getLength(boolean first){
        Node node = null; 
        if (first) {
            node = this.fList.getHead();  
        } else {
            node = this.sList.getHead();  
        }
        int counter = 0;
        while (node != null){
            counter++;
            node = node.getNext();
        }
        return counter;
    }

    private int findIntersection() {
        int lengthFL = this.getLength(true);
        int lengthSL =  this.getLength(false);

        Node slNode = this.sList.getHead();
        Node flNode = this.fList.getHead();
        // off set them by the difference in length;
        if (lengthFL > lengthSL){
            for (int i = 0; i < lengthFL - lengthSL; i++){
                flNode = flNode.getNext();
            }
        } else if (lengthFL < lengthSL) {
            for (int i = 0; i < lengthSL - lengthFL; i++){
                slNode = slNode.getNext();
            }
        }

        while (slNode != null && flNode != null) {
            if (slNode.getValue() == flNode.getValue()){
                return slNode.getValue();
            }
            slNode = slNode.getNext();
            flNode = flNode.getNext();
        }
        throw new Error("The lists did not intersect!");
    } 

    public int getIntersection(){
        return this.intersection;
    }
}
