import Plants.Moss;

public class App {
    public static void main(String[] args) throws Exception {
        
        // I make a moss named Fred using an abstract class and an interface.
        Moss test = new Moss("0");

        RollingStone roller = new RollingStone(test);
        roller.addGrowth(new Moss("1"));
        roller.addGrowth(new Moss("2"));
        roller.addGrowth(new Moss("3"));
        roller.addGrowth(new Moss("4"));
        roller.addGrowth(new Moss("5"));

        roller.deleteGrowth("3");
        roller.update(new Moss("insert"), 3);

        roller.addGrowth(new Moss("Mr. Moss"));

        roller.print();
        //System.out.print("index check: ");
        //System.out.println(roller.findIndex("insert"));

        //pressAnyKeyToContinue();
    }

    public static void pressAnyKeyToContinue()
    { 
           System.out.println("Press Enter key to continue...");
           try
           {
               System.in.read();
           }  
           catch(Exception e)
           {}  
    }
}
