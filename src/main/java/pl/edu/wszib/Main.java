package pl.edu.wszib;
import pl.edu.wszib.dao.Impl.DataBaseConnector;
import pl.edu.wszib.dao.Impl.*;
import pl.edu.wszib.dao.Impl2.MedicineDAOImpl;
import pl.edu.wszib.gui.Menu;
import pl.edu.wszib.model.Medicine;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
       // DataBaseConnector.connect();

        Menu menu = new Menu();
        menu.initializeMenu();
        /*
        Medicine lek = new Medicine();
        lek.setQuantity(20);
        lek.setMedicineName("Apap");
        lek.setNeedPrescription(false);
        lek.setPrice(20);
        lek.setId(1);
        MedicineDAOImpl zebyzadzialalo = new MedicineDAOImpl();
        zebyzadzialalo.addMedicines(lek);
         */

    }
}
