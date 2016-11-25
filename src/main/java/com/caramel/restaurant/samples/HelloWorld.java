package com.caramel.restaurant.samples;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@ManagedBean
@SessionScoped
public class HelloWorld
{
   private final String text = "Hello World!";
   private static Logger log = LogManager.getLogger(HelloWorld.class.getName());

   @NotNull
   @NotEmpty
   @Pattern(regexp = "[A-Za-z]*", message = "must contain only letters")
   private String letters;
   
   private String numbers;

   @NotNull
   @NotEmpty
   @Email
   private String email;
   
   public HelloWorld() {}

   @PostConstruct
   public void initialize()
   {
      log.trace(this.getClass().getSimpleName() + " was constructed");
   }

   public String getText()
   {
      return text;
   }

   @NotNull
   @NotEmpty
   @Pattern(regexp = "[A-Za-z]*", message = "must contain only letters")
   public String getLetters()
   {
      return letters;
   }

   public void setLetters(String letters)
   {
      this.letters = letters;
   }

   @NotNull
   @NotEmpty
   @Digits(fraction = 0, integer = 2)
   public String getNumbers()
   {
      return numbers;
   }

   public void setNumbers(String numbers)
   {
      this.numbers = numbers;
   }

   @NotNull
   @NotEmpty
   @Email
   public String getEmail()
   {
      return email;
   }

   @NotNull
   @NotEmpty
   @Email
   public void setEmail(String email)
   {
      this.email = email;
   }

}
