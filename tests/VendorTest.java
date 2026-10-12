import org.junit.jupiter.api.Test;

import javax.xml.namespace.QName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorTest {

    @Test
    void addMoneyTest() {
    Vending vendor = new Vending(10,10);

    vendor.addMoney(1.25);
    //.001 because double cant store decimals
        // instead Im checking to see if there are in a .001 range of each other
    assertEquals(1.25, vendor.getBalance(), 0.001);
    }

    @Test
    void buyItemTest() {
        Vending vendor = new Vending(10,10);
        vendor.addMoney(2.00);

        vendor.select("Candy");
       assertEquals(9, vendor.getStock("Candy"));
       assertEquals(0.75,vendor.getBalance(), 0.001);
        }
    @Test
    void emptyInventoryTest()
    {
        Vending vendor = new Vending(10,10);
        vendor.emptyInventory();
        assertEquals(0,vendor.getStock("Gum"));

        assertEquals(0,vendor.getStock("Candy"));

    }

    @Test
    void restockAddsToStockTest()
    {
        Vending vendor =  new Vending(0, 10);

        vendor.restock("Candy", 5);

        assertEquals(5,vendor.getStock("Candy"));
    }
    @Test
    void itemSoldOut()
    {

Vending vendor = new Vending(0,10);
vendor.addMoney(1.25);

vendor.select("Candy");

assertEquals(0,vendor.getStock("Candy"));
assertEquals(1.25, vendor.getBalance(), 0.001);

    }
    @Test
    void restockAddsNewItemTest()
    {
        Vending vendor = new Vending(10,10);

        vendor.restock("Chips", 5 ,1.50);

        assertEquals(5, vendor.getStock("Chips"));
    }

    @Test
    void renameItemTest() {
        Vending vendor = new Vending(10, 10);
        vendor.renameItem("Candy", "Chocolate");

        assertEquals(10, vendor.getStock("Chocolate"));
        assertEquals(0, vendor.getStock("Candy"));
    }

    @Test
    void vendorSeperateInventoryTest()
    {
        Vending vendor1 = new Vending(10, 10);
        Vending vendor2 = new Vending(10, 10);

        vendor1.addMoney(1.25);
        vendor1.select("Candy");

        assertEquals(9, vendor1.getStock("Candy"));
        assertEquals(10, vendor2.getStock("Candy"));


    }
    @Test
    void FiveVendorsTest()
    {
        VendorSystem system = new VendorSystem();
        for (int i = 0; i < 5; i++)
        {
            system.addVendor(new Vending(10,10));
        }
        assertEquals(5, system.getVendorCount());
    }

}