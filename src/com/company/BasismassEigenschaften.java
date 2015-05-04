package com.company;

import java.util.ArrayList;

/**
 * Created by holle on 04.05.2015.
 */
public class BasismassEigenschaften {

    private ArrayList<String> eigenschaft;
    private ArrayList<String> menge;
    private float fokaleMenge;

    public BasismassEigenschaften(ArrayList<String> eigenschaft, ArrayList<String> menge, float fokaleMenge) {
        this.eigenschaft = eigenschaft;
        this.menge = menge;
        this.fokaleMenge = fokaleMenge;
    }


    public ArrayList<String> getEigenschaft() {
        return eigenschaft;
    }

    public ArrayList<String> getMenge() {
        return menge;
    }

    public float getFokaleMenge() {
        return fokaleMenge;
    }
}
