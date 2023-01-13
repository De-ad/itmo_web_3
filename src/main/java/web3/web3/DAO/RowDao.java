package web3.web3.DAO;

import web3.web3.entity.CoordinatesRow;

import java.util.List;

public interface RowDao{

    public void addRow(CoordinatesRow coordinatesRow);
    public void clean();
    public List<CoordinatesRow> getAll();

}
