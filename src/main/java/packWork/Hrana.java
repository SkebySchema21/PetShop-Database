package packWork;

import javafx.beans.property.*;

import java.math.BigDecimal;
import java.sql.Date;

public class Hrana {
    private IntegerProperty Hrana_ID;
    private SimpleObjectProperty<Date> Data_expirare;
    private ObjectProperty<BigDecimal> Pret;

    private DoubleProperty Gramaj;

    private StringProperty Cod_bare;

    public Hrana()
    {
        this.Hrana_ID = new SimpleIntegerProperty();
        this.Data_expirare = new SimpleObjectProperty<>();
        this.Pret = new SimpleObjectProperty<>(BigDecimal.ZERO);
        this.Gramaj = new SimpleDoubleProperty();
        this.Cod_bare = new SimpleStringProperty();
    }

    public int getHrana_ID() {
        return Hrana_ID.get();
    }

    public IntegerProperty hrana_IDProperty() {
        return Hrana_ID;
    }

    public void setHrana_ID(int hrana_ID) {
        this.Hrana_ID.set(hrana_ID);
    }

    public Date getData_expirare() {
        return Data_expirare.get();
    }

    public SimpleObjectProperty<Date> data_expirareProperty() {
        return Data_expirare;
    }

    public void setData_expirare(Date data_expirare) {
        if (data_expirare != null) {
            this.Data_expirare.set(data_expirare);
        } else {
            // this.Data_expirare.set(null);
        }
    }

    public BigDecimal getPret() {
        return Pret.get();
    }

    public ObjectProperty<BigDecimal> pretProperty() {
        return Pret;
    }

    public void setPret(BigDecimal pret) {
        this.Pret.set(pret);
    }

    public double getGramaj() {
        return Gramaj.get();
    }

    public DoubleProperty gramajProperty() {
        return Gramaj;
    }

    public void setGramaj(double gramaj) {
        this.Gramaj.set(gramaj);
    }

    public String getCod_bare() {
        return Cod_bare.get();
    }

    public StringProperty cod_bareProperty() {
        return Cod_bare;
    }

    public void setCod_bare(String cod_bare) {
        this.Cod_bare.set(cod_bare);
    }
}
