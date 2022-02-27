package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Fuvars {
    private List<Fuvar> fuvarLista;

    public Fuvars(String fajl) {
        fuvarLista = new ArrayList<>();
        try {
            FileReader fr = new FileReader(fajl);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            String sor = br.readLine();
            while (sor != null) {
                fuvarLista.add(new Fuvar(sor));
                sor = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public long getfuvarCount() {
        return this.fuvarLista.stream().count();
    }
    public long gethanyFuvar(int id) {
        return this.fuvarLista.stream().filter(fuvar -> fuvar.getTaxi_id() == id).count();
    }
    public double getEgyediBevetel(int id) {
        return this.fuvarLista.stream().filter(fuvar -> fuvar.getTaxi_id() == id).mapToDouble(Fuvar::getBevetel).sum();
    }
    public double getMerfold() {
        return this.fuvarLista.stream().mapToDouble(Fuvar::getTavolsag).sum();
    }
    public Fuvar getLeghosszabbIdotartam() {
        return this.fuvarLista.stream().max(Comparator.comparingInt(Fuvar::getIdotartam)).get();
    }
}
