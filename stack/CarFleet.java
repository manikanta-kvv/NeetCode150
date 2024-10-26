package stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class CarFleet {

    /* car fleet means if the time taken by current car lesser than or equal to the time taken by previous car,
     * then it indicates there's a one car fleet
     * timeTakenByCar to reach destination = (target - position)/speed
     * push the current car(position, time) to the stack if we don't find a car fleet
     * if we find a car fleet, then continue with the next car
     * each car itself can be a car fleet
     * so, the no of cars in the stack = no of car fleets
     */
    public static int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        //2d-array to store both positions and speed for each car at one place
        int[][] combinedCarData = new int[position.length][2];
        for(int i = 0; i < position.length; i++) {
            //storing car's position at 0th index
            combinedCarData[i][0] = position[i];
            //storing car's speed at 1st index
            combinedCarData[i][1] = speed[i];
        }

        //sort the array to track the cars from right side to left side
        Arrays.sort(combinedCarData, Comparator.comparingInt(a -> a[0]));
        for(int i = combinedCarData.length - 1; i >= 0; i--) {
            double currentCarTime = (double) (target - combinedCarData[i][0]) / combinedCarData[i][1];
            //if the stack is not empty, then check for its top element of the stack whether it can be a car fleet
            //top element of stack = previous car (from back side)
            if(!stack.isEmpty() && currentCarTime <= stack.peek()) {
                continue;
            }
            else{
                //if we don't find car fleet, then push the current car time to the stack to check car fleet further on remaining cars
                stack.push(currentCarTime);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        int target = 10;
        int[] position = {3};
        int[] speed = {3};
        int result = carFleet(target, position, speed);
        System.out.println(result);
    }
}
