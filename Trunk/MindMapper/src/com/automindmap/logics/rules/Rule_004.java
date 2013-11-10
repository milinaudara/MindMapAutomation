package com.automindmap.logics.rules;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.automindmap.dbconnetion.DBConnection;
import com.automindmap.logics.ChankedObject;
import com.automindmap.logics.IGrammerRule;

public class Rule_004 implements IGrammerRule {

	@Override
	public boolean IsMatch(ChankedObject chankedObject) {
		// TODO Auto-generated method stub
		return (chankedObject.passerTree.equals("NP")||chankedObject.passerTree.equals("VP"));
	}

	@Override
	public void runRule(ChankedObject chankedObject) {
	
		 try {
           
             String intPutValue =chankedObject.clearedChankedPhrases.get(0);

             ResultSet fx = DBConnection.getDConnection().select("SELECT id,value,parent_id FROM node WHERE id NOT IN (SELECT parent_id FROM node WHERE parent_id > 0 and map_id="+chankedObject.mapId+")");
             HashMap proIdMap = new HashMap();
              while (fx.next()) {

                  int id = fx.getInt(1);
                  String lastName = fx.getString(2);
                  int parentId = fx.getInt(3);

                   while(parentId > 0){
                      ResultSet parentRes = DBConnection.getDConnection().select("SELECT id,value,parent_id  FROM node WHERE id = " + parentId);
                      while (parentRes.next()) {

                         //get the parent date
                         int tempId = parentRes.getInt(1);
                         String  tempParentName = parentRes.getString(2);
                         parentId = parentRes.getInt(3);

                            //read the nlp data
                          // System.out.println("Out Put ::-->"+ tempParentName+" "+lastName +" "+ intPutValue);
                               ResultSet nlpRes = DBConnection.getDConnection().select("SELECT MAX(`Probability`) FROM trigram WHERE First = '" +tempParentName+ "' AND Second = '"+lastName+"' AND Thred = '"+intPutValue+"'");
                               if (nlpRes.next()) {
                                 proIdMap.put(id, nlpRes.getDouble(1));
                               }

                    id = tempId;
                    lastName = tempParentName;
                 }
                 }
            }

        Map<Integer,Double > sorted = sortByValues(proIdMap);
        List<Integer> list = new ArrayList<Integer>(sorted.keySet());
        int maxProbablityId = list.get(list.size()-1);

        DBConnection.getDConnection().insert("INSERT INTO node (map_id,value, parent_id) VALUES ('" + chankedObject.mapId + "', " + "'" + intPutValue + "', " + maxProbablityId + ")");
               }
        catch (Exception ex) {
            ex.printStackTrace();
        }

	}
	 public static <K extends Comparable,V extends Comparable> Map<K,V> sortByValues(Map<K,V> map){
	     List<Map.Entry<K,V>> entries = new LinkedList<Map.Entry<K,V>>(map.entrySet());

	        Collections.sort(entries, new Comparator<Map.Entry<K,V>>() {

	            public int compare(Entry<K, V> o1, Entry<K, V> o2) {
	                return o1.getValue().compareTo(o2.getValue());
	            }
	        });

	        Map<K,V> sortedMap = new LinkedHashMap<K,V>();

	        for(Map.Entry<K,V> entry: entries){
	            sortedMap.put(entry.getKey(), entry.getValue());
	        }

	        return sortedMap;
	    }
}
