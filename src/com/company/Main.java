package com.company;

public class Main {

    public static void main(String[] args) {
        Fuvars fuvars = new Fuvars("fuvar.csv");
        System.out.println("első feladat: "+fuvars.getfuvarCount());
        System.out.println("masodik feladat, ennyi fuvarja volt a 6185-ös taxisnak: "+fuvars.gethanyFuvar(6185) + " Bevétele: " + fuvars.getEgyediBevetel(6185));
    }
}
