package scoa.desktop.views;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student extends RecursiveTreeObject<Student> {
    private SimpleStringProperty dre, nome;
    private SimpleIntegerProperty faltas;
    private SimpleFloatProperty media;

    public String getDre() {
        return dre.get();
    }

    public SimpleStringProperty dreProperty() {
        return dre;
    }

    public void setDre(String dre) {
        this.dre.set(dre);
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public int getFaltas() {
        return faltas.get();
    }

    public SimpleIntegerProperty faltasProperty() {
        return faltas;
    }

    public void setFaltas(Integer faltas) {
        this.faltas.set(faltas);
    }

    public float getMedia() {
        return media.get();
    }

    public SimpleFloatProperty mediaProperty() {
        return media;
    }

    public void setMedia(float media) {
        this.media.set(media);
    }

    public Student(String dre, String nome, Integer faltas, Float media) {
        this.dre = new SimpleStringProperty(dre);
        this.nome = new SimpleStringProperty(nome);
        this.faltas = new SimpleIntegerProperty(faltas);
        this.media = new SimpleFloatProperty(media);
    }
}
