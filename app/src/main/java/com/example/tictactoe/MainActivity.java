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
        // mark with the current turn symbol
        if (clickedButton != null && ( clickedButton.getText().equals("") )){
            buttonPlayed(clickedButton);
            // check for a win or a tie, if no win is detected then swap players
            if ( WinDetected(buttons)){
                playerTurn.setText("Player " + currentTurn + " has won");
                DisableButtons(buttons);
            }
            else if (TieDetected(buttons)) {
                playerTurn.setText("It's a tie!");
                DisableButtons(buttons);
            }
            else {
                swapPlayers();
            }
        }

    }

    // buttonClicked method
    // returns the button that was clicked (returns null if no button clicked)
    private Button buttonClicked(View v, Button[] buttons){
        for ( Button button : buttons ){
            if ( v == button ){
                return button;
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

        // enable the buttons
        EnableButtons(buttons);

        // reset turn
        if(currentTurn == playerO){
            swapPlayers();
        }

        // reset player text
        ResetText();

    }

    // the board has 9 buttons and a player needs three marks in a row, a column, or diagonally

    // returns true if a win is detected for the current player
    private boolean WinDetected (Button[] buttons){
        //diagonal win
       // all boxes 1, 5, and 9 OR boxes 7, 5, and 3 need to be marked with the same symbol
       if ( TopLeftBtn.getText().equals(currentTurn) && // box 1
            MiddleCenterBtn.getText().equals(currentTurn) && // box 5
            BottomRightBtn.getText().equals(currentTurn)){ // box 9
           return true;
       }
       if ( BottomLeftBtn.getText().equals(currentTurn) && //box 7
            MiddleCenterBtn.getText().equals(currentTurn) && // box 5
            TopRightBtn.getText().equals(currentTurn)){ // box 3
           return true;
       }

       // row win
        // top row is boxes 1, 2, 3
        if ( TopLeftBtn.getText().equals(currentTurn) &&
             TopCenterBtn.getText().equals(currentTurn) &&
             TopRightBtn.getText().equals(currentTurn) ){
            return true;
        }
        // middle row is boxes 4, 5, 6
        else if ( MiddleLeftBtn.getText().equals(currentTurn) &&
                  MiddleCenterBtn.getText().equals(currentTurn) &&
                  MiddleRightBtn.getText().equals(currentTurn)){
            return true;
        }
        // bottom row is boxes 7, 8, 0
        else if ( BottomLeftBtn.getText().equals(currentTurn) &&
                  BottomCenterBtn.getText().equals(currentTurn) &&
                  BottomRightBtn.getText().equals(currentTurn)){
            return true;
        }

        // column win
        //left col is boxes 1, 4, 7
        if ( TopLeftBtn.getText().equals(currentTurn) &&
             MiddleLeftBtn.getText().equals(currentTurn) &&
             BottomLeftBtn.getText().equals(currentTurn)){
            return true;
        }
        //center col is boxes 2, 5, 8
        else if ( TopCenterBtn.getText().equals(currentTurn) &&
                  MiddleCenterBtn.getText().equals(currentTurn) &&
                  BottomCenterBtn.getText().equals(currentTurn)){
            return true;
        }
        //right col is boxes 3, 6, 9
        else if ( TopRightBtn.getText().equals(currentTurn) &&
                  MiddleRightBtn.getText().equals(currentTurn) &&
                  BottomRightBtn.getText().equals(currentTurn)){
            return true;
        }

        // no win detected
        return false;
    }


    // return true if a tie is detected (no more boxes to play)
    private boolean TieDetected (Button[] buttons){
        // a tie is when all boxes are filled and neither players got three boxes in a row
        for (Button b: buttons){
            if (b.getText()==""){
                return false;
            }
        }
        return true;
    }

    // no buttons can be played until a new game is started
    private void DisableButtons (Button[] buttons){
        for (Button b: buttons){
            b.setClickable(false);
        }
    }

    // buttons can be played
    private void EnableButtons(Button[] buttons){
        for( Button b: buttons){
            b.setClickable(true);
        }
    }

    private void ResetText (){
        playerTurn.setText("Player " + currentTurn + "'s Turn");
    }
}

