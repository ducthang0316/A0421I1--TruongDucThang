package b12_java_collection_framework.bai_tap.quan_ly_san_pham;


import java.util.*;

public class ProductManager {
    private static List<Product> productList;
    private static Scanner scanner = new Scanner(System.in);

    static {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Apple", 30000));
        productList.add(new Product(2, "SamSung", 450000));
        productList.add(new Product(3, "Xiaomi", 15000));
    }

    public static void displayMenu(){
        int choice = -1;
        do {
            System.out.printf("Menu: \n" +
                    "1. Display Product List \n" +
                    "2. Add product \n" +
                    "3. Modify product \n" +
                    "4. Delete product \n" +
                    "5. Find product: \n" +
                    "6. Sort product: \n" +
                    "7. Exit \n");
            System.out.println("Enter a choice: ");
            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    displayProductList();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    modifyProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    findProductByName();
                    break;
                case 6:
                    sortProduct();
                    break;
                case 7:
                    System.exit(0);
            }
        } while (true);
    }

    public static void displayProductList(){
        for (Product product : productList){
            System.out.println(product);
        }
    }

    public static void addProduct(){
        int id;
        do {
            System.out.println("Enter id of new product: ");
            id = scanner.nextInt();
        } while (!isValidId(id));

        scanner.skip("\\R");
        System.out.println("Enter name of new product: ");
        String name = scanner.nextLine();
        System.out.println("Enter price of new product: ");
        int price = scanner.nextInt();

        productList.add(new Product(id,name, price));
    }

    public static void deleteProduct(){
        int id;
        do {
            System.out.println("Enter the id of the product you want to delete: ");
            id = scanner.nextInt();
        } while (!checkId(id));

        for (Product product : productList){
            if (product.getId() == id){
                productList.remove(product);
            }
        }
    }

    public static void modifyProduct(){
        int id;
        do {
            System.out.println("Enter the id of the product you want to modify: ");
            id = scanner.nextInt();
        } while (!checkId(id));

        for (Product product : productList){
            if (product.getId() == id){
                System.out.println(product.toString());
            }
        }

        int newId;
        do {
            System.out.println("Enter new id to modify the product: ");
            newId = scanner.nextInt();
        } while (!isValidId(newId));
        scanner.skip("\\R");
        System.out.println("Enter new name to modify the product: ");
        String newName = scanner.nextLine();
        System.out.println("Enter price to modify the product: ");
        int newPrice = scanner.nextInt();

        for (Product product : productList){
            if (product.getId() == id){
                productList.set(productList.indexOf(product), new Product(newId, newName, newPrice));
            }
        }

    }

    public static String findProductByName(){
        String name;
        scanner.skip("\\R");
        System.out.println("Enter the name of the product you want to find: ");
        name = scanner.nextLine();
        for (Product product : productList){
            if (name.equals(product.getNameProduct())){
                return product.toString();
            }
        }
        return "Product is not existed";
    }

    public static void sortProduct(){
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() < o2.getPrice()){
                    return 1;
                } else if (o1.getPrice() == o2.getPrice()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        System.out.println("Product list followed decreasing price order: ");
        for (Product product : productList){
            System.out.println(product);
        }
    }

    public static boolean isValidId(int id){
        if (id <=0){
            System.out.println("ID must greater than 0. ");
            return false;
        }
        for (Product product : productList){
            if (id == product.getId()){
                System.out.println("ID is existed. Enter another id please!");
                return false;
            }
        }
        return true;
    }

    public static boolean checkId(int id){
        // check id for delete and modify function
        if (id <=0){
            System.out.println("ID must greater than 0. ");
            return false;
        }
        for (Product product : productList){
            if (id == product.getId()){
                return true;
            }
        }
        return false;
    }
}
