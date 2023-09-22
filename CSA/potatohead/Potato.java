public class Potato {
  private String name;
  private int arm;
  private String job;

  public Potato() {
    name = "None";
    arm = 0;
    job = "None";
  }
  public Potato(String n, int a, String j){
    name = n;
    arm = a;
    job = j; 
  } 
  public Potato(String n, int a){
    name = n;
    arm = a;
    job = "None"; 
  } 

  public void speak(){
    System.out.println("potato sounds");
  }
  public void addArm(){
    arm++;
  }
  public static void main(String[] args) {
    Potato mrPotato = new Potato("Mr. Potato", 35, "Dentist");
    mrPotato.addArm();
    System.out.println(mrPotato.arm());
  }
}
