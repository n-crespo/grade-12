public class ZooKeeper {
  public static void main(String[] args) {
    Lion leo = new Lion();
    leo.roar();

    Lion simba = new Lion("Simba", 1, 70.5, false);
    System.out.println(simba.toString());

    Tiger tiger = new Tiger("tiger", 5, 100, true);
    tiger.growl();
    tiger.getOlder();
    System.out.println(tiger.toString());

    Leopard jeff = new Leopard("jeff", 7, 150, false);
    jeff.getOlder();
    jeff.hiss();
    System.out.println(jeff.toString());

  } // main method
} // ZooKeeper
