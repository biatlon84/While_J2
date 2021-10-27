package com.eclipse.l;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int n =63;
        int[] ar =new int[n];
        for (int i =0;i<n;i++){
            ar[i]=(int)(Math.random()*10);
        }
        sort(ar);
        print(ar);
        System.out.print(Arrays.toString(ar));
    }
    private static void print(int[] ar) {
        int h = (int)(Math.log10(ar.length)/Math.log10(2));
        int o=(int)Math.pow(2,h);
        int nSt=2;
        for(int ii = 0; ii <o ; ii++) {
            System.out.print("  ");
        }
        for(int i = 1; i <=ar.length; i++) {
            System.out.printf("%2d",ar[i-1]);
            for(int ii = 0; ii <o*2-1 ; ii++) {
                System.out.print("  ");
            }
            if(nSt==i+1){
                System.out.print("\n");
                nSt*=2;
                o/=2;
                for(int ii = 0; ii <o ; ii++) {
                    System.out.print("  ");
                }
            }
        }
        System.out.print("\n");
    }
    public static void sift(int[] ar) {
        int n = ar.length;
        for (int i =n-2;i>=0;i--){
            siftDown(ar,i,n);
        }
    }
    public static void sort(int[] ar) {
        int n = ar.length;
        int bu =0;
        sift(ar);
        bu=ar[n-1];
        ar[n-1]=ar[0];
        ar[0]=bu;
        for (int i =n-2;i>0;i--){
            siftDown(ar,0,i+1);
        bu=ar[i];
        ar[i]=ar[0];
        ar[0]=bu;
        }
    }
    public static void siftDown(int[] ar, int inxUp,int n) {
        int bigI=0;
        int big=0;
            while(inxUp*2<n-1){
                bigI=inxUp;
                big=ar[inxUp];
                if(big<ar[inxUp*2+1]){
                    bigI=inxUp*2+1;
                    big=ar[inxUp*2+1];
                }
                if((inxUp*2+1<n-1)) {
                    if ((big < ar[inxUp * 2 + 2])) {
                        bigI = inxUp * 2 + 2;
                        big = ar[inxUp * 2 + 2];
                    }
                }
                if(inxUp==bigI){
                    break;
                }else{
                    ar[bigI]=ar[inxUp];
                    ar[inxUp]=big;
                }
                inxUp=bigI;
            }
    }
}
