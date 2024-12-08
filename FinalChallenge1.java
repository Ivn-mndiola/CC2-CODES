//CC2
//IVAN DAVE A. MENDIOLA
public class FinalChallenge1 {
    public static void main(String[] args) {
        //Quantity of the product
        int[] productQuantities = {3,6,9,12,15,18,21,24,27,30};
        //Prices of the product
        double[] prices = {12.0, 13.5, 20.0, 8.75, 11.0, 6.5, 7.0, 14.5, 8.0, 10.25};

        double totalValue = 0.0;

        
        for (int i = 0; i < productQuantities.length; i++) {
            double productValue = productQuantities[i] * prices[i];
            totalValue += productValue;
            System.out.println("Product " + (i + 1) + " - Quantity: " + productQuantities[i] + ", Price: " + prices[i] + ", Total: " + productValue);
        }
        
        System.out.println("Total value of all items in stock: " + totalValue);
    }
}
