package packWork;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.math.BigDecimal;

public class BonAnimal {
    private IntegerProperty Factura_ID;
    private IntegerProperty Animal_ID;
    private IntegerProperty Cantitate;

    public BonAnimal()
    {
        this.Factura_ID = new SimpleIntegerProperty();
        this.Animal_ID = new SimpleIntegerProperty();
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

    public int getAnimal_ID() {
        return Animal_ID.get();
    }

    public IntegerProperty animal_IDProperty() {
        return Animal_ID;
    }

    public void setAnimal_ID(int animal_ID) {
        this.Animal_ID.set(animal_ID);
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
