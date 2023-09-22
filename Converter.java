import java.util.Scanner;
public class Converter {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    StringBuilder full = new StringBuilder();
    int input = scan.nextInt(); 
    String out = "";
// 100 % 2 = 50 
    out += input % 2;
    input -= input / 2;

    out += input % 2;
    input -= input / 2;

    out += input % 2;
    input -= input / 2;

    out += input % 2;
    input -= input / 2;

    out += input % 2;
    input -= input / 2;

    out += input % 2;
    input -= input / 2;

    out += input % 2;
    input -= input / 2;

    out += input % 2;
    full.append(out);
    full.reverse();
    System.out.println(full);
    System.out.println(0/2);  
  }
}
