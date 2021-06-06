package p.labs;
import java.util.Scanner;

public class Abiturient {
    private String id;
    private String name;
    private String address;
    private String phone;
    private int[] grades = new int[3];

    public Abiturient(String id, String name, String address, String phone, String hm) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        Scanner readString = new Scanner(System.in);
        for (int g = 0; readString.hasNextInt(); g++)
            grades[g] = readString.nextInt();
        this.grades = grades;
    }

    public String toString() {
        return "\n" + "id: " + id + "\n"
                + "Name: " + name + "\n"
                + "Address: " + address + "\n"
                + "Phone: " + phone + "\n"
                + "Grades: " + grades[0] + " , " + grades[1] + " , " + grades[2];
    }

    public void badGrades(int g) {
        for (int i = 0; i < 3; i++)
            if (this.grades[i] < g) {
                System.out.println(this);
                break;
            }
    }

    public void amountOfPoints(int g) {
        if (this.sumGrades() > g)
            System.out.println(this);
    }

    public int entered(int n, int k) {
        if (this.sumGrades() == k) {
            System.out.println(this);
            return(1);
        }
        return(0);
    }

    public int sumGrades(){
        int sum = 0;
        for(int i = 0; i < 3; i++)
            sum = sum + this.grades[i];
        return sum;
    }
}
