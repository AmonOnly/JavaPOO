package dados;

public abstract class FormaGeomatrica {
    protected int medida1;
    protected int medida2;

    public void setMedida1(int medida1) {
        this.medida1 = medida1;
    }

    public void setMedida2(int medida2) {
        this.medida2 = medida2;
    }

    public abstract double calculaArea();
    public abstract double calculaPerimetro();

}
