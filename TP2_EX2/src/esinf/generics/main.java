package esinf.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public class main {

    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList();
        ArrayList<Integer> centers = new ArrayList<>();

        list.add(2);
        list.add(9);
        list.add(7);
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(6);
        list.add(12);
        list.add(3);

        centers.add(3);
        centers.add(6);
        centers.add(10);

        Map<Integer, LinkedList<Integer>> map = KSubLists.kSubLists(list, centers);

        System.out.println(map);
    }
}
