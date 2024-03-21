package packWork;

import javafx.beans.property.*;

import java.math.BigDecimal;

public class Specie {
    private IntegerProperty Specie_ID;
    private StringProperty Denumire_latina;
    private StringProperty Familie;

    public Specie()
    {
        this.Specie_ID = new SimpleIntegerProperty();
        this.Denumire_latina = new SimpleStringProperty();
        this.Familie = new SimpleStringProperty();
    }

    public int getSpecie_ID() {
        return Specie_ID.get();
    }

    public IntegerProperty specie_IDProperty() {
        return Specie_ID;
    }

    public void setSpecie_ID(int specie_ID) {
        this.Specie_ID.set(specie_ID);
    }

    public String getDenumire_latina() {
        return Denumire_latina.get();
    }

    public StringProperty denumire_latinaProperty() {
        return Denumire_latina;
    }

    public void setDenumire_latina(String denumire_latina) {
        this.Denumire_latina.set(denumire_latina);
    }

    public String getFamilie() {
        return Familie.get();
    }

    public StringProperty familieProperty() {
        return Familie;
    }

    public void setFamilie(String familie) {
        this.Familie.set(familie);
    }
}
