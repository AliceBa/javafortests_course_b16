package ru.stqa.pft.SandBox;

public class Point {

  double x, y;

  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }

  public double distance( Point p ) {

    double d = Math.sqrt((p.x - this.x) * (p.x - this.x) + (p.y - this.y) * (p.y - this.y));

    return d;
  }
}
