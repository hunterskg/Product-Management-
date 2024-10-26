
import java.util.List;
import java.util.Scanner;

public class ExerciseList {

    public static void main(String[] args) {
        ProductManagement productManagement = new ProductManagement(0, "", 0, 0);

        productManagement.inputInfo();
        productManagement.outputInfo();
         productManagement.sortProduct();
         productManagement.outputInfo();
        System.out.println("Change discount: ");
        
        
        System.out.println(productManagement.caculate());
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the product you want to search for: ");
        String searchName = sc.nextLine();
       

        
        List<Product> result = productManagement.search(searchName);

        if (result.isEmpty()) {
            System.out.println("Product not found.");
        } else {
            System.out.println("Product(s) found: ");
            for (Product p : result) {
                System.out.println("ID: " + p.getId() + ", Name: " + p.getName()+ ", Price: " + p.getPrice() + ", Discount: " + p.getDiscount() + "%");
            }
        }
        
    }
}
