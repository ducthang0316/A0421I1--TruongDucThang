package b12_java_collection_framework.bai_tap.quan_ly_san_pham;

public class Product {
    private int id;
    private  String nameProduct;
    private int price;

    public Product (int id, String nameProduct, int price){
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public  String toString(){
        return "Product { id = " + id + ", name = " + nameProduct+ ", price = " + price + " }";
    }
}
