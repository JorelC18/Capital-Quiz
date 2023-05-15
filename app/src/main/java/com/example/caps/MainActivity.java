package com.example.caps;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;



public class MainActivity extends AppCompatActivity {

    private Game game;
    private String question;
    private String answer;
    private int score;
    private int qNum;
    private String[] lines; //to separate Question & Answer from game.qa()
    private String log;
    private String log2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.game = new Game();
        this.question = "";
        this.answer = "";
        this.score = 0;
        this.qNum = 1;
        this.log = "";
        this.log2 = "";
        ask();
    }

    private void ask() {
        TextView questionText = findViewById(R.id.question);
        question = game.qa();
        lines = question.split("\n");
        questionText.setText(lines[0]);
    }

    public void onDone(View v) {
        TextView scoreText = findViewById(R.id.score);
        TextView qNumText = findViewById(R.id.qNum);
        EditText answerText = findViewById(R.id.answer);
        TextView logText = findViewById(R.id.log);
        Button doneButton = findViewById(R.id.done);

        lines = question.split("\n"); //separates Question & Answer
        String input = answerText.getText().toString();
        answer = lines[1];

        log += "Q# " + qNum + ": " + lines[0];
        log += "\n";
        log += "Your answer: " + input.toUpperCase();
        log += "\n";
        log += "Correct answer: " + lines[1];
        log += "\n";
        log += "\n";
        log2 = log + log2;
        logText.setText(log2);
        log = "";

        if (qNum < 9) {
            if (input.equalsIgnoreCase(answer)) {
                score++;
                scoreText.setText("SCORE = " + score);
            }
            qNum++;
            qNumText.setText("Q# " + qNum);
            ask();
        } else {
            if (input.equalsIgnoreCase(answer)) { //case for when SCORE = 8, to get SCORE = 9 for max score
                score++;
                scoreText.setText("SCORE = " + score);
            }
            qNumText.setText("Game Over!");
            doneButton.setEnabled(false);
        }

        if (qNum == 10) {
            finish();
        }


    }

}

