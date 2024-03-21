package packWork;

import javafx.beans.property.*;

import java.math.BigDecimal;
import java.sql.Date;

public class Magazin {
    private IntegerProperty Magazin_ID;
    private StringProperty Judet;
    private StringProperty Oras;
    private StringProperty Strada;
    private StringProperty Numar;
    private SimpleObjectProperty<Date> Data_deschidere;
    private ObjectProperty<BigDecimal> Chirie_luna;

    public Magazin()
    {
        this.Magazin_ID = new SimpleIntegerProperty();
        this.Judet = new SimpleStringProperty();
        this.Oras = new SimpleStringProperty();
        this.Strada = new SimpleStringProperty();
        this.Numar = new SimpleStringProperty();
        this.Data_deschidere = new SimpleObjectProperty<>();
    }
    public int getMagazin_ID() {
        return Magazin_ID.get();
    }

    public IntegerProperty magazin_IDProperty() {
        return Magazin_ID;
    }

    public void setMagazin_ID(int magazin_ID) {
        this.Magazin_ID.set(magazin_ID);
    }

    public String getJudet() {
        return Judet.get();
    }

    public StringProperty judetProperty() {
        return Judet;
    }

    public void setJudet(String judet) {
        this.Judet.set(judet);
    }

    public String getOras() {
        return Oras.get();
    }

    public StringProperty orasProperty() {
        return Oras;
    }

    public void setOras(String oras) {
        this.Oras.set(oras);
    }

    public String getStrada() {
        return Strada.get();
    }

    public StringProperty stradaProperty() {
        return Strada;
    }

    public void setStrada(String strada) {
        this.Strada.set(strada);
    }

    public String getNumar() {
        return Numar.get();
    }

    public StringProperty numarProperty() {
        return Numar;
    }

    public void setNumar(String numar) {
        this.Numar.set(numar);
    }

    public Date getData_deschidere() {
        return Data_deschidere.get();
    }

    public SimpleObjectProperty<Date> data_deschidereProperty() {
        return Data_deschidere;
    }

    public void setData_deschidere(Date data_deschidere) {
        this.Data_deschidere.set(data_deschidere);
    }

    public BigDecimal getChirie_luna() {
        return Chirie_luna.get();
    }

    public ObjectProperty<BigDecimal> chirie_lunaProperty() {
        return Chirie_luna;
    }

    public void setChirie_luna(BigDecimal chirie_luna) {
        this.Chirie_luna.set(chirie_luna);
    }
}
