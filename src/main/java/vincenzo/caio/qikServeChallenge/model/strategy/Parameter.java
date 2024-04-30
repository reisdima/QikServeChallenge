package vincenzo.caio.qikServeChallenge.model.strategy;

public abstract class Parameter {
    private final String name;

    protected Parameter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
