package web3.web3.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "coordinates", schema = "results")
public class CoordinatesRow implements Serializable {
    private static final long serialVersionUID = 1L;
    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(generator = "generator")
    private int id;
    @Column(name = "X_COORD")
    private Double xValue;
    @Column(name = "Y_COORD")
    private Double yValue;
    @Column(name = "R_VAL")
    private Integer rValue;
    private String result;


    public CoordinatesRow() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getX() {
        return xValue;
    }

    public void setX(double x) {
        xValue = x;
    }

    public double getY() {
        return yValue;
    }

    public void setY(double y) {
        yValue = y;
    }

    public int getR() {
        return rValue;
    }

    public void setR(int r) {
        rValue = r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinatesRow that = (CoordinatesRow) o;
        return id == that.id && Objects.equals(xValue, that.xValue) && Objects.equals(yValue, that.yValue) && Objects.equals(rValue, that.rValue) && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, xValue, yValue, rValue, result);
    }

    @Override
    public String toString() {
        return "CoordinatesRow{" +
                "id=" + id +
                ", xValue=" + xValue +
                ", yValue=" + yValue +
                ", rValue=" + rValue +
                ", result='" + result + '\'' +
                '}';
    }
}
