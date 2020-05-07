//Shane-Rhys Chua S10194712

package sg.edu.WhackAMole;

import android.app.Activity;

import android.view.View;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import sg.edu.WhackAMole.R;


import java.util.Random;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - Feel free to modify the function to suit your program.
    */

    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(TAG, "Finished Pre-Initialisation!");
    }

    @Override
    protected void onStart(){
        super.onStart();
        TextView score = (TextView)findViewById(R.id.score);
        setNewMole();
        score.setText("0");
        gameStart();
        Log.v(TAG, "Starting GUI!");
    }


    public void setNewMole()
    {
        Button left = (Button)findViewById(R.id.left);
        left.setText("O");
        Button middle = (Button)findViewById(R.id.middle);
        middle.setText("O");
        Button right = (Button)findViewById(R.id.right);
        right.setText("O");
        TextView score = (TextView)findViewById(R.id.score);

        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        if (randomLocation == 0){
            left.setText("*");
        }
        else if(randomLocation == 1){
            middle.setText("*");
        }
        else{
            right.setText("*");
        }

    }



    public void gameStart()
    {
        final Button left = (Button)findViewById(R.id.left);
        final Button middle = (Button)findViewById(R.id.middle);
        final Button right = (Button)findViewById(R.id.right);
        final TextView score = (TextView)findViewById(R.id.score);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "gameStart:button pressed");
                if(left.getText() == "*"){
                    Log.v(TAG, "gameStart: left correct");
                    count += 1;
                }
                else{
                    Log.v(TAG, "gameStart: left wrong");
                    count -= 1;
                }
                score.setText(Integer.toString(count));
                setNewMole();


            }
        });



        middle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "gameStart:middle button pressed");
                if(middle.getText() == "*"){
                    Log.v(TAG, "gameStart:middle correct");
                    count += 1;
                }
                else{
                    Log.v(TAG, "gameStart:middle wrong");
                    count -= 1;
                }
                score.setText(Integer.toString(count));
                setNewMole();
            }
        });


        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "gameStart:right pressed");
                if(right.getText() == "*"){
                    Log.v(TAG, "gameStart: right correct");
                    count += 1;
                }
                else{
                    Log.v(TAG, "gameStart:right wrong");
                    count -= 1;
                }
                score.setText(Integer.toString(count));
                setNewMole();
            }
        });

    }



}

