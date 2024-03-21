package packWork;

import javafx.beans.property.*;

public class HranaAnimal {
    private IntegerProperty Animal_ID;
    private IntegerProperty Hrana_ID;
    private StringProperty Disponabilitate_depozit;

    public HranaAnimal()
    {
        this.Animal_ID = new SimpleIntegerProperty();
        this.Hrana_ID = new SimpleIntegerProperty();
        this.Disponabilitate_depozit = new SimpleStringProperty();
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

    public int getHrana_ID() {
        return Hrana_ID.get();
    }

    public IntegerProperty hrana_IDProperty() {
        return Hrana_ID;
    }

    public void setHrana_ID(int hrana_ID) {
        this.Hrana_ID.set(hrana_ID);
    }

    public String getDisponabilitate_depozit() {
        return Disponabilitate_depozit.get();
    }

    public StringProperty disponabilitate_depozitProperty() {
        return Disponabilitate_depozit;
    }

    public void setDisponabilitate_depozit(String disponabilitate_depozit) {
        this.Disponabilitate_depozit.set(disponabilitate_depozit);
    }
}
