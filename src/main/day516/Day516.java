package main.day516;
import java.util.ArrayList;

class Sevenish{
    public static final int BASE = 7;
    private int num;
    private ArrayList<Integer> binaryRepresentation;
    Sevenish(int number){
        if (number <= 0) {
            throw new Error("Number is less than or equal to zero!");
        }
        this.num = number;
        this.binaryRepresentation = new ArrayList<Integer>();
        this.convertToBinary();
    }

    private void convertToBinary(){
        int number = this.num;
        while (number > 0) {
            this.binaryRepresentation.add(number % 2);
            number = number / 2;
        }
    }

    private int power(int base, int pow, int total) {
        if (pow == 0) {
            return total;
        }
        return this.power(base, pow-1, total * base);
    }

    public int power(int base, int pow) {
        return this.power(base, pow, 1);
    }

    public int getSevenish(){
        int sevenish = 0;
        for (int i = this.binaryRepresentation.size() - 1; i >= 0; i--) {
            if (this.binaryRepresentation.get(i) != 0) {
                sevenish += this.power(BASE, i);
            }
        }
        return sevenish;
    }

    public void printBin(){
        System.out.print("Start: ");
        this.binaryRepresentation.forEach(el -> System.out.print(el + " "));
        System.out.println();
    }
}


public class Day516 {
    public static void main(String [] args){
        int num = 1000;
        Sevenish seven = new Sevenish(num);
        System.out.println("Sevenish for " + num + " is:" + seven.getSevenish());
    }
}