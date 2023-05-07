package com.classes;

import java.time.LocalDate;

public class CuentaFinanciera {

    private int id_cuentaDia;
    private LocalDate fecha;
    private double ganancia;
    private double perdida;
    private double inversion;

    public CuentaFinanciera() {
    }

    public CuentaFinanciera(int id_cuentaDia) {
        this.id_cuentaDia = id_cuentaDia;
    }

    public CuentaFinanciera(LocalDate fecha, double ganancia, double perdida, double inversion) {
        this.fecha = fecha;
        this.ganancia = ganancia;
        this.perdida = perdida;
        this.inversion = inversion;
    }

    public CuentaFinanciera(int id_cuentaDia, LocalDate fecha, double ganancia, double perdida, double inversion) {
        this.id_cuentaDia = id_cuentaDia;
        this.fecha = fecha;
        this.ganancia = ganancia;
        this.perdida = perdida;
        this.inversion = inversion;
    }

    public int getId_cuentaDi() {
        return id_cuentaDia;
    }

    public void setId_cuentaDi(int id_cuentaDia) {
        this.id_cuentaDia = id_cuentaDia;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    public double getPerdida() {
        return perdida;
    }

    public void setPerdida(double perdida) {
        this.perdida = perdida;
    }

    public double getInversion() {
        return inversion;
    }

    public void setInversion(double inversion) {
        this.inversion = inversion;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "id_cuentaDia=" + id_cuentaDia + ", fecha=" + fecha + ", ganancia=" + ganancia + ", perdida=" + perdida + ", inversion=" + inversion + '}';
    }
}
