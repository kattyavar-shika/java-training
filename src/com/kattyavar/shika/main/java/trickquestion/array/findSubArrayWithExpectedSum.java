package com.kattyavar.shika.main.java.trickquestion.array;

public class findSubArrayWithExpectedSum {
  public static int[] findSubArrayWithSum(int[] arr, int expectedSum) {
    int arrLenght = arr.length;
    int left = 0, right = 0, currentSum = 0;

    while (right < arrLenght) {
      //Add current element to current sum.
      currentSum += arr[right];
      //Then we need to check if current sum > expected
      while (currentSum > expectedSum && left <= right) {
        //subtract left idem from current sum.
        currentSum -= arr[left];
        left++;
      }
      //Now check current sum is equal to expected one.
      if (currentSum == expectedSum) {
        //Return 1 base index
        return new int[]{left + 1, right + 1};
      }
      right++;
    }
    return new int[]{-1};
  }

  public static void main(String[] args) {
    //lets test it..
    int[] arr = {7, 2, 1};
    int expectedSum = 2;
    var result = findSubArrayWithSum(arr, expectedSum);
    //System.out.println(findSubArrayWithSum(arr, expectedSum));
    for (var item : result) {
      System.out.println(item);
    }
  }
}

