package com.caramel.restaurant;

//import org.testng.annotations.Test;

import com.caramel.restaurant.samples.HelloWorld;

public class HelloWorldTest
{
   //@Test
   public void testGetText() {
      HelloWorld fixture = new HelloWorld();
      assert "Hello World!".equals(fixture.getText());
   }
}
