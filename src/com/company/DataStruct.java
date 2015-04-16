package com.company;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eike on 16.04.2015.
 */
public class DataStruct {

    //Struktur[Altersgruppe/Merkmal][Buch][Anzahl]
    private HashMap<String,HashMap<String,Integer>> data=null;

    private int id;
    private String name;

    public DataStruct(int id){
        data= new HashMap<String,HashMap<String,Integer>>();
        this.id=id;
    }


    public void assignData(ArrayList<String[]> sList){
        int count=0;
        for(String[] s : sList){
            count++;
            if(count==1){
                this.name=s[id];
                continue;
            }
            if(data.containsKey(s[id])){
               if(data.get(s[id]).containsKey(s[7])){
                    data.get(s[id]).put(s[7], data.get(s[id]).get(s[7]).intValue() + 1);

                }else{
                    data.get(s[id]).put(s[7], Integer.valueOf(1));
                }
            }else{
                HashMap<String,Integer> map = new HashMap<String,Integer>();
                map.put(s[7], Integer.valueOf(1));
                data.put(s[id],map);
            }
        }
    }

    public void printData(){
        System.out.println(this.name);
        for(Map.Entry<String,HashMap<String,Integer>> entry: data.entrySet()){
            System.out.println(entry.getKey());
            for(Map.Entry<String,Integer> item: entry.getValue().entrySet()){
                System.out.println("\t" + item.getKey() + "\t" + item.getValue());
            }
        }
    }


}
