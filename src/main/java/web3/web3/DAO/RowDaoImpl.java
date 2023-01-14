package web3.web3.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import web3.web3.entity.CoordinatesRow;
import web3.web3.util.SessionFactoryManager;

import java.io.Serializable;
import java.util.List;

public class RowDaoImpl implements RowDao, Serializable {
        private final SessionFactory manager = SessionFactoryManager.getSession();

    @Override
    public void addRow(CoordinatesRow coordinatesRow) {
        Session session = manager.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(coordinatesRow);
            transaction.commit();
        }
        catch (Exception e){
            if (transaction.getStatus() == TransactionStatus.MARKED_ROLLBACK || transaction.isActive())
            transaction.rollback();
        }

    }

    @Override
    public List<CoordinatesRow> getAll() {
        Session currentSession = manager.getCurrentSession();
        currentSession.beginTransaction();
        return currentSession.createQuery( "FROM CoordinatesRow ").list();
    }

    @Override
    public void clean() {
        Session currentSession = manager.getCurrentSession();
        currentSession.beginTransaction();
        currentSession.clear();
        currentSession.getTransaction().commit();
    }
}
