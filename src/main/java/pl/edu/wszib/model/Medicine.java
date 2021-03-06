package pl.edu.wszib.model;

public class Medicine {

        private int id;
        private String medicineName;
        private int  quantity;
        private double price;
        private boolean needPrescription;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isNeedPrescription() {
        return needPrescription;
    }

    public void setNeedPrescription(boolean needPrescription) {
        this.needPrescription = needPrescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Nazwa lekarstwa ='" + medicineName + '\'' +
                "\nIlość opakowań na stanie = " + quantity +
                "\nCena = " + price +
                "zł \nCzy lek jest na recepte? " + needPrescription +
                '\n';
    }
}
