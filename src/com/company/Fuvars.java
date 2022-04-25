package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public Fuvar getLegBokezubbBorravaloju() {
        return this.fuvarLista.stream().max(Comparator.comparingDouble(Fuvar::getBorravaloViteldijAranya)).get();
    }
    public double getKilometerId(int id) {
        return this.fuvarLista.stream().filter(fuvar -> fuvar.getTaxi_id() == id).mapToDouble(Fuvar::getKilometer).sum();
    }
    public String szerepelE(int id) {
        return this.fuvarLista.stream().anyMatch(fuvar -> fuvar.getTaxi_id() == id) ? "igen" : "nem";
    }
    public List<Fuvar> getHaromLegrovidebbFuvar() {
        return fuvarLista.stream().filter(fuvar -> fuvar.getIdotartam() >= 1).sorted(Comparator.comparingInt(Fuvar::getIdotartam)).limit(3).collect(Collectors.toList());
    }
    public long getHanyFuvar(String string) {
        return fuvarLista.stream().filter(fuvar -> fuvar.getIndulas().contains(string)).count();
    }
    public double getFuvarBorravaloArany(String string) {
        return fuvarLista.stream().filter(fuvar -> fuvar.getIndulas().contains(string)).mapToDouble(fuvar -> fuvar.getBorravalo() / fuvar.getViteldij()).sum();
    }
    public Stream<Fuvar> getInvalids() {
        return this.fuvarLista.stream().filter(
                fuvar -> fuvar.getIdotartam() > 0 && fuvar.getViteldij() > 0.0 && fuvar.getTavolsag() == 0);
    }
    public long getNemValidCount() {
        return this.getInvalids().count();
    }

    public long getNemValidIdotartamSum() {
        return this.getInvalids().mapToInt(Fuvar::getIdotartam).sum();
    }

    public double getNemValidBevetelSum() {
        return this.getInvalids().mapToDouble(Fuvar::getBevetel).sum();
    }
}
