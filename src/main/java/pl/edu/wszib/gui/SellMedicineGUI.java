package pl.edu.wszib.gui;

import pl.edu.wszib.dao.Impl.*;
import pl.edu.wszib.dao.Impl2.MedicineDAOImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SellMedicineGUI {

    MedicineDAOImpl updatingDbObject = new MedicineDAOImpl();

    public void sellMedicine(){
        Scanner scanner = new Scanner(System.in);
        int quantityOfMedicineToSell = 0;
        System.out.println("Podaj nazwę leku, który sprzedajesz:");
        String medicineForSellName = scanner.nextLine();
        System.out.println("Ile opakowań leku sprzedajesz?");
        do {
            try {
                quantityOfMedicineToSell = scanner.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.println("Zła liczba opakowań, wprowadź poprawną:");
            }
        }while(quantityOfMedicineToSell<=0);

        //DataBaseOperations.sellMedicine(medicineForSellName, quantityOfMedicineToSell);
        updatingDbObject.sellMedicine(updatingDbObject.getMedicines(medicineForSellName), quantityOfMedicineToSell);
    }
}
