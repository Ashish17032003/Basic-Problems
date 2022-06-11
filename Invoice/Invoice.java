/*
(Invoice Class) Create a class called Invoice that a hardware store might use to represent an invoice
for an item sold at the store. An Invoice should include four pieces of information as instance
variables-a part number (type String), a part description (type String), a quantity of the item being
purchased (type int) and a price per item (double). Your class should have a constructor that initializes
the four instance variables. Provide a set and a get method for each instance variable. In addition,
provide a method named getInvoiceAmount that calculates the invoice amount (i.e., multiplies the
quantity by the price per item), then returns the amount as a double value. If the quantity is not
positive, it should be set to 0. If the price per item is not positive, it should be set to 0.0. Write a test
app named Invoice Test that demonstrates class Invoice's capabilities.
*/

public class Invoice
{
    private String partNumber;
    private String partDescription;
    private int itemsPurchased;
    private double pricePerItem;

    public Invoice(String partNumber, String partDescription, int itemsPurchased, double pricePerItem)
    {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.itemsPurchased = itemsPurchased < 0 ? 0 : itemsPurchased ;
        this.pricePerItem = pricePerItem < 0 ? 0 : pricePerItem;
    }

    public String getPartNumber()
    {
        return partNumber;
    }

    public void setPartNumber(String partNumber)
    {
        this.partNumber = partNumber;
    }

    public String getPartDescription()
    {
        return partDescription;
    }

    public void setPartDescription(String partDescription)
    {
        this.partDescription = partDescription;
    }

    public int getItemsPurchased()
    {
        return itemsPurchased;
    }

    public void setItemsPurchased(int itemsPurchased)
    {
        this.itemsPurchased = itemsPurchased;
    }

    public double getPricePerItem()
    {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem)
    {
        this.pricePerItem = pricePerItem;
    }

    public double getInvoiceAmount()
    {
        return (pricePerItem * itemsPurchased);
    }

}
