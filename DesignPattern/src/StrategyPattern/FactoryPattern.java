package StrategyPattern;
abstract class Operation {
    private double numberA;
    private double numberB;
    void setNumberA(double numberA){
        this.numberA = numberA;
    }
    double getNumberA(){
        return this.numberA;
    }
    void setNumberB(double numberB){
        this.numberB = numberB;
    }
    double gerNumberB(){
        return this.numberB;
    }
    public abstract double GetResult();
}
class OperationAdd extends Operation {

    @Override
    public double GetResult() {
        return super.getNumberA() + super.gerNumberB();
    }
}
class OperationSub extends Operation {

    @Override
    public double GetResult() {
        return super.getNumberA() - super.gerNumberB();
    }
}
class OperationMul extends Operation {

    @Override
    public double GetResult() {
        return super.getNumberA() * super.gerNumberB();
    }
}
class OperationDiv extends Operation {

    @Override
    public double GetResult() {
        return super.gerNumberB() == 0 ? super.getNumberA() / super.gerNumberB() : Double.MAX_VALUE;

    }
}

class OperationFactory{
    public static Operation createOperate(String operate){
        Operation ope = null;
        switch (operate){
            case "+":
                ope = new OperationAdd();
                break;
            case "-":
                ope = new OperationSub();
                break;
            case "*":
                ope = new OperationMul();
                break;
            case "/":
                ope = new OperationDiv();
                break;
        }
        return ope;
    }
}
public class FactoryPattern {
    public static void main(String [] args){
        Operation oper = OperationFactory.createOperate("+");
        oper.setNumberA(1);
        oper.setNumberB(2);
        double result = oper.GetResult();
        System.out.println(result);
    }
}
