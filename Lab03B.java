import p.labs.Point;

import java.util.Scanner;


public class Lab03B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество слагаемых X");
        int nX = in.nextInt();
        System.out.println("Введите количество слагаемых Y");
        int nY = in.nextInt();
        double time = 0;
        Point[] trajectoryX = new Point[nX];
        Point[] trajectoryY = new Point[nY];
        boolean firstTrajectory = false;
        boolean b = true;
        while(b){
            switch(menu()){
                case 1: {
                    System.out.println("Введите момент времени: ");
                    time = in.nextInt();
                    if(firstTrajectory){
                        Point timePoint = new Point();
                        timePoint.setX(calculation(trajectoryX, nX, time));
                        timePoint.setY(calculation(trajectoryY, nY, time));
                        System.out.println(timePoint);
                    }
                    else System.out.println("Трактория движения не задана");
                    break;
                }
                case 2:{
                    trajectoryOfMovement(trajectoryX, nX);
                    trajectoryOfMovement(trajectoryY, nY);
                    firstTrajectory = true;
                    System.out.println("x = ");
                    printTrajectory(trajectoryX, nX);
                    System.out.println();
                    System.out.println("y = ");
                    printTrajectory(trajectoryY, nY);
                    break;
                }
                case 3: {
                    if(firstTrajectory){
                        Point speed = speedPoint(trajectoryX, trajectoryY, nX, nY, time);
                        double v = speed.resultInPoint();
                        System.out.println("Скорость в точке при t = " + time + " = ");
                        System.out.printf("%.3f",v);
                    }
                    else System.out.println("Трактория движения не задана");
                    break;
                }
                case 4:{
                    if(firstTrajectory){
                        Point acceleration = accelerationPoint(trajectoryX, trajectoryY, nX, nY, time);
                        double a = acceleration.resultInPoint();
                        System.out.println("Ускорение в точке при t = " + time + " = ");
                        System.out.printf("%.3f",a);
                    }
                    else System.out.println("Трактория движения не задана");
                    break;
                }
                case 5:{
                    if(firstTrajectory){
                        //System.out.println("Введите момент времени: ");
                        //time = in.nextInt();
                        Point p1 = new Point();
                        p1.setX(calculation(trajectoryX, nX, time));
                        p1.setY(calculation(trajectoryY, nY, time));
                        System.out.println("Введите количество слагаемых X");
                        nX = in.nextInt();
                        System.out.println("Введите количество слагаемых Y");
                        nY = in.nextInt();
                        Point[] secondTrajectoryX = new Point[nX];
                        Point[] secondTrajectoryY = new Point[nY];
                        trajectoryOfMovement(secondTrajectoryX, nX);
                        trajectoryOfMovement(secondTrajectoryY, nY);
                        System.out.println("x = ");
                        printTrajectory(secondTrajectoryX, nX);
                        System.out.println();
                        System.out.println("y = ");
                        printTrajectory(secondTrajectoryY, nY);
                        Point p2 = new Point();
                        p2.setX(calculation(secondTrajectoryX, nX, time));
                        p2.setY(calculation(secondTrajectoryY, nY, time));
                        double d = distance(p1, p2, time);
                        System.out.println("Расстояние между двумя точками при t = " + time + " = ");
                        System.out.printf("%.3f",d);
                    }
                    else System.out.println("Трактория движения не задана");
                    break;
                }
                case 6:
                    b = false;
                    break;
            }
        }
    }

    public static int menu(){
        Scanner in = new Scanner(System.in);
        String[] menu = new String[] {"Меню: ", "1. Задать время", "2. Задать траекторию движения",
                "3. Вывести скорость", "4. Вывести ускорение", "5. Добавить еще одну точку",
                "6. Выход" };
        System.out.println();
        for(int i = 0; i < 7; i++)
            System.out.println(menu[i]);
        int choice = in.nextInt();
        return choice;
    }

    public static void trajectoryOfMovement(Point[] trajectory, int n){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите коэффициенты и степени");
        for(int i = 0; i < n; i ++){
            trajectory[i] = new Point();
            trajectory[i].setX(in.nextInt());
            trajectory[i].setY(in.nextInt());
        }
    }

    public static Point speedPoint(Point[] trajectoryX, Point[] trajectoryY, int nX, int nY, double time){
        Point[] speedX = derivative(trajectoryX, nX);
        Point[] speedY = derivative(trajectoryY, nY);;
        Point point = new Point();
        point.setX(calculation(speedX, nX, time));
        point.setY(calculation(speedY, nY, time));
        return point;
    }

    public static Point accelerationPoint(Point[] trajectoryX, Point[] trajectoryY, int nX, int nY, double time){
        Point[] accelerationX = derivative(trajectoryX, nX);
        Point[] accelerationY = derivative(trajectoryY, nY);
        accelerationX = derivative(accelerationX, nX);
        accelerationY = derivative(accelerationY, nY);
        Point point = new Point();
        point.setX(calculation(accelerationX, nX, time));
        point.setY(calculation(accelerationY, nY, time));
        return point;
    }

    public static double distance(Point p1, Point p2, double time){
        Point distance = new Point();
        double x = Math.abs(p1.getX() - p2.getX());
        double y = Math.abs(p1.getY() - p2.getY());
        distance.setX(x);
        distance.setY(y);
        return  distance.resultInPoint();
    }

    public static Point[] derivative(Point[] trajectory, int n) {
        Point[] speed = new Point[n];
        for(int i = 0; i < n; i++) { speed[i] = new Point(); }
        for(int i = 0; i < n; i++){
            speed[i].setX(trajectory[i].getX() * trajectory[i].getY());
            if(trajectory[i].getY() != 0)
                speed[i].setY(trajectory[i].getY() - 1);
            else speed[i].setY(0);
        }
        return speed;
    }

    public static double calculation (Point[] trajectory, int n, double t){
        double result = 0;
        for(int i = 0; i < n; i++)
        {
            result = result + trajectory[i].getX() * Math.pow(t, trajectory[i].getY());
        }
        return result;
    }

    public static void printTrajectory(Point[] trajectory, int n){
        for(int i = 0; i < n; i++){
            double k1 = trajectory[i].getX();
            double k2 = trajectory[i].getY();
            System.out.print(k1 + "t^" + k2);
        }
    }
}