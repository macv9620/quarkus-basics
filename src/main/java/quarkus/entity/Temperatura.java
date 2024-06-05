package quarkus.entity;

public class Temperatura {
    private String ciudad;
    private int min;
    private int max;

    public Temperatura() {
    }

    public Temperatura(String ciudad, int min, int max) {
        this.ciudad = ciudad;
        this.min = min;
        this.max = max;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "Temperatura{" +
                "ciudad='" + ciudad + '\'' +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
