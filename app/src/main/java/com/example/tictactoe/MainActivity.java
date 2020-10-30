package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // X and O
    private final String playerX = "X";
    private final String playerO = "O";

    // game turns
    private String currentTurn;
    private TextView playerTurn;

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

    // new game button
    private Button NewGameBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assigning the game buttons
        TopLeftBtn = findViewById(R.id.TopLeftBtn);
        TopCenterBtn = findViewById(R.id.TopCenterBtn);
        TopRightBtn = findViewById(R.id.TopRightBtn);
        MiddleLeftBtn = findViewById(R.id.MiddleLeftBtn);
        MiddleCenterBtn = findViewById(R.id.MiddleCenterBtn);
        MiddleRightBtn = findViewById(R.id.MiddleRightBtn);
        BottomLeftBtn = findViewById(R.id.BottomLeftBtn);
        BottomCenterBtn = findViewById(R.id.BottomCenterBtn);
        BottomRightBtn = findViewById(R.id.BottomRightBtn);

        // assigning the new game button
        NewGameBtn = findViewById(R.id.NewGameBtn);

        // assigning the currentTurn to playerX
        currentTurn = playerX;

        // assigning the playerTurn and setting the text
        playerTurn = findViewById(R.id.PlayerTurnTxt);
        playerTurn.setText("Player " + currentTurn + "'s Turn");
    }
    // onClick method
    public void onClick(View view)
    {
        // game buttons
        Button[] buttons = {TopLeftBtn, TopCenterBtn, TopRightBtn,
                MiddleLeftBtn, MiddleCenterBtn, MiddleRightBtn,
                BottomLeftBtn, BottomCenterBtn, BottomRightBtn};
        // when a button is clicked
        Button clickedButton = buttonClicked(view, buttons);
        // if the button was clicked and the text is blank
        // mark with an X or O and swap players
        if (clickedButton != null && clickedButton.getText().equals("")){
            buttonPlayed(clickedButton);
            swapPlayers();
        }
    }

    // buttonClicked method
    // returns the button that was clicked (returns null if no button clicked)
    private Button buttonClicked(View v, Button[] buttons){
        for (int i = 0; i < buttons.length; i++){
            if ( v == buttons[i]){
                return buttons[i];
            }
        }
        return null;
    }

    // buttonPlayed method
    // marks either an X or O on a button that was clicked
    private void buttonPlayed(Button button){
        button.setText(currentTurn);
    }

    // swapPlayers method
    // swaps the currentTurn and the playerTurn text
    private void swapPlayers(){
        if ( currentTurn == playerX ){
            currentTurn = playerO;
        }
        else{
            currentTurn = playerX;
        }
        playerTurn.setText("Player " + currentTurn + "'s Turn");
    }

// when the new game button is clicked
    public void newGame(View view) {
        Button[] buttons = {TopLeftBtn, TopCenterBtn, TopRightBtn,
                MiddleLeftBtn, MiddleCenterBtn, MiddleRightBtn,
                BottomLeftBtn, BottomCenterBtn, BottomRightBtn};
        // for each loop that clears text off game buttons
        for(Button b :buttons){
            b.setText("");
        }
        // reset turn
        if(currentTurn == playerO){
            swapPlayers();
        }
    }
}

