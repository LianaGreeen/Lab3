import p.labs.Lab03C.Set;
import p.labs.Lab03C.SetM;

import java.util.Scanner;
import java.io.*;

public class Lab03C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        File fileA = new File("C:\\Users\\Лариса\\Desktop\\БГУ\\МИиИ\\IdeaProjects\\Labs\\text\\SetA.txt");
        File fileB = new File("C:\\Users\\Лариса\\Desktop\\БГУ\\МИиИ\\IdeaProjects\\Labs\\text\\SetB.txt");
        Set A = new Set();
        Set B = new Set();
        A.Create(fileA);
        B.Create(fileB);
        boolean b = true;
        while(b){
            switch(menu()){
                case 1: {
                    System.out.println(A);
                    System.out.println(B);
                    break;
                }
                case 2:{
                    System.out.println("1. A" + '\n' + "2. B");
                    int s = in.nextInt();
                    switch (s){
                        case 1:{ belongsToTheSet(A); break;}
                        case 2:{ belongsToTheSet(B); break;}
                    }
                    break;
                }
                case 3: {
                    intersectionOfSets(A,B);
                    break;
                }
                case 4: {
                    unionOfSets(A,B);
                    break;
                }
                case 5: {
                    differenceOfSets(A,B);
                    break;
                }
                case 6:{
                    newSet(A,B);
                    break;
                }
                case 7: {b = false; break;}
            }
        }
    }

    public static int menu(){
        Scanner in = new Scanner(System.in);
        String[] menu = new String[] {"Меню: ", "1. Вывести множество",
                "2. Опредить, принадлежит ли элемент множеству", "3. Пересеченеие двух множест",
                "4. Объединение двух множеств", "5. Разность двух множеств", "6. Множество",
                "7. Выход" };
        System.out.println();
        for(int i = 0; i < 8; i++)
            System.out.println(menu[i]);
        int choice = in.nextInt();
        return choice;
    }

    public static void belongsToTheSet(Set S){
        int c = 0;
        System.out.println("Введите символ: ");
        try {
            c = System.in.read();
        }
        catch (IOException e) {
            System.out.println("Oшибка");
        }
        if(S.Belong(c))
            System.out.println("принадлежит множеству");
        else System.out.println("не принадлежит множеству");
    }

    public static void unionOfSets(Set A, Set B){
        Set C = new Set();
        C.Union(A,B);
        System.out.println(C);
    }

    public static void intersectionOfSets(Set A, Set B){
        Set C = new Set();
        C.Intersection(A,B);
        System.out.println(C);
    }

    public static void differenceOfSets(Set A, Set B){
        Set C = new Set();
        C.Difference(A,B);
        System.out.println(C);
    }

    public static void newSet(Set A, Set B){
        Set[] S = {A, B};
        SetM C = new SetM();
        C.newSet(S);
        System.out.println(C);
    }
}
