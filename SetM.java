package p.labs.Lab03C;

import java.util.Arrays;

public class SetM {
    int n;
    char[] S;

    @Override
    public String toString() {
        return "SetTwo{" +
                "n = " + n +
                ", S = " + Arrays.toString(S) +
                '}';
    }

    public char[] newSet(Set[] M){
        char[] A = M[0].getSet();
        int nA = M[0].getN();
        char[] B = M[1].getSet();
        int nB = M[1].getN();
        this.n = nA + nB;
        char[] work = new char[this.n];
        int w = 0;
        for(int i = 0; i < nA; i++){
            boolean b = true;
            for(int j = 0; j < nB; j++)
                if(A[i] == B[j]){
                    b = false;
                }
            if(b){
                work[w] = A[i];
                w++;
            }
        }
        for(int i = 0; i < nB; i++){
            boolean b = true;
            for(int j = 0; j < nA; j++)
                if(B[i] == A[j]){
                    b = false;
                }
            if(b){
                work[w] = B[i];
                w++;
            }
        }
        this.S = Arrays.copyOf(work,w);
        this.n = w;
        return this.S;
    }
}
