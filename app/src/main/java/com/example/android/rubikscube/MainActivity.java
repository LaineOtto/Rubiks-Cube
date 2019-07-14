package com.example.android.rubikscube;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Arrays which have cube starting positions
    Integer[] whiteArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    Integer[] blueArr = {10, 11, 12, 13, 14, 15, 16, 17, 18};
    Integer[] orangeArr = {19, 20, 21, 22, 23, 24, 25, 26, 27};
    Integer[] greenArr = {28, 29, 30, 31, 32, 33, 34, 35, 36};
    Integer[] redArr = {37, 38, 39, 40, 41, 42, 43, 44, 45};
    Integer[] yellowArr = {46, 47, 48, 49, 50, 51, 52, 53, 54}; //TODO: Garbage Collection on these barely used arrays

    //Turn the arrays into lists, which are actually useful
    List<Integer> whiteList = new ArrayList<>(Arrays.asList(whiteArr));
    List<Integer> blueList = new ArrayList<>(Arrays.asList(blueArr));
    List<Integer> orangeList = new ArrayList<>(Arrays.asList(orangeArr));
    List<Integer> greenList = new ArrayList<>(Arrays.asList(greenArr));
    List<Integer> redList = new ArrayList<>(Arrays.asList(redArr));
    List<Integer> yellowList = new ArrayList<>(Arrays.asList(yellowArr));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        up(); //TODO: Make a button for this or something
    }

    public void up() {
        //Sublists are to facilitate rotation
        List tempList1 = whiteList.subList(0, 3);
        List tempList2 = whiteList.subList(3, 6);
        List tempList3 = whiteList.subList(6, 9); //TODO: Garbage Collection mebbe
        List<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            //Rotate
            arrList.add((int)tempList3.get(i));
            arrList.add((int)tempList2.get(i));
            arrList.add((int)tempList1.get(i));
        }
        //Overwrites the array
        whiteArr = arrList.toArray(whiteArr);
//        Log.e("up: ", Array.get(whiteArr, 0).toString());

        //Displays rotation
        for (int i = 0; i < 9; i++) {
            int j = i + 1;
            String posString = "pos" + j;
            int id = getResources().getIdentifier(posString, "id", getPackageName());
            final TextView textView = findViewById(id);
            textView.setText(Array.get(whiteArr, i).toString());
        }

        //TODO: Rotate peripheral, not just the face
    }
}
