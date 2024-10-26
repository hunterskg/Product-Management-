
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManagement extends Product implements IOperation {

    private ArrayList<Product> pro = new ArrayList<>();

    public ProductManagement(int id, String name, double price, int discount) {
        super(id, name, price, discount);
    }
    Scanner sc = new Scanner(System.in);

    @Override
    public void inputInfo() {

        System.out.print("Enter the number of products you want to add: ");
        int numberOfProducts = sc.nextInt();

        for (int i = 0; i < numberOfProducts; i++) {
            System.out.println("Enter information for product " + (i + 1) + ":");

            System.out.print("Enter product ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter product name: ");
            String name = sc.nextLine();

            System.out.print("Enter product price: ");
            double price = sc.nextDouble();

            System.out.print("Enter product discount: ");
            int discount = sc.nextInt();

            pro.add(new Product(id, name, price, discount));
        }

    }

    @Override
    public void outputInfo() {
        for (int i = 0; i < pro.size(); i++) {
            System.out.println(pro.get(i));
        }
    }

    @Override
    public double caculate() {
        System.out.print("Tong gia tien cua san pham:");
        double sum = 0;
        System.out.println("Change discount");
        for (int i = 0; i < pro.size(); i++) {
            System.out.println("Change discount cua san pham: ");
            int newDiscount = sc.nextInt();
            sc.nextLine();

            pro.get(i).setDiscount(newDiscount);
        }

        for (int i = 0; i < pro.size(); i++) {
            sum += pro.get(i).getPrice() - (pro.get(i).getPrice() * pro.get(i).getDiscount() / 100);
        }
        return sum;
    }

    @Override
    public List search(String name) {
        List<Product> result = new ArrayList<>();
        for (Product pro : pro) {
            if (pro.getName().equalsIgnoreCase(name)) {
                result.add(pro);
            }
        }
        return result;
    }

    //sort theo ten tang dan neu trung ten thi sort theo gia giam dan
    public void sortProduct() {
        Collections.sort(pro, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                int nameComp = o1.getName().compareToIgnoreCase(o2.getName());
                if (nameComp != 0) {
                    return nameComp;
                } else {
                    return Double.compare(o1.getPrice(), o2.getPrice());
                }
            }
        });
    }
}
