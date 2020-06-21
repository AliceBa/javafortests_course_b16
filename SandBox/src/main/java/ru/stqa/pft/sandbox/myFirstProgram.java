package ru.stqa.pft.SandBox;

public class MyFirstProgram {
  public static void main(String[] args) {
    hello("world");
    hello("All");

    Square square = new Square(5);
    System.out.println("площадь квадрата со стороной " + square.l + " = " + square.area());

    Rectangle rect = new Rectangle(4, 6);
    System.out.println("площать прямоугольника со сторонами " + rect.a + " и " + rect.b + " = " + rect.area());

  }

  public static void hello(String somebody){
    System.out.println("Hello, " + somebody);
  }


}