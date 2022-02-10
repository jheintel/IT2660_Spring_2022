class Moss extends Plant implements Nameable{
    String name;
    String description;

    public String getName() {
        return name;
    } 
    public void setName(String n){
        name = n;
    }

    public void setDescription(String s){
        description = s;
    }
    public void giveDescription(){
        System.out.println(description);
    }

    public int waterNeeded(){
        return 1;
    }
    public int sunlightNeeded(){
        return 1;
    }

    public Moss(String n){
        setName(n);
    }
}
