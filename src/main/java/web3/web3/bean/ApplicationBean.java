package web3.web3.bean;


import web3.web3.DAO.RowDaoImpl;
import web3.web3.entity.CoordinatesRow;
import web3.web3.util.HitChecker;
import web3.web3.util.ValidatorForX;
import web3.web3.util.ValidatorForY;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
@ManagedBean(name = "applicationBean")
public class ApplicationBean implements Serializable{
    public List<CoordinatesRow> coordinatesRowList;
    public HitChecker hitChecker;
    public RowDaoImpl rowDao;

    public void setCoordinatesRow(){

    }




    public void add(CoordinatesRow coordinatesRow){
        if (hitChecker.checkHit(coordinatesRow.getX(), coordinatesRow.getY(), coordinatesRow.getR())) {
            rowDao.addRow(coordinatesRow);

        }
    }



    public void clean(){
        rowDao.clean();
    }

}
