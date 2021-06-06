import p.labs.Abiturient;

import java.util.Scanner;
import java.io.*;

public class Lab03A {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        File file = new File("C:\\Users\\Лариса\\Desktop\\БГУ\\МИиИ\\IdeaProjects\\Labs\\text\\AbiturientList.txt");
        Scanner read = new Scanner(file);
        Abiturient[] list = new Abiturient[30];
        String name;
        String id;
        String addres;
        String phone;
        String gradesString = "";
        Scanner readString = new Scanner(gradesString);
        int[] gradesInt = new int[3];
        for(int i = 0; i < 30 && read.hasNextLine(); i++){
            name = read.nextLine();
            id = read.nextLine();
            addres = read.nextLine();
            phone = read.nextLine();
            gradesString = read.nextLine();
            list[i] = new Abiturient(id, name, addres, phone, gradesString);
        }
        readString.close();
        read.close();

        boolean b = true;
        while(b) {
            switch(menu()){
                case 1: {
                    for (int i = 0; i < 30; i++)
                        System.out.println(list[i]);
                    break;
                }
                case 2: {
                    System.out.println("Введите неудовлетворительную оценку: ");
                    int g = in.nextInt();
                    for (int i = 0; i < 30; i++)
                        list[i].badGrades(g);
                    break; }
                case 3: {
                    System.out.println("Введите сумму баллов: ");
                    int g = in.nextInt();
                    for (int i = 0; i < 30; i++)
                        list[i].amountOfPoints(g);
                    break; }
                case 4: {
                    System.out.println("Введите кол-во мест: ");
                    int n = in.nextInt();
                    for(int k = 30; n >= 0 && k > 0; k-- )
                        for (int i = 0; i < 30; i++)
                            n = n - list[i].entered(n, k);
                    break;
                }
                case 5: { b = false; break; }
            }
        }
    }

    public static int menu(){
        Scanner in = new Scanner(System.in);
        String[] menu = new String[] {"Меню: ", "1. Список абитуриентов",
                "2. Список абитуриентов, имеющих неудовлетворительные оценки",
                "3. Список абитуриентов, у которых сумма баллов выше заданной",
                "4. Выбрать заданное число n абитуриентов, имеющих самую высокую сумму баллов",
                "5. Выход" };
        for(int i = 0; i < 6; i++)
            System.out.println(menu[i]);
        int choice = in.nextInt();
        return choice;
    }
}
