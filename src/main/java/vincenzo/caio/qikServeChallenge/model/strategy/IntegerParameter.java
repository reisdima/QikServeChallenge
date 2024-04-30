package vincenzo.caio.qikServeChallenge.model.strategy;


public class IntegerParameter extends Parameter {

    Integer value;

    public IntegerParameter(String name, Integer value) {
        super(name);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
