package com.example.marspioneer.model;

import com.raylabz.opensimplex.NoiseDetail;
import com.raylabz.opensimplex.OpenSimplexNoise;
import com.raylabz.opensimplex.RangedValue;

import java.util.ArrayList;

public class Test2 {

    public static void main(String[] args) {

        

        OpenSimplexNoise noise = new OpenSimplexNoise();

        noise = new OpenSimplexNoise(1234);
        noise.setNoiseDetail(NoiseDetail.EIGHTH);
        noise.setFeatureSize(20);
        noise.setPower(1);

        int LOW_LIMIT = 0;
        int HIGH_LIMIT = 1000;

        ArrayList<RangedValue> singleValues = new ArrayList<>();

        for (int run = 0; run < 6; run++) {

            long t1 = System.currentTimeMillis();
            for (int i = LOW_LIMIT; i < HIGH_LIMIT; i++) {
                for (int j = LOW_LIMIT; j < HIGH_LIMIT; j++) {
                    RangedValue v = noise.getNoise2D(j, i);
//                    singleValues.add(v);
                }
            }
            long f1 = System.currentTimeMillis();

            long t = System.currentTimeMillis();
            RangedValue[][] v = noise.getNoise2DArray(LOW_LIMIT, LOW_LIMIT, HIGH_LIMIT, HIGH_LIMIT);
            long f = System.currentTimeMillis();

            if (v == null) {
                System.err.println("ERROR IN ARRAY GEN");
            }

//            System.out.println("Singles:");
//            for (RangedValue v1 : singleValues) {
//                printRangedValue(v1);
//            }
//            System.out.println();
//
//            System.out.println("Array vals:");
//            System.out.println("v.length = " + v.length);
//            for (RangedValue[] r1 : v) {
//                for (RangedValue r2 : r1) {
//                    printRangedValue(r2);
//                }
//            }
//            System.out.println();

            if (run > 0) System.out.println("Single cell: " + (f1 - t1));
            if (run > 0) System.out.println("Array: " + (f - t));

        }


    }

    static void printRangedValue(RangedValue v) {
        double value = v.getValue();
        System.out.print(value + " ");
    }

}
