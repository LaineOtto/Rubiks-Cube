package com.example.android.rubikscube;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void up(View view) {
        Log.e("upClick", " called");
        rotate("White");
    }

    public void rotate(String face) {
        int faceInt; //TODO Error handling for this
        List<Integer> rotateList;
        switch (face) {
            case "White":
            case "white":
                faceInt = 0;
                rotateList = new ArrayList<>(Arrays.asList(whiteArr));
                break;
            case "Blue":
            case "blue":
                faceInt = 1;
                rotateList = new ArrayList<>(Arrays.asList(blueArr));
                break;
            case "Orange":
            case "orange":
                faceInt = 2;
                rotateList = new ArrayList<>(Arrays.asList(orangeArr));
                break;
            case "Green":
            case "green":
                faceInt = 3;
                rotateList = new ArrayList<>(Arrays.asList(greenArr));
                break;
            case "Red":
            case "red":
                faceInt = 4;
                rotateList = new ArrayList<>(Arrays.asList(redArr));
                break;
            case "Yellow":
            case "yellow":
                faceInt = 5;
                rotateList = new ArrayList<>(Arrays.asList(yellowArr));
                break;
            default:
                faceInt = -1;
                rotateList = new ArrayList<>(); //TODO: Handle these somehow
                break;
        }


        whiteArr = faceRotateCw(faceInt, rotateList).toArray(whiteArr);

        //TODO: Rotation animation

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

    private List<Integer> faceRotateCw(int faceInt, List<Integer> rotateList) {
        //Sublists are to facilitate rotation
        List tempList1 = rotateList.subList(0, 3);
        List tempList2 = rotateList.subList(3, 6);
        List tempList3 = rotateList.subList(6, 9); //TODO: Garbage Collection mebbe
        List<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            //Rotate
            arrList.add((int) tempList3.get(i));
            arrList.add((int) tempList2.get(i));
            arrList.add((int) tempList1.get(i));
        }
        return arrList;
    }
}
