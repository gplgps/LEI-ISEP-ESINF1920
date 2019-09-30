package esinf.generics;

import java.util.*;

public class KSubLists {

    public static Map<Integer, LinkedList<Integer>> kSubLists(LinkedList<Integer> list, ArrayList<Integer> centers){
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (Integer c : centers){
            map.put(c, new LinkedList<>());
        }

        for (Integer n : list){
            Integer distance = null, closestCenter = null;
            for (Integer c : map.keySet()){
                if (distance == null || Math.abs(c - n) < distance){
                    distance =  Math.abs(c - n);
                    closestCenter = c;
                }
            }
            map.get(closestCenter).add(n);
        }

        return map;
    }

}
