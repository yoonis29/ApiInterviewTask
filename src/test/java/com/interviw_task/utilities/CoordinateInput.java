package com.interviw_task.utilities;

import java.util.Arrays;

public class CoordinateInput {
    //        int[] roomSize = {5,5};
//        int[] coords = {1, 2};
//        int[][]patches = {{1, 0}, {2, 2}, {2, 3}};
//        String instructions = "NNESEESWNWWSE";
//        System.out.println(result(roomSize,coords,patches,instructions));
//        created a method based of Jason body request above
    public static String result(int[] roomSize, int[] coords, int[][] patches, String instructions) {
        int patchesCount = 0;
        for (int i = 0; i < instructions.length(); i++) { // created a loop in order go through each character of the instructions
            //switch Statement is providing coordinate input depending on instructions provided in requirements. If it is 'N' or 'S' it will represent Y axis, and if it is 'E' or 'W', it will represent X axis.
            switch (instructions.charAt(i)) {
                case 'N':
                    if (coords[1] < roomSize[1]) {
                        coords[1] += 1;
                        break; // we break in order to stop the switch statement from continuing to the rest of the cases. Therefore, statement can go to the next character of the instructions.
                    } else {
                        //We are checking if the roomba stays within our room size based on the increase or decrease of the coordinates, which will result the roomba to hit a wall and skid in place.
                        return "we reached edge of room";
                    }
                case 'S':
                    if (coords[1] > 0) {
                        coords[1] -= 1;
                        break;
                    } else {
                        return "we reached edge of room";
                    }
                case 'E':
                    if (coords[0] < roomSize[0]) {
                        coords[0] += 1;
                        break;
                    } else {
                        return "we reached edge of room";
                    }
                case 'W':
                    if (coords[0] > 0) {
                        coords[0] -= 1;
                        break;
                    } else {
                        return "we reached edge of room";
                    }
            }

            for (int j = 0; j < patches.length; j++) {
                if (Arrays.equals(coords, patches[j])) {
                    patchesCount++;
                    patches[j][0] = -1;
                    patches[j][1] = -1;
                }
            }
        }
        return "{\"coords\":[" + coords[0] + "," + coords[1] + "],\"patches\":" + patchesCount + "}"; // we return our final coords plus how many patches its has cleaned
    }

}
