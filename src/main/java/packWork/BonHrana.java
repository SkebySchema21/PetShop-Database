package packWork;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BonHrana {

    private IntegerProperty Factura_ID;
    private IntegerProperty Hrana_ID;
    private IntegerProperty Cantitate;

    public BonHrana()
    {
        this.Factura_ID = new SimpleIntegerProperty();
        this.Hrana_ID = new SimpleIntegerProperty();
        this.Cantitate = new SimpleIntegerProperty();
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

    public int getHrana_ID() {
        return Hrana_ID.get();
    }

    public IntegerProperty hrana_IDProperty() {
        return Hrana_ID;
    }

    public void setHrana_ID(int hrana_ID) {
        this.Hrana_ID.set(hrana_ID);
    }

    public int getCantitate() {
        return Cantitate.get();
    }

    public IntegerProperty cantitateProperty() {
        return Cantitate;
    }

    public void setCantitate(int cantitate) {
        this.Cantitate.set(cantitate);
    }
}
