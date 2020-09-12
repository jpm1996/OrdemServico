package com.unidesk.estagio.model;


public class OrdemServico {
    @Override
    public String toString() {
        return "OrdemServico{" +
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
                ", check5=" + check5 +
                ", status=" + status +
                '}';
    }

    private String Nome;
    private String Data;
    private String Nposte;
    private String Rua;
    private String Bairro;
    private String Numerocasa;
    private String Outro;
    private boolean check1;
    private boolean check2;
    private boolean check3;
    private boolean check4;
    private boolean check5;
    private String status;

    public boolean isCheck5() {
        return check5;
    }

    public void setCheck5(boolean check5) {
        this.check5 = check5;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getNumerocasa() {
        return Numerocasa;
    }

    public void setNumerocasa(String numerocasa) {
        Numerocasa = numerocasa;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        this.Bairro = bairro;
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
