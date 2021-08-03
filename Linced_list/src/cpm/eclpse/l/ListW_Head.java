package cpm.eclpse.l;

import java.util.Arrays;

public class ListW_Head {

    private  int[] valu ;
    private  int[] empt ;
    private  int[] next;
    private  int head = 0;
    private  int ste =-1;

    public int getSize() {
        return size;
    }

    private int size = 0;

    public ListW_Head(int z){

        this.valu = new int[z];
        this.empt = new int[z];
        this.next = new int[z];
        int n = empt.length;
        for (int i = 0; i < n; i++) {
            empt[i] = n-i-1;
            ste++;
        }
        Arrays.fill(next,-1);

        next[head]=empt[ste];
        ste--;
    }
   public void insert(int inx, int val) {
        if (size < inx) {
            return;
        }
        if (ste > empt.length) {
            return;
        }
        int pos=head;
        for (int i=0;i<inx;i++){
            pos=next[pos];
        }
        int e = empt[ste];
        ste--;
        next[e]=next[pos];
        next[pos]=e;
        size++;
        valu[e]=val;
    }
    public int del(int inx) {

        if(inx>=size){
            return -77;
        }
        int pos=head;
        for (int i=0;i<inx;i++){
            pos=next[pos];
        }
        int bu=next[pos];
        next[pos]=next[bu];
        next[bu]=-1;
        ste++;
        empt[ste]=bu;
        size--;
        return valu[bu];
    }
}
