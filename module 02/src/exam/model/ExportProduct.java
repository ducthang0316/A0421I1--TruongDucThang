package exam.model;

import java.io.Serializable;

public class ExportProduct extends Product implements Serializable {
    private int exportPrice;
    private String country;

    public ExportProduct (){}

    public ExportProduct(int id, String productCode, String productName, int price, int quantity, String manufacture, int exportPrice, String country) {
        super(id, productCode, productName, price, quantity, manufacture);
        this.exportPrice = exportPrice;
        this.country = country;
    }

    public int getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(int exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "ExportProduct{" +
                "id=" + this.getId() +
                ", productCode='" + this.getProductCode() + '\'' +
                ", productName='" + this.getProductName() + '\'' +
                ", price=" + this.getPrice() +
                ", quantity=" + this.getQuantity() +
                ", manufacture='" + this.getManufacture() + '\'' +
                "exportPrice=" + exportPrice +
                ", country='" + country + '\'' +
                '}';
    }
}
