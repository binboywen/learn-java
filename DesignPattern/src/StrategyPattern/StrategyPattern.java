package StrategyPattern;

abstract class CashSuper{
    public abstract double acceptCash(double money);
}

class CashNormal extends CashSuper{

    @Override
    public double acceptCash(double money) {
        return money;
    }
}
class CashRedate extends CashSuper{
    private double moneyRebate;
     CashRedate(double moneyRebate){
        this.moneyRebate = moneyRebate;
    }
    @Override
    public double acceptCash(double money) {
        return this.moneyRebate*money;
    }
}
class CashReturn extends CashSuper{
    private double moneyCondition;
    private double moneyReturn;
     CashReturn(double moneyCondition, double moneyReturn){
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }
    @Override
    public double acceptCash(double money) {
        double result = money;
        if(money>=moneyCondition){
            result = money - Math.floor(money / moneyCondition) * moneyReturn;
        }
        return result;
    }
}

class CashContext{
    private CashSuper cs;
    public CashContext(String type){
        switch(type){
            case "正常收费":
                CashNormal cs0 = new CashNormal();
                cs = cs0;
                break;
            case "满300返100":
                CashReturn cr1 = new CashReturn(300,100);
                cs = cr1;
                break;
            case "打八折":
                CashRedate cr2 = new CashRedate(0.8);
                cs = cr2;
                break;
        }
    }
    public double GetResult(double money){
        return cs.acceptCash(money);
    }
}

public class StrategyPattern{
    public static void main(String [] args){
        CashContext csuper = new CashContext("满300返100");
        System.out.println(csuper.GetResult(500));
    }
}