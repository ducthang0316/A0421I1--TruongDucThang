package exam.model;

import java.io.Serializable;

public class ImportProduct extends Product implements Serializable {
    private int importPrice;
    private String provinceImport;
    private int importTax;

    public ImportProduct(){}

    public ImportProduct(int id, String productCode, String productName, int price, int quantity, String manufacture, int importPrice, String provinceImport, int importTax) {
        super(id, productCode, productName, price, quantity, manufacture);
        this.importPrice = importPrice;
        this.provinceImport = provinceImport;
        this.importTax = importTax;
    }

    public int getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(int importPrice) {
        this.importPrice = importPrice;
    }

    public String getProvinceImport() {
        return provinceImport;
    }

    public void setProvinceImport(String provinceImport) {
        this.provinceImport = provinceImport;
    }

    public int getImportTax() {
        return importTax;
    }

    public void setImportTax(int importTax) {
        this.importTax = importTax;
    }

    @Override
    public String toString() {
        return "ImportProduct{" +
                "id=" + this.getId() +
                ", productCode='" + this.getProductCode() + '\'' +
                ", productName='" + this.getProductName() + '\'' +
                ", price=" + this.getPrice() +
                ", quantity=" + this.getQuantity() +
                ", manufacture='" + this.getManufacture() + '\'' +
                "importPrice=" + importPrice +
                ", provinceImport='" + provinceImport + '\'' +
                ", importTax=" + importTax +
                '}';
    }
}
