import java.util.HashMap;


/**
 * Class for a Vending Machine.  Contains a hashtable mapping item names to item data, as
 * well as the current balance of money that has been deposited into the machine.
 */
class Vending {
    //each new vending gets its own hashmap
    private HashMap<String, Item> Stock = new HashMap<String, Item>();


    // private static HashMap<String, Item> Stock = new HashMap<String,Item>();
    private double balance;

    Vending(int numCandy, int numGum) {
        Stock.put("Candy", new Item(1.25, numCandy));
        Stock.put("Gum", new Item(.5, numGum));
        this.balance = 0;
    }

    /**
     * resets the Balance to 0
     */
    void resetBalance() {
        this.balance = 0;
    }

    /**
     * returns the current balance
     */
    double getBalance() {
        return this.balance;
    }

    // returns how many of an String "name" are left, or if 0 remain
    int getStock(String name) {
        if (Stock.containsKey(name)) {
            return Stock.get(name).stock;
        }
        return 0;
    }

    /**
     * adds money to the machine's balance
     *
     * @param amt how much money to add
     *
     */
    void addMoney(double amt) {
        this.balance = this.balance + amt;
    }

    /**
     * attempt to purchase named item.  Message returned if
     * the balance isn't sufficient to cover the item cost.
     *
     * @param name The name of the item to purchase ("Candy" or "Gum")
     */
    void select(String name) {
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            if (item.stock <= 0) {
                System.out.println("item is sold out");
            }
            //  if (balance >= item.price)
            else if (balance >= item.price) {
                item.purchase(1);
                this.balance = this.balance - item.price;
            } else
                System.out.println("Gimme more money");
        } else System.out.println("Sorry, don't know that item");
    }

    String getInventory()
    {
        String result = "";
        for (String name : Stock.keySet())
        {
            Item item = Stock.get(name);
            //show the price two decimal places like .50
            result = result + name + ": " + item.stock + " $" + String.format("%.2f", item.price) + "\n";
        }
        return result;
    }

    /**
     * restocks a item when given a name and amount
     *
     * @param name
     * @param amount
     */
    public void restock(String name, int amount) {
        if (Stock.containsKey(name)) {
            Stock.get(name).restock(amount);
        }
    }

    public void restock(String name, int amount, double price) {
        if (Stock.containsKey(name)) {
            restock(name, amount);
        } else {
            Stock.put(name, new Item(price, amount));
        }
    }

    public void emptyInventory() {
        Stock.clear();
    }

    void renameItem(String oldName, String newName) {
        if (Stock.containsKey(oldName)) {
            Item item = Stock.remove(oldName);

            Stock.put(newName, item);


        }
    }

    int getPurchaseCount(String name)
    {
        if (Stock.containsKey(name))
        {
            return Stock.get(name).timesPurchased;
        }
        return 0;
    }

    void setDescription(String name, String description) {
        if (Stock.containsKey(name)) {
            Stock.get(name).Description = description;
        }
    }

    String getDescription(String name)
    {
        if(Stock.containsKey(name))
        {
            return Stock.get(name).Description;
        }
        return "item does not exist";
    }

    String getMostPopularItem()
    {
        String best = "";
        int Count = 0;
        for(String name : Stock.keySet())
        {
            int count = Stock.get(name).timesPurchased;
            if(count > Count)
            {
                best = name;
                Count = count;
            }
        }
        return best;

    }

    void removeItem(String name)
    {
        Stock.remove(name);
    }
}




class Examples {
}

