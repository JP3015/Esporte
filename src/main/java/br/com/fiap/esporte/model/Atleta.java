package br.com.fiap.esporte.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name="atleta",sequenceName = "SQ_T_ATLETA",allocationSize = 1)
public class Atleta {

    @Id
    @GeneratedValue(generator = "atleta", strategy = GenerationType.SEQUENCE)
    private int codigo;

    private String nome;

    private LocalDate dataNascimento;

    @ManyToOne
    private Modalidade modalidade;

    private boolean lesionado;

    public boolean isLesionado() {
        return lesionado;
    }

    public void setLesionado(boolean lesionado) {
        this.lesionado = lesionado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }
}
