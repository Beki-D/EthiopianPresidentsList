package com.example.ethpresidentlist;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApp extends Application {//enables creation of globally accessible class

    private static List<President> presidentList = new ArrayList<President>();//static because list doesn't have to change among instances
    private static int nextID = 9;

    public MyApp() {
        fillPresidentList();
    }

    private void fillPresidentList() {
        President p0 = new President(0, "Lieutenant general Aman Mikael Andom", 1974, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/Aman_andom.png/135px-Aman_andom.png");
        President p1 = new President(1, "Brigadier general Tafari Benti", 1974, "https://upload.wikimedia.org/wikipedia/commons/0/0d/Tafari_Benti_%28cropped%29.gif");
        President p2 = new President(2, "Mengistu Haile Mariam", 1987, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c7/Mengistu_Haile_Mariam_3.jpg/135px-Mengistu_Haile_Mariam_3.jpg");
        President p3 = new President(3, "Tesfaye Gebre Kidan", 1991, "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ea/Tesfaye_Gebre_Kidan.jpg/135px-Tesfaye_Gebre_Kidan.jpg");
        President p4 = new President(4, "Meles Zenawi", 1991, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bd/Meles_Zenawi_-_World_Economic_Forum_Annual_Meeting_2012.jpg/135px-Meles_Zenawi_-_World_Economic_Forum_Annual_Meeting_2012.jpg");
        President p5 = new President(5, "Negasso Gidada", 1995, "https://upload.wikimedia.org/wikipedia/en/c/cd/Negasso_Gidada.jpeg");
        President p6 = new President(6, "Girma Wolde-Giorgis", 2001, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Girma_Wolde-Giorgis_%283589637123%29.jpg/135px-Girma_Wolde-Giorgis_%283589637123%29.jpg");
        President p7 = new President(7, "Mulatu Teshome", 2013, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Mulatu_Teshome_in_Warsaw_-_2018_%2840792938585%29_%28cropped%29.jpg/135px-Mulatu_Teshome_in_Warsaw_-_2018_%2840792938585%29_%28cropped%29.jpg");
        President p8 = new President(8, "Sahle-Work Zewde", 2018, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Sahle-Work_Zewde_portrait.jpg/135px-Sahle-Work_Zewde_portrait.jpg");

        presidentList.addAll(Arrays.asList(new President[]{ p0, p1, p2, p3, p4, p5, p6, p7, p8}));
    }

    public static List<President> getPresidentList() {
        return presidentList;
    }

    public static void setPresidentList(List<President> presidentList) {
        MyApp.presidentList = presidentList;
    }

    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        MyApp.nextID = nextID;
    }
}
