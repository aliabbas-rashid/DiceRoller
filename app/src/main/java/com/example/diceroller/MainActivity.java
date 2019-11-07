package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public int count;


    public void on_button_click(View view) {
        try {
            roll_the_dice();
        } catch (Exception e)
        {
            Toast.makeText(MainActivity.this, "Error, enter a number between 1 and 6", Toast.LENGTH_SHORT).show();
        }

    }

    public void dice_breakers(View view) {
        try{
            String[] Questions = new String[6];
            Questions[0] = "If you could go anywhere in the world, where would you go?";
            Questions[1] = "If you were stranded on a desert island, what three things would you want to take with you?";
            Questions[2] = "If you could eat only one food for the rest of your life, what would that be?";
            Questions[3] = "If you won a million dollars, what is the first thing you would buy?";
            Questions[4] = "If you could spend the day with one fictional character, who would it be?";
            Questions[5] = "If you found a magic lantern and a genie gave you three wishes, what would you wish?";

            TextView tv3 = this.findViewById(R.id.textView3);
            Random r = new Random();
            int number = r.nextInt(5);
            String out = Questions[number];
            tv3.setText(out);
        }catch (Exception e)
        {
            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
        }

    }

    public void roll_the_dice()
    {
        EditText editText = (EditText) findViewById(R.id.textIn);
        String numinput = (editText.getText().toString());
        int numinputint = Integer.parseInt(numinput);

        if ((numinputint > 6) || (numinputint < 1))
        {
            throw new IllegalArgumentException("Must be between 1 and 6");
        }

        TextView tv = this.findViewById(R.id.textView);
        tv.setText("The button was pressed");

        TextView tv2 = this.findViewById(R.id.textView2);

        Random r = new Random();
        int number = r.nextInt((6-1) + 1)+1;

        tv.setText(Integer.toString(number));

        compare(numinputint, number, tv2);
    }

    public void compare(int a, int b, TextView c)
    {
        if (a == b)
        {
            Toast.makeText(MainActivity.this, "Congratulations", Toast.LENGTH_SHORT).show();
            score(c);

        }
        else
        {
            Toast.makeText(MainActivity.this, "Try again", Toast.LENGTH_SHORT).show();
        }
    }

    public void score(TextView a)
    {
        count += 1;
        a.setText("Score: " + count);
    }
}