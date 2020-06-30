package ru.stqa.pft.SandBox;

public class Main {
  public static void main(String[] args) {
    Point p1 = new Point(10, 5);
    Point p2 = new Point(7, 5);
    //System.out.println("расстояние между точками А и В = " + distance(p1, p2));

    System.out.print("расстояние между точкой А с координатами: " + p1.x + "," + p1.y);
    System.out.print(" и точкой В с координатами: " + p2.x + "," + p2.y);
    System.out.println(" = " + p1.distance(p2));
    //System.out.println(" = " + p2.distance(p1));
  }

  //не используется, т.к. есть метод в классе point
  public static double distance(Point p1, Point p2) {

    double d = Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));

    return d;
  }
}
