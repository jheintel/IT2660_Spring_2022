import Plants.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        Moss test = new Moss("0 core moss");

        //test adding past the base array size
        RollingStone roller = new RollingStone(test);
        roller.addGrowth(new Moss("1 moss"));
        roller.addGrowth(new Moss("2 moss"));
        roller.addGrowth(new Moss("3 moss"));
        roller.addGrowth(new Moss("4 moss"));
        roller.addGrowth(new Moss("5 moss"));

        //test deleting
        roller.deleteGrowth("3 moss");
        
        //test updating past the base array size
        roller.update(new Moss("insert1"), 3);
        roller.update(new Moss("insert2"), 3);
        roller.update(new Moss("insert3"), 3);
        roller.update(new Moss("insert4"), 3);
        roller.update(new Moss("insert5"), 3);
        roller.update(new Moss("insert6"), 3);
        roller.update(new Moss("insert7"), 3);

        //add Mr Moss to help me make sure the tail end of the Array is being reached
        roller.addGrowth(new Moss("Mr. Moss"));

        //delete past the reduce base array size threshhold
        roller.deleteGrowth("insert2");
        roller.deleteGrowth("insert3");
        roller.deleteGrowth("insert4");
        roller.deleteGrowth("insert5");
        roller.deleteGrowth("insert6");
        roller.deleteGrowth("insert7");

        roller.print();
        System.out.print("index check for \'Mr. Moss\': ");
        System.out.println(roller.findIndex("Mr. Moss"));
        System.out.print("The current dynamic array size is: ");
        System.out.println(roller.getSize());
        System.out.print("The current base array index size is: ");
        System.out.println(roller.getTestIndex());



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
