package com.company;

import java.util.Scanner;

class Number{
    int value;
    Number next;
    int index;

    public Number(int value, Number next, int index){
        this.value = value;
        this.next = next;
        this.index = index;
    }

    @Override
    public String toString() {

        return "Number{" +
                "index=" + index +
                "value=" + value +
                ", next=" + next +
                "}";
    }
}
public class Main {
    static Scanner sc;

    public static double findSum(Number head){
        double sum = 0;
        Number ref = head;
        while(ref.next!=null){
            if (ref.value%2!=0){
                sum = sum + ref.value;
            }
            ref = ref.next;
        }
        if(ref.value%2!=0){
            sum = sum + ref.value;
        }
        return sum;
    }

    public static double findCount(Number head){
        int count = 0;
        Number ref = head;
        while (ref.next!=null){
            if(ref.value%2!=0){
                count++;
            }
            ref = ref.next;
        }
        if(ref.value%2!=0){
            count++;
        }
        return count;
    }

    public static int []findMax(Number head, int n){
        Number ref = head;
        int indexMax = ref.index;
        int max = ref.value;

        while (ref!=null){
            if (ref.value%2!=0 && ref.value<0){
                if(ref.value>max) {
                    max = ref.value;
                    indexMax = ref.index;
                }
            }
            ref = ref.next;
        }
        return new int[]{indexMax,max};
    }

    public static int []findMin(Number head, int n){
        Number ref = head;
        int indexMin = ref.index;
        int min = ref.value;

        while (ref!=null){
            if (ref.value%2!=0 && ref.value<0) {
                if (ref.value < min) {
                    min = ref.value;
                    indexMin = ref.index;
                }
            }
            ref = ref.next;
        }
        return new int[]{indexMin,min};
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("Input n");
        int n = sc.nextInt();
        Number head = null;
        for(int i = 0; i < n; i++){
            int value = sc.nextInt();
            head = new Number(value, head, i);
        }
        System.out.println(head);
        double sum = findSum(head);
        System.out.println("SUM="+sum);
        double count = findCount(head);
        System.out.println("COUNT="+count);
        System.out.println("AVG="+(double)sum/count);
        int indexMax = findMax(head,n)[0];
        int max = findMax(head,n)[1];
        int indexMin = findMin(head,n)[0];
        int min = findMin(head,n)[1];
        System.out.println("Max " + max + " " + indexMax);
        System.out.println("Min " + min + " " + indexMin);
    }
}
