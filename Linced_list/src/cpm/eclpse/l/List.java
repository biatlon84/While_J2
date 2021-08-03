package cpm.eclpse.l;

import java.util.Arrays;

public class List {

    private  int[] valu ;
    private  int[] empt ;
    private int[] next;
    private  int head = 0;
    private  int ste =-1;

    public int getSize() {
        return size;
    }

    private int size = 0;

    public List(int z){

        this.valu = new int[z];
        this.empt = new int[z];
        this.next = new int[z];
        int n = empt.length;
        for (int i = 0; i < n; i++) {
            empt[i] = n-i-1;
            ste++;
        }
        Arrays.fill(next,-1);
    }
   public void insert(int inx, int val) {
        if (size < inx) {
            return;
        }
        if (ste > empt.length) {
            return;
        }

        if(inx==0){
            int e=empt[ste];
            ste--;
            if (next[head]!=-1){
                next[e] = next[head];
            }
            head=e;
            valu[e]=val;
            size++;
        }else {
            int pos = head;// head
            int e=0;
            e=empt[ste];
            ste--;
            for (int i = 0; i < inx; i++) {
                if (next[pos] == -1) {
                    next[pos]=e;
                    valu[e]=val;
                    size++;
                    break;
                } else {
                    if(i==inx-1){
                        next[e]=next[pos];
                        next[pos]=e;
                        valu[e]=val;
                        size++;
                    }
                    pos = next[pos];
                }
            }
        }
    }

    public int del(int inx) {

        if(inx>=size){
            return -77;
        }

        if(inx==0){
            int b=head;
            if(next[b]!=-1) {
                head = next[b];
            }
            size--;
            ste++;
            empt[ste]=b;
            next[b]=-1;
            return valu[b];
        }else {
            int pos = head;// head
            for (int i = 0; i < inx-1; i++) {
                pos = next[pos];
            }
            int b=next[pos];
            if(next[b]!=-1){
                next[pos]= next[b];
            }
            size--;
            ste++;
            empt[ste] = b;
            next[b]=-1;
            return valu[b];
        }

    }
}
