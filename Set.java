package p.labs.Lab03C;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Set {
    int n;
    char[] set;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public char[] getSet() {
        return set;
    }

    public void setSet(char[] set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "Set {" + "n = " + n + " , set =" + Arrays.toString(set) + '}';
    }


    public void Create(File file) {
        char[] buf = new char[256];
        int c;
        try( FileReader reader = new FileReader(file);) {
            while((c = reader.read(buf))>0){
                if(c < 256 & c != ' '){
                    buf = Arrays.copyOf(buf, c);
                }
            }
        }
        catch(IOException ex){ System.out.println(ex.getMessage()); }
        this.n = buf.length;
        this.set = buf;
    }

    public boolean Belong(int c){
        for(int i = 0; i < this.n; i++)
            if(this.set[i] == c)
                return true;
        return false;
    }

    public void Union(Set A, Set B){
        char[] sA = A.getSet();
        char[] sB = B.getSet();
        int lA = A.getN(); int lB = B.getN();
        this.n = lA + lB;
        char[] S = new char[this.n];
        for(int i = 0; i < this.n; i++){
            if(i < lA)
                S[i] = sA[i];
            else S[i] = sB[i-lA];
        }
        this.set = S;
    }

    public void Intersection(Set A, Set B){
        char[] sA = A.getSet();
        char[] sB = B.getSet();
        int lA = A.getN(); int lB = B.getN();
        this.n = lA + lB;
        char[] S = new char[this.n];
        int Si = 0;
        if(lA > lB)
            for(int i = 0; i < lA; i++){
                for(int j = 0; j < lB; j++)
                    if(sA[i] == sB[j]){
                        S[Si] = sA[i];
                        Si++;
                        break;
                    }
            }
        else
            for(int i = 0; i < lB; i++){
                for(int j = 0; j < lA; j++)
                    if(sB[i] == sA[j]){
                        S[Si] = sB[i];
                        Si++;
                    }
            }
        S = Arrays.copyOf(S, Si);
        this.n = Si;
        this.set = S;
    }

    public void Difference(Set A, Set B){
        char[] sA = A.getSet();
        char[] sB = B.getSet();
        int lA = A.getN(); int lB = B.getN();
        char[] S = new char[lA];
        int Si = 0;
        boolean b = true;
        for(int i = 0; i < lA; i++){
            for(int j = 0; j < lB; j++)
                if(sA[i] == sB[j]){
                    b = false;
                }
            if(b){
                S[Si] = sA[i];
                Si++;
            }
        }
        S = Arrays.copyOf(S, Si);
        this.n = Si;
        this.set = S;
    }
}
