package ru.stqa.pft.SandBox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test
  public void testDistance() {
    Point a = new Point(10, 5);
    Point b = new Point(4, 5);
    Assert.assertEquals(a.distance(b.x, b.y), 6);
  }
}
