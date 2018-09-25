/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

/**
 *
 * @author agus
 */
public class tipoDeHabitacion {
    
    private char codigo ;
    private int cantidadDePersonasMaximas;
    private int cantidadDeCamas;
    private String tipoDeCamas;
    private double tarifaPorNoche;

    public char getCodigo() {
        return codigo;
    }

    public void setCodigo(char codigo) {
        this.codigo = codigo;
    }

    public int getCantidadDePersonasMaximas() {
        return cantidadDePersonasMaximas;
    }

    public void setCantidadDePersonasMaximas(int cantidadDePersonasMaximas) {
        this.cantidadDePersonasMaximas = cantidadDePersonasMaximas;
    }

    public int getCantidadDeCamas() {
        return cantidadDeCamas;
    }

    public void setCantidadDeCamas(int cantidadDeCamas) {
        this.cantidadDeCamas = cantidadDeCamas;
    }

    public String getTipoDeCamas() {
        return tipoDeCamas;
    }

    public void setTipoDeCamas(String tipoDeCamas) {
        this.tipoDeCamas = tipoDeCamas;
    }

    public double getTarifaPorNoche() {
        return tarifaPorNoche;
    }

    public void setTarifaPorNoche(double tarifaPorNoche) {
        this.tarifaPorNoche = tarifaPorNoche;
    }

    public tipoDeHabitacion(char codigo, int cantidadDePersonasMaximas, int cantidadDeCamas, String tipoDeCamas, double tarifaPorNoche) {
        this.codigo = codigo;
        this.cantidadDePersonasMaximas = cantidadDePersonasMaximas;
        this.cantidadDeCamas = cantidadDeCamas;
        this.tipoDeCamas = tipoDeCamas;
        this.tarifaPorNoche = tarifaPorNoche;
    }
}
