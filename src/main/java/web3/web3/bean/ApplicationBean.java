package web3.web3.bean;


import web3.web3.DAO.RowDaoImpl;
import web3.web3.entity.CoordinatesRow;
import web3.web3.util.HitChecker;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@ManagedBean(name = "applicationBean")
public class ApplicationBean implements Serializable{
    private RowDaoImpl rowDao = new RowDaoImpl();
    private  List<CoordinatesRow> coordinatesRowList = new ArrayList<>();
    private HitChecker hitChecker = new HitChecker();
    private CoordinatesRow coordinatesRow = new CoordinatesRow();

    public ApplicationBean() {

    }

    public List<CoordinatesRow> getCoordinatesRowList() {
        return coordinatesRowList;
    }

    public void setCoordinatesRowList(List<CoordinatesRow> coordinatesRowList) {
        this.coordinatesRowList = coordinatesRowList;
    }

    public void add(){
// TODO: verify getting data
        // TODO: nano time

        System.out.println(coordinatesRow.getxValue());
        System.out.println(coordinatesRow.getyValue());
        System.out.println(coordinatesRow.getrValue());

        coordinatesRow.setResult(hitChecker.checkHit(coordinatesRow.getxValue(),
                coordinatesRow.getyValue(), coordinatesRow.getrValue()));

//        TODO:fix database
        System.out.println(coordinatesRow);
        rowDao.addRow(coordinatesRow);

    }

    public CoordinatesRow getCoordinatesRow() {
        return coordinatesRow;
    }

    public void setCoordinatesRow(CoordinatesRow coordinatesRow) {
        this.coordinatesRow = coordinatesRow;
    }

    public void clean(){
        rowDao.clean();
        coordinatesRowList.clear();
    }

}
