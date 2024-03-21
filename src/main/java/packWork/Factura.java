package packWork;

import javafx.beans.property.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

public class Factura {
    private IntegerProperty Factura_ID;
    private IntegerProperty Magazin_ID;
    private SimpleObjectProperty<LocalDateTime> Data_emitere;
    private ObjectProperty<BigDecimal> Suma_Totala;

    public Factura()
    {
        this.Factura_ID = new SimpleIntegerProperty();
        this.Magazin_ID = new SimpleIntegerProperty();
        this.Data_emitere = new SimpleObjectProperty<>();
        this.Suma_Totala = new SimpleObjectProperty<>(BigDecimal.ZERO);
    }

    public int getFactura_ID() {
        return Factura_ID.get();
    }

    public IntegerProperty factura_IDProperty() {
        return Factura_ID;
    }

    public void setFactura_ID(int factura_ID) {
        this.Factura_ID.set(factura_ID);
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

    public LocalDateTime getData_emitere() {
        return Data_emitere.get();
    }

    public SimpleObjectProperty<LocalDateTime> data_emitereProperty() {
        return Data_emitere;
    }

    public void setData_emitere(LocalDateTime data_emitere) {
        this.Data_emitere.set(data_emitere);
    }

    public BigDecimal getSuma_Totala() {
        return Suma_Totala.get();
    }

    public ObjectProperty<BigDecimal> suma_TotalaProperty() {
        return Suma_Totala;
    }

    public void setSuma_Totala(BigDecimal suma_Totala) {
        this.Suma_Totala.set(suma_Totala);
    }
}
