package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eike on 16.04.2015.
 */
public class DataStruct {

    //Struktur[Altersgruppe/Merkmal][Buch][Anzahl]
    private HashMap<String,HashMap<String,Integer>> dataTemp =null;

    private int id;
    private String name;
    private int amount;

    public DataStruct(int id){
        dataTemp= new HashMap<String,HashMap<String,Integer>>();
        this.id=id;
    }


    public void assignData(ArrayList<String[]> sList){
        dataTemp = new HashMap<String,HashMap<String,Integer>>();
        int count=0;
        for(String[] s : sList){
            count++;
            if(count==1){
                this.name=s[id];
                continue;
            }
            if(dataTemp.containsKey(s[id])){
               if(dataTemp.get(s[id]).containsKey(s[7])){
                    dataTemp.get(s[id]).put(s[7], dataTemp.get(s[id]).get(s[7]).intValue() + 1);

                }else{
                    dataTemp.get(s[id]).put(s[7], Integer.valueOf(1));
                }
            }else{
                HashMap<String,Integer> map = new HashMap<String,Integer>();
                map.put(s[7], Integer.valueOf(1));
                dataTemp.put(s[id],map);
            }

        }

        this.amount=count-1;

    }

    public void printData(){
        System.out.println(this.name);
        for(Map.Entry<String,HashMap<String,Integer>> entry: dataTemp.entrySet()){
            System.out.println(entry.getKey());
            for(Map.Entry<String,Integer> item: entry.getValue().entrySet()){
                System.out.println("\t" + item.getKey() + "\t" + item.getValue());
            }
        }
    }


    public String getName() {
        return name;
    }


    public int getAmount() {
        return amount;
    }


    public HashMap<String, HashMap<String, Integer>> getDataTemp() {
        return dataTemp;
    }
}
