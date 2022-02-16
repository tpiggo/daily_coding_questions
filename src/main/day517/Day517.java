package main.day517;

public class Day517 {
    public static void main(String [] args) {
        int [] arr1 = {1,2,3,4};
        int [] arr2 = {5,3,4};
        LinkedList ll1 = new LinkedList(arr1);
        LinkedList ll2 = new LinkedList(arr2);
        IntersectionLists il = new IntersectionLists(ll1, ll2);
        System.out.println("Intersection of lists is: " + il.getIntersection());
    }
}
