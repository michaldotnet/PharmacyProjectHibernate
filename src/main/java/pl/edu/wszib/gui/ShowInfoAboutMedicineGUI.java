package pl.edu.wszib.gui;

import pl.edu.wszib.dao.Impl.*;
import pl.edu.wszib.dao.Impl2.MedicineDAOImpl;
import pl.edu.wszib.model.Medicine;

import java.util.Scanner;

public class ShowInfoAboutMedicineGUI {

    MedicineDAOImpl selectFromDbObject = new MedicineDAOImpl();


    public void showMedicineInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę leku, o ktrórym chcesz zobaczyć informacje:");
        String medicineNameFromUser = scanner.nextLine();
        //Medicine medicine = DataBaseOperations.getMedicines(medicineNameFromUser);
        Medicine medicine = selectFromDbObject.getMedicines(medicineNameFromUser);

        try {
            System.out.println(medicine.toString());
        }catch(NullPointerException e){
            System.out.println("Nie ma takiego leku.");
        }
    }
}
