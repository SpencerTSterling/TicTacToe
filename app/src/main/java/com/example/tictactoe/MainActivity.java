package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // game buttons //
    // top row
    private Button TopLeftBtn;
    private Button TopCenterBtn;
    private Button TopRightBtn;
    // middle row
    private Button MiddleLeftBtn;
    private Button MiddleCenterBtn;
    private Button MiddleRightBtn;
    // bottom row
    private Button BottomLeftBtn;
    private Button BottomCenterBtn;
    private Button BottomRightBtn;

    Button[] buttons = {TopLeftBtn, TopCenterBtn, TopRightBtn,
                        MiddleLeftBtn, MiddleCenterBtn, MiddleRightBtn,
                        BottomLeftBtn, BottomCenterBtn, BottomRightBtn};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}