package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eike on 16.04.2015.
 */
public class DataStruct {

    //Struktur[Altersgruppe/Merkmal][Buch][Anzahl]
    private ArrayList<DataOverview> data;
    private HashMap<String,HashMap<String,Integer>> dataTemp =null;

    private int id;
    private String name;

    public DataStruct(int id){
        data= new ArrayList<DataOverview>();
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

        //Assign Data to list
        for(Map.Entry<String,HashMap<String,Integer>> entry: dataTemp.entrySet()){
            for(Map.Entry<String,Integer> item: entry.getValue().entrySet()){
                data.add(new DataOverview(entry.getKey(), item.getKey(), item.getValue()));
            }
        }
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

    public ArrayList<DataOverview> getData(){
        return data;
    }

    public String getName() {
        return name;
    }


}
