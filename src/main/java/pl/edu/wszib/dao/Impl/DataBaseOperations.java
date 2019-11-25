package pl.edu.wszib.dao.Impl;

import pl.edu.wszib.dao.IMedicineDAO;
import pl.edu.wszib.model.Medicine;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseOperations {
    public static void addMedicines(Medicine medicine){
        String sqlInsert = " INSERT INTO Leki (id, medicinename, quantity, price, needpre) VALUES (?, ?, ?, ?, ?)";

        try{
            PreparedStatement preparedStatement = DataBaseConnector.connection.prepareStatement(sqlInsert);
            preparedStatement.setInt(1, medicine.getId());
            preparedStatement.setString(2, medicine.getMedicineName());
            preparedStatement.setInt(3, medicine.getQuantity());
            preparedStatement.setDouble(4, medicine.getPrice());
            preparedStatement.setBoolean(5, medicine.isNeedPrescription());

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static Medicine getMedicines(String nameOfMedicine){
        String sqlSelect = "SELECT * FROM Leki WHERE medicinename = ?";

        try {
            PreparedStatement preparedStatement = DataBaseConnector.connection.prepareStatement(sqlSelect);
            preparedStatement.setString(1, nameOfMedicine);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Medicine medicineTookFromDB = new Medicine();
                medicineTookFromDB.setId(resultSet.getInt("id"));
                medicineTookFromDB.setMedicineName(resultSet.getString("medicinename"));
                medicineTookFromDB.setPrice(resultSet.getDouble("price"));
                medicineTookFromDB.setQuantity(resultSet.getInt("quantity"));
                medicineTookFromDB.setNeedPrescription(resultSet.getBoolean("needpre"));

                return medicineTookFromDB;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void sellMedicine(String medicineForSell, int quantityYouWantToSell){
        String sqlUpdate = "UPDATE Leki SET quantity = quantity - ? WHERE medicinename = ? AND quantity > ?";

        try{
            PreparedStatement preparedStatement = DataBaseConnector.connection.prepareStatement(sqlUpdate);

            preparedStatement.setInt(1, quantityYouWantToSell);
            preparedStatement.setString(2, medicineForSell);
            preparedStatement.setInt(3, quantityYouWantToSell);

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


}
