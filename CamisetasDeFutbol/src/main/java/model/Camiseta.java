package model;

public class Camiseta {
    private int idCamiseta;
    private String equipo;
    private String pais;
    private String tipo;
    private String talle;
    private int año;
    private double valor;
    private int stock;

    public Camiseta(int idCamiseta, String equipo, String pais, String tipo, String talle, int año, double valor, int stock) {
        this.idCamiseta = idCamiseta;
        this.equipo = equipo;
        this.pais = pais;
        this.tipo = tipo;
        this.talle = talle;
        this.año = año;
        this.valor = valor;
        this.stock = stock;
    }

    public Camiseta(String equipo, String pais, String tipo, String talle, int año, double valor, int stock) {
        this.equipo = equipo;
        this.pais = pais;
        this.tipo = tipo;
        this.talle = talle;
        this.año = año;
        this.valor = valor;
        this.stock = stock;
    }

    public int getIdCamiseta() {
        return idCamiseta;
    }

    public void setIdCamiseta(int idCamiseta) {
        this.idCamiseta = idCamiseta;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Camiseta{" + "equipo=" + equipo + ", pais=" + pais + ", tipo=" + tipo + ", talle=" + talle + ", año=" + año + ", valor=" + valor + ", stock=" + stock + "}";
    }
}
