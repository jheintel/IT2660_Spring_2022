package Plants;

abstract class Plant {
    
    abstract public void setDescription(String s);
    abstract public void giveDescription();

    abstract public int waterNeeded();
    abstract public int sunlightNeeded();
}
