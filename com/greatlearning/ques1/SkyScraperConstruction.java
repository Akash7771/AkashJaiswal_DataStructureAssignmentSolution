package com.greatlearning.ques1;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SkyScraperConstruction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n  = null;
        String separator = " ";
        Queue<Integer> floorSizeQueue = new ConcurrentLinkedQueue<>();
        LinkedList<Integer> sortedFloorSize = new LinkedList<>();

        try {
            System.out.println("enter the total no of floors in the building");
            n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.println("enter the floor size given on day : " + (i + 1) );
                Integer sizeOfFloor = sc.nextInt();
                floorSizeQueue.add(sizeOfFloor);
                sortedFloorSize.add(sizeOfFloor);
                sortedFloorSize.sort(Comparator.reverseOrder());
            }
        }catch (InputMismatchException e){
            System.err.println("invalid input integer expected");
        }

        Integer day = 0;

        LinkedList<Integer> inventoryOfFloors = new LinkedList<>();
        Integer firstFloor = sortedFloorSize.getFirst();
        boolean isFirstFloorPrinted = false;
        Integer printedFloor = -1;

        System.out.println("The order of construction is as follows");
        for(Integer floorSize : sortedFloorSize) {
            day++;
            inventoryOfFloors.add(floorSizeQueue.remove());
            inventoryOfFloors.sort(Comparator.reverseOrder());
            System.out.println("Day: " + day +"" );
            List<Integer> delete = new ArrayList<>();
            for(Integer inventoryFloorSize : inventoryOfFloors){
                if(inventoryFloorSize.compareTo(floorSize) >=0  ){
                    if( (!isFirstFloorPrinted && firstFloor == inventoryFloorSize ) || ( isFirstFloorPrinted && (printedFloor==-1 || printedFloor-1 == inventoryFloorSize) ) ) {
                        System.out.print(inventoryFloorSize + separator);
                        delete.add(inventoryFloorSize);
                        printedFloor = inventoryFloorSize;
                        isFirstFloorPrinted=true;
                    }
                }
            }
            for(Integer toDelete : delete){
                inventoryOfFloors.remove(toDelete);
            }
            /*
            commenting this logic as can't construct a floor if its not constructed.
                //print all floor as all floors are constructed
                if(floorSizeQueue.isEmpty()){
                    for(Integer finised : inventoryOfFloors)
                        System.out.print( finised+ separator);
                }
            */
            System.out.println();
        }
    }
}
