package cours2.restaurantPrac;

public class Consumable{
    String name;
    int price;
    public Consumable(String name){
        this.name = name;
        this.price = 0;
    }
    public String getItemName(){
        return this.name;
    }
    public void setPrice(int new_price){
        this.price = new_price;
    }
    public int getPrice(){
        return this.price;
    }
}
