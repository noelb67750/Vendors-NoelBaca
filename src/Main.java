public class Main {
    public static void main(String[] args) {


        System.out.println("Welcome to Ultra Shop!");
        VendorSystem system = new VendorSystem();

        for(int i = 0; i < 5; i++)
        {
            //add 5 vendors
            system.addVendor(new Vending(10,10));
        }

        //make changes to 2 vendors
        system.getVendor(1).restock("Chips", 5,1.50);
        system.getVendor(2).emptyInventory();

        System.out.println(system.getAllInventories());

    }
}