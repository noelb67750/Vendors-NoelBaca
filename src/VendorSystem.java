import java.util.ArrayList;
public class VendorSystem
{
    private ArrayList<Vending> vendors = new ArrayList<Vending>();

    void addVendor(Vending vendor)
    {
        vendors.add(vendor);
    }

    int getVendorCount()
    {
        return vendors.size();
    }
    // return position in list
    Vending getVendor(int index)
    {
        return vendors.get(index);
    }

    //returns each inventory as a string using for each
    String getAllInventories()
    {
        String result = "";
        for(int i = 0; i < vendors.size(); i++)
        {
            result = result = "Vendor " + (i + 1) + ":\n " + vendors.get(i).getInventory();
        }
        return result;
    }

}
