package ru.stqa.pft.SandBox;

public class Point {

  double x, y;

  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }

  public double distance( double x2, double y2) {

    double d = Math.sqrt((x2 - this.x) * (x2 - this.x) + (y2 - this.y) * (y2 - this.y));

    return d;
  }

}
