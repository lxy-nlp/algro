package Algor;

import java.util.Scanner;

public class Base01 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String str = input.next();
        System.out.println(str);
        String[] nums = str.split(" ");
        for(int i=0;i<nums.length;i++){
            if(nums[0]==nums[1]&&nums[1]==nums[2]){
                System.out.println("equal");
            }
            else{
                System.out.println("not");
            }
        }
    }
}
