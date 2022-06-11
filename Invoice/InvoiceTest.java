public class InvoiceTest
{
    public static void main(String[] args)
    {
        Invoice i1 = new Invoice("Dr32","Screw Driver", 3, 40);

        i1.setItemsPurchased(-4);
        i1.setPricePerItem(75);
        System.out.println("Part Number = "+ i1.getPartNumber());
        System.out.println("Part Description = "+ i1.getPartDescription());
        System.out.println("Items Purchased = "+ i1.getItemsPurchased());
        System.out.println("Price per item = "+ i1.getPricePerItem());

        System.out.println("Invoice Amount = $" + i1.getInvoiceAmount());


    }
}
