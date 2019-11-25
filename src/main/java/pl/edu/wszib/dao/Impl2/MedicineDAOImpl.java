package pl.edu.wszib.dao.Impl2;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pl.edu.wszib.dao.IMedicineDAO;
import pl.edu.wszib.model.Medicine;

public class MedicineDAOImpl implements IMedicineDAO {
    private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void addMedicines(Medicine medicine){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(medicine);
            //wiecej operacji
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null) tx.rollback();
        } finally {
            session.close();
        }
    }

    public Medicine getMedicines(String nameOfMedicine){
        Session session = factory.openSession();

        Medicine medicine = (Medicine) session.createQuery("FROM pl.edu.wszib.model.Medicine WHERE medicinename = '" + nameOfMedicine + "'").uniqueResult();

        session.close();
        return medicine;
    }
    public void sellMedicine(Medicine medicineForSell, int quantityYouWantToSell){
        Session session = factory.openSession();
        Medicine medicine = medicineForSell;
        medicine.setQuantity(medicine.getQuantity()-quantityYouWantToSell);

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(medicine);
            //wiecej operacji
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null) tx.rollback();
        } finally {
            session.close();
        }
    }

}
