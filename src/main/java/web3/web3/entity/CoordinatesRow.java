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
    private boolean result;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getxValue() {
        return xValue;
    }

    public void setxValue(Double xValue) {
        this.xValue = xValue;
    }

    public Double getyValue() {
        return yValue;
    }

    public void setyValue(Double yValue) {
        this.yValue = yValue;
    }

    public Integer getrValue() {
        return rValue;
    }

    public void setrValue(Integer rValue) {
        this.rValue = rValue;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
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
