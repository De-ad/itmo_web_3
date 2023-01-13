package web3.web3.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import web3.web3.entity.CoordinatesRow;
import web3.web3.util.SessionFactoryManager;

import java.io.Serializable;
import java.util.List;

public class RowDaoImpl implements RowDao, Serializable {

    @Override
    public void addRow(CoordinatesRow coordinatesRow) {
        Session session = SessionFactoryManager.getSession().openSession();
//      session.beginTransaction?
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.save(coordinatesRow);
            transaction.commit();
        }
        catch (Exception e){
            if (transaction.getStatus() == TransactionStatus.MARKED_ROLLBACK || transaction.isActive())
            transaction.rollback();
        }
        finally {
            session.close();
        }

    }

    @Override
    public void clean() {
        Session session = SessionFactoryManager.getSession().openSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        transaction.commit();
    }

    @Override
    public List<CoordinatesRow> getAll() {
        Session session = SessionFactoryManager.getSession().openSession();
        Transaction transaction = session.beginTransaction();
         List<CoordinatesRow> coordinatesRows = (List<CoordinatesRow>) SessionFactoryManager
                .getSession()
                .openSession()
                .createQuery("From CoordinatesRow").list();
         return coordinatesRows;
    }
}
