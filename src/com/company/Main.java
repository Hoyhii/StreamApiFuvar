package com.company;

public class Main {

    public static void main(String[] args) {
        Fuvars fuvars = new Fuvars("fuvar.csv");
        System.out.println("első feladat: "+fuvars.getfuvarCount());
        System.out.println("masodik feladat, ennyi fuvarja volt a 6185-ös taxisnak: "+fuvars.gethanyFuvar(6185) + " Bevétele: " + fuvars.getEgyediBevetel(6185));
        System.out.println("harmadik feladat: "+fuvars.getMerfold());
        System.out.println("negyedik feladat: "+fuvars.getLeghosszabbIdotartam());
        System.out.println("otodik feladat: "+fuvars.getLegBokezubbBorravaloju());
        System.out.println("hatodik feladat: "+fuvars.getKilometerId(4261));
        System.out.println("nyolcadik feladat: "+fuvars.szerepelE(1452));
        System.out.println("kilencedik feladat: ");
        for (Fuvar fuvar : fuvars.getHaromLegrovidebbFuvar()) {
            System.out.println(fuvar + "\n");
        }
        System.out.println(String.format("tizedik feladat:"+fuvars.getHanyFuvar("12-24")));
        System.out.println(String.format("tizenegyedik feladat:"+fuvars.getHanyFuvar("12-31")));

    }
}
