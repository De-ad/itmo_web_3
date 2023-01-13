package web3.web3.util;

public class HitChecker {


    boolean checkCircle(double xValue,double yValue,int rValue){
        return ((xValue <= 0) && (yValue >= 0) && (Math.pow(rValue/2, 2) <= Math.pow(yValue, 2) + Math.pow(xValue, 2)));
    }

    boolean checkRectangle(double xValue,double yValue,int rValue){
        return ((xValue <= 0) && (xValue >= -rValue) && (yValue <= 0) && (yValue >= -rValue/2));
    }

    boolean checkTriangle(double xValue,double yValue,int rValue){
        return ((xValue >= 0) && (yValue <= 0 ) && (yValue-xValue <=rValue));
    }

    public boolean checkHit(double xValue,double yValue,int rValue){
        return (checkTriangle(xValue, yValue, rValue) ||
                checkCircle(xValue, yValue, rValue) ||
                checkRectangle(xValue, yValue, rValue));
    }


}
