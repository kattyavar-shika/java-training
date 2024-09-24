package com.kattyavar.shika.main.java.solid.lsp;

// Liskov Substitution Principle Subclasses should be substitutable for their base classes:
//objects of a superclass shall be replaceable with objects of its subclasses without breaking the application.
//if class Person if subType of Class human, then we should be able to replace object Human with Person, without
//breaking the behaviour of the program
public class WhyLSP {

  public static void main(String[] args) {

  }

  void notLSP() {
    class Bird {
      void fly() {
      }
    }
    class Eagle extends Bird {
      void fly() {
      } // Okie eagle can fly like bird
    }
    class Penguin extends Bird {
      void swim() {
      } // not Ok, Penguin can't fly.
    }

  }

  void anotherExample() {

    abstract class SocialMedia {
      abstract void chat();

      abstract void publishPost();

      abstract void sendPhoto();

      abstract void videoCall();
    }

    class FB extends SocialMedia {

      @Override
      void chat() {

      }

      @Override
      void publishPost() {

      }

      @Override
      void sendPhoto() {

      }

      @Override
      void videoCall() {

      }
    }

    class WhatsApp extends SocialMedia {

      @Override
      void chat() {

      }

      @Override
      void publishPost() {
        //NA
      }

      @Override
      void sendPhoto() {

      }

      @Override
      void videoCall() {

      }
    }

    class Instagram extends SocialMedia {
      @Override
      void chat() {

      }

      @Override
      void publishPost() {

      }

      @Override
      void sendPhoto() {

      }

      @Override
      void videoCall() {
        // NA
      }
    }

  }

  void anotherExampleSolution() {

  }
}
