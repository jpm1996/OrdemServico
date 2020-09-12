package com.unidesk.estagio.model;


public class OrdemServico {
    @Override
    public String toString() {
        return "OrdemServico{" +
                "id='" + id + '\'' +
                ", Nome='" + Nome + '\'' +
                ", Data='" + Data + '\'' +
                ", Nposte='" + Nposte + '\'' +
                ", Rua='" + Rua + '\'' +
                ", Bairro='" + Bairro + '\'' +
                ", Numerocasa='" + Numerocasa + '\'' +
                ", Outro='" + Outro + '\'' +
                ", check1=" + check1 +
                ", check2=" + check2 +
                ", check3=" + check3 +
                ", check4=" + check4 +
                '}';
    }

    private String id;
    private String Nome;
    private String Data;
    private String Nposte;
    private String Rua;
    private String Bairro;
    private int Numerocasa;
    private String Outro;
    private boolean check1;
    private boolean check2;
    private boolean check3;
    private boolean check4;

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        this.Bairro = bairro;
    }

    public int getNumerocasa() {
        return Numerocasa;
    }

    public void setNumerocasa(int numerocasa) {
        this.Numerocasa = numerocasa;
    }

    public String getOutro() {
        return Outro;
    }

    public void setOutro(String outro) {
        Outro = outro;
    }

    public boolean isCheck1() {
        return check1;
    }

    public void setCheck1(boolean check1) {
        this.check1 = check1;
    }

    public boolean isCheck2() {
        return check2;
    }

    public void setCheck2(boolean check2) {
        this.check2 = check2;
    }

    public boolean isCheck3() {
        return check3;
    }

    public void setCheck3(boolean check3) {
        this.check3 = check3;
    }

    public boolean isCheck4() {
        return check4;
    }

    public void setCheck4(boolean check4) {
        this.check4 = check4;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getNposte() {
        return Nposte;
    }

    public void setNposte(String nposte) {
        Nposte = nposte;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String rua) {
        Rua = rua;
    }

    public OrdemServico() {


    }
}
