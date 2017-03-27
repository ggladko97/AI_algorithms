package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ggladko97 on 27.03.17.
 */
public class GTS {

    HashMap<Integer,Fruit> dataSetInput = new HashMap<>();
    String [] attributes;
    ArrayList<HashMap<String,String>> dataSet = new ArrayList<>();
    HashMap<HashMap<String,String>,Integer> positive = new HashMap<>();
    HashMap<HashMap<String,String>,Integer> negative = new HashMap<>();
    HashMap<HashMap<String,String>,Double> accuracy = new HashMap<>();
    HashMap<HashMap<String,String>,Double> generality = new HashMap<>();
    HashMap<HashMap<String,String>,Double> H = new HashMap<>();
/*
* HashMap<String,String> entry = new HM<>();
* for(EntrySet<HashMap<String,String>,Integer> set : positive){
* int pos = set.getValue();
* int neg=0;
* for(EntrySet<HashMap<String,String>,Integer> set : negative){
*
* accuracy(i) = positive.entrySet.getKey()
*
*
*
*
*
*
* */

//trying to insert values of accuracy generality and H to their datasets respectively
    public void countAccuracy(HashMap<HashMap<String,String>,Integer> positive,
                              HashMap<HashMap<String,String>,Integer> negative) {
        for (Map.Entry<HashMap<String,String>,Integer> entry1 : positive.entrySet()) {
            HashMap<String,String> key = entry1.getKey();
            int positiveCount = entry1.getValue();
            int negativeCount = negative.get(key);//check whether equal to 0

            /*
            * Ogólność (ang. Generality) G = (Ep+Eb)/E
              Dokładność (ang. Accuracy) A = Ep/(Ep+Eb)
              Parametr H równy H = G+sqrt(A)
            */
            double accuracyCount = positiveCount/(positiveCount+negativeCount);
            double generalityCount = (positiveCount+negativeCount)/dataSet.get(0).size();
            double h = generalityCount + Math.sqrt(accuracyCount);
            accuracy.put(entry1.getKey(),accuracyCount);
            generality.put(entry1.getKey(),generalityCount);
            H.put(entry1.getKey(),h);

            if (accuracyCount == 1) {
                System.out.println(entry1.getKey());
            } else {
                double max = 0;
                HashMap<HashMap<String,String>,Double> keyValuePair = new HashMap<>();
                for(Map.Entry<HashMap<String,String>,Double> entry : H.entrySet()) {
                    if(entry.getValue() >= max) {
                        max = entry.getValue();
                        if(keyValuePair.isEmpty()) {
                            keyValuePair.put(entry.getKey(),max);
                        } else {
                            double finalMax = max;
                            keyValuePair.replaceAll((k, v) -> finalMax);
                        }

                    }
                }

                for(Map.Entry<HashMap<String,String>,Integer> entry : positive.entrySet()) {

                }

            }

        }
    }


    public HashMap<Integer, Fruit> getDataSet() {
        return dataSetInput;
    }

    public void setDataSet(HashMap<Integer, Fruit> dataSet) {
        this.dataSetInput = dataSet;
    }

    public void setAttributes(String [] attributes) {
        this.attributes = attributes;
    }

    public void algorithmGTS() {

        //iteration over all attributes (last is the result)
        for (int i = 0; i < dataSet.size(); i++) {
            //temporary values for each iteration
            String value = dataSet.get(i).get(attributes[i]);
            String result = dataSet.get(dataSet.size()-1).get(attributes[attributes.length-1]);

            if (!value.equals("")) {



                for(Map.Entry<String,String> entry : dataSet.get(i).entrySet()) {

                    int positiveCount = 0;
                    int negativeCount = 0;

                    HashMap<String,String> attributeValuePair = new HashMap<>();
                    attributeValuePair.put(entry.getKey(),value);

                    if(entry.getValue().equals(value)) {
                        for(Map.Entry<String,String> resultEntry : dataSet.get(dataSet.size()-1).entrySet()) {
                            if (resultEntry.getValue().equals(result)) {
                                positiveCount++;
                                putPositive(positiveCount, attributeValuePair);

                            } else {
                                negativeCount++;
                                putNegative(negativeCount, attributeValuePair);
                            }
                        }
                    } else {

                        putPositive(positiveCount, attributeValuePair);

                    }
                }


            }

        }
    }

    private void putNegative(int negativeCount, HashMap<String, String> attributeValuePair) {
        if (negative.isEmpty()) {

            negative.put(attributeValuePair,negativeCount);

        } else if (negative.containsKey(attributeValuePair)) {

            negative.replace(attributeValuePair,negativeCount);
        }
    }

    private void putPositive(int positiveCount, HashMap<String, String> attributeValuePair) {
        if (positive.isEmpty()) {

            positive.put(attributeValuePair,positiveCount);

        } else if (positive.containsKey(attributeValuePair)) {

            positive.replace(attributeValuePair,positiveCount);
        }
    }


}
