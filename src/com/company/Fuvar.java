package com.company;

public class Fuvar {
    private int taxi_id;
    private String indulas;
    private int idotartam;
    private double tavolsag;
    private double viteldij;
    private double borravalo;
    private String fizetes_modja;

    public Fuvar(String sor) {
        String[] s = sor.split(";");
        this.taxi_id = Integer.parseInt(s[0]);
        this.indulas = s[1];
        this.idotartam = Integer.parseInt(s[2]);
        this.tavolsag = Double.parseDouble(s[3].replace(',','.'));
        this.viteldij = Double.parseDouble(s[4].replace(',','.'));
        this.borravalo = Double.parseDouble(s[5].replace(',','.'));
        this.fizetes_modja = s[6];
    }

    public int getTaxi_id() {
        return taxi_id;
    }

    public String getIndulas() {
        return indulas;
    }

    public int getIdotartam() {
        return idotartam;
    }

    public double getTavolsag() {
        return tavolsag;
    }

    public double getViteldij() {
        return viteldij;
    }

    public double getBorravalo() {
        return borravalo;
    }

    public String getFizetes_modja() {
        return fizetes_modja;
    }

    public double getBevetel(){
        return getBorravalo()+getViteldij();
    }
    public double getBorravaloViteldijAranya(){
        return this.borravalo/this.getViteldij();
    }
    public double getKilometer(){
        return this.tavolsag *1.6;
    }



    @Override
    public String toString() {
        return "Fuvar: " +
                "taxi_id=" + taxi_id +
                ", indulas='" + indulas +
                ", idotartam=" + idotartam +
                ", tavolsag=" + tavolsag +
                ", viteldij=" + viteldij +
                ", borravalo=" + borravalo +
                ", fizetes_modja=" + fizetes_modja;
    }
}