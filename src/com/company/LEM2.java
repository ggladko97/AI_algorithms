package com.company;

import java.util.*;

//public class LEM2 {

//    public static void main(String[] args) {
//	    HashMap <Integer,Fruit> fruits = ExcelReader.readFromSpreadsheet();
//        System.out.println(fruits);
//        String [] names = {"Apple","Grapefruit","Grape","Lemon","Cherry","Banana"};
//
//        HashMap <String,ArrayList <HashMap <Integer,Fruit>>> map = new HashMap <>();
//        for (String name :names){
//            ArrayList<Fruit>fr = new ArrayList<>();
//            ArrayList<HashMap <Integer,Fruit>>arrayList = new ArrayList<>();
//
//            for (int i = 1; i < fruits.size(); i++) {
//                HashMap<Integer,Fruit> tempHashMap = new HashMap<>();
//                if(name.equals(fruits.get(i).getName())) {
//                    tempHashMap.put(i,fruits.get(i));
//                    arrayList.add(tempHashMap);
//                    map.put(name,arrayList);
//                }
//            }
//        }
//
//        System.out.println("Map : "+map);
//
//        HashMap<String,ArrayList<HashMap<Integer,Fruit>>> result;
//        result = algorithm(map);
//        System.out.println("Result: "+result);
//
//
//        // List <HashMap<Integer,Fruit>> dividedByName = new ArrayList<>();
////        HashMap <HashMap<Integer,Fruit>,String> resultMap = countNames(dividedByName);
//
//
//
//    }

//    public static  HashMap<String,ArrayList<HashMap<Integer,Fruit>>> algorithm (HashMap<String,ArrayList<HashMap<Integer,Fruit>>> input){
//
//        HashMap<String,ArrayList<HashMap<Integer,Fruit>>> P = new HashMap<>();
//
//        for(Map.Entry<String,ArrayList<HashMap<Integer,Fruit>>> value : input.entrySet()){
//
//
//            while (!value.getValue().isEmpty()){
//
//                //HashMap<String,ArrayList<HashMap<Integer,Fruit>>> W = new HashMap<>();
//                ArrayList<HashMap<Integer,Fruit>> W = new ArrayList<>(value.getValue());
//                while (P.isEmpty() || input.values().containsAll((Collection<?>) P)) {
//
//
//
//
//                }
//
//            }
//
//        }
//        return P;
//
//    }

//    private static HashMap <HashMap<Integer,Fruit>,String> countNames(List<HashMap<Integer, Fruit>> dividedByName) {
//        Set <String> listOfNames = new HashSet<>();
//        System.out.println(listOfNames);
//        //List <HashMap<Integer,Fruit>> divededList = new ArrayList<>();
//        HashMap <HashMap<Integer,Fruit>,String> fruitMap = new HashMap<>();
//        List<HashMap<Integer,Fruit>> fruitList = new ArrayList<>();
//
//        for (int i = 1; i < dividedByName.size(); i++) {
//            String fruitName = dividedByName.get(i).get(i).getName();
//            System.out.println("Fruit name : "+fruitName);
//            if (listOfNames.contains(fruitName)) {
//                fruitMap.put(dividedByName.get(i),fruitName);
//            } else {
//
//                listOfNames.add(fruitName);
//                fruitList.add()
//
//            }
//
//        }
//        return fruitMap;
//
//    }


//}
