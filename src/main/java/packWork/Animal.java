package packWork;

import javafx.beans.property.*;

import java.math.BigDecimal;
import java.sql.Date;

public class Animal {
    private IntegerProperty Animal_ID;
    private IntegerProperty Specie_ID;

    private SimpleObjectProperty<Date> Data_nastere;
    private ObjectProperty<BigDecimal> Pret;
    private StringProperty Sex;

    public Animal()
    {
        this.Animal_ID = new SimpleIntegerProperty();
        this.Specie_ID = new SimpleIntegerProperty();
        this.Data_nastere = new SimpleObjectProperty<>();
        this.Pret = new SimpleObjectProperty<>(BigDecimal.ZERO);
        this.Sex = new SimpleStringProperty();
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

    public int getSpecie_ID() {
        return Specie_ID.get();
    }

    public IntegerProperty specie_IDProperty() {
        return Specie_ID;
    }

    public void setSpecie_ID(int specie_ID) {
        this.Specie_ID.set(specie_ID);
    }

    public Date getData_nastere() {
        return Data_nastere.get();
    }

    public SimpleObjectProperty<Date> data_nastereProperty() {
        return Data_nastere;
    }

    public void setData_nastere(Date data_nastere) {
        this.Data_nastere.set(data_nastere);
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

    public String getSex() {
        return Sex.get();
    }

    public StringProperty sexProperty() {
        return Sex;
    }

    public void setSex(String sex) {
        this.Sex.set(sex);
    }
}
