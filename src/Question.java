import java.util.Objects;

public class Question {
  void checkWhyWeNeedEqual() {
    String str1 = "Amol";
    String str2 = "Amol";
    String str3 = new String("Amol");

    String input = "Amol";
    String str4 = str2;

    String str5 = "patil";

    String str10 = "patil";

    str5 = str1;

    str5 = "Big Amol";


    String str6 = new String("New Amol");

    System.out.println("Lets have look at the values of string ");
    System.out.println("Str1 = [" + str1 + "]");
    System.out.println("Str2 = [" + str2 + "]");
    System.out.println("Str3 = [" + str3 + "]");
    System.out.println("Str4 = [" + str4 + "]");

    if (str1 == str2) {
      System.out.println("str1 and str2 are equal");
    } else {
      System.out.println("str1 and str2 are not equal");
    }

    if (str1 == str3) {
      System.out.println("str1 and str3 are equal");
    } else {
      System.out.println("str1 and str3 are not equal");
    }

    System.out.println("Let go with Patil saheb..");
    if (str1 == str4) {
      System.out.println("str1 and str4 are equal");
    } else {
      System.out.println("str1 and str4 are not equal");
    }


    if (str1.equals(str3)) {
      System.out.println("Using equals str1 and str3 are equal");
    } else {
      System.out.println("Using equals str1 and str3 are not equal");
    }
    //This you need to keep in mind...

    int a = 20;
    int b = 20;
    if (a == b) {
      System.out.println("Both a and b are same.");
    }

  }

  public static void main(String[] args) {

    Book book1 = new Book();
    Book book2 = new Book();

    if (book1 == book2) { // memory location
      System.out.println("Both are equal");
    } else {
      System.out.println("Both are not equal");
    }

    // String equal override...


    if (book1.equals(book2)) { //Content..
      System.out.println("Both are same using equal method");
    } else {
      System.out.println("Both are not same using equal method...");
    }

  }
}

class TestMe {
  private String name;


  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }
}

class Book {
  private String name;
  private String author;
  private Integer price;
  private String publication;

}

