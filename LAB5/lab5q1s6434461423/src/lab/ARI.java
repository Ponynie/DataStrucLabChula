package lab;

public class ARI {
    private String parameter , localVariable , nextParameter , returnValue;

    public ARI(String parameter , String localVariable , String nextParameter , String returnValue) {
        this.parameter = parameter;
        this.localVariable = localVariable;
        this.nextParameter = nextParameter;
        this.returnValue = returnValue;
    }
    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }
    public String toString() {
        return "parameter = " + this.parameter + "\nlocalVariable = " + this.localVariable + "\nnextParameter = " + this.nextParameter + "\nreturnValue = " + this.returnValue + "\n";
    }
}
