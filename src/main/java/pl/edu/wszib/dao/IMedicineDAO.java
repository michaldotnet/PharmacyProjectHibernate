package pl.edu.wszib.dao;

import pl.edu.wszib.model.Medicine;

public interface IMedicineDAO {

        void addMedicines(Medicine medicine);
        Medicine getMedicines(String nameOfMedicine);
        void sellMedicine(Medicine medicineForSell, int quantityYouWantToSell);
}
