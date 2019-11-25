package pl.edu.wszib.gui;

import pl.edu.wszib.dao.Impl.*;
import pl.edu.wszib.dao.Impl2.MedicineDAOImpl;
import pl.edu.wszib.model.Medicine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddMedicineGUI {


    MedicineDAOImpl addingToDbObject = new MedicineDAOImpl();

    public void addMedicine(){
        Scanner scanner = new Scanner(System.in);
        Medicine tempMedicine = new Medicine();

        tempMedicine.setMedicineName(medicineNameDialog());
        tempMedicine.setPrice(priceDialog());
        tempMedicine.setQuantity(quantityDialog());
        tempMedicine.setNeedPrescription(prescriptionDialog());

        //DataBaseOperations.addMedicines(tempMedicine);
        addingToDbObject.addMedicines(tempMedicine);


    }

    public boolean prescriptionDialog(){
        System.out.println("Czy lek jest na recepte?(tak/nie)");
        Scanner scanner = new Scanner(System.in);
        String userInputBeforeConvertingToBoolean;
        do {
            userInputBeforeConvertingToBoolean = scanner.nextLine();
        }while(!userInputBeforeConvertingToBoolean.equals("tak") && !userInputBeforeConvertingToBoolean.equals("nie"));
        if(userInputBeforeConvertingToBoolean.equals("tak")){
            return true;
        }
            return false;
    }

    public String medicineNameDialog(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę leku:");
        return scanner.nextLine();
    }

    public double priceDialog(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj cenę jednostkową:");
        while(true) {
            try {
                double medicinePrice = scanner.nextDouble();
                return medicinePrice;
            }catch (InputMismatchException e){
                e.getMessage();
                System.out.println("Zły format ceny, podaj poprawną cenę:");
            }
        }
    }

    public int quantityDialog(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ilosc opakowan leku:");
        while(true){
            try{
                int medicineQuantity = scanner.nextInt();
                return medicineQuantity;
            }catch(InputMismatchException e){
                e.getMessage();
                System.out.println("Zły format ceny, podaj poprawną ilość opakowań:");
            }
        }
    }




}