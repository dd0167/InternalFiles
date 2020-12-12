package com.example.internalfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * The type Main activity.
 *
 * @author Dean David <dd0167@bs.amalnet.k12.il>
 * @version 1.0
 * @since 12/12/2020
 */
public class MainActivity extends AppCompatActivity {

    EditText et;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et=(EditText) findViewById(R.id.et);
        tv=(TextView) findViewById(R.id.tv);

        try {
            FileInputStream fis= openFileInput("text.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            String stringread = sb.toString();
            tv.setText(stringread);
            isr.close();
        }
        catch (Exception e) {
        }
    }

    /**
     * Save - save and add the typed text to previously typed text
     * @param view the view
     */
    public void save(View view) {
        String s=et.getText().toString();
        String stringread2="";
        try {
            FileInputStream fis= openFileInput("text.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            stringread2 = sb.toString();
            tv.setText(stringread2);
            isr.close();
        }
        catch (Exception e) {
        }
        try {
            FileOutputStream fos = openFileOutput("text.txt",MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(stringread2+s);
            bw.close();
            FileInputStream fis= openFileInput("text.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            String stringread = sb.toString();
            tv.setText(stringread);
            isr.close();
        }
        catch (Exception e) {
        }
        et.setText("");
    }

    /**
     * Reset - Delete the history of all text typing
     * @param view the view
     */
    public void reset(View view) {
        try {
            FileOutputStream fos = openFileOutput("text.txt",MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write("");
            bw.close();
            FileInputStream fis= openFileInput("text.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            String stringread = sb.toString();
            tv.setText(stringread);
            isr.close();
        }
        catch (Exception e) {
        }
        et.setText("");
    }

    /**
     * Exit - Saves the data and closes the program.
     * @param view the view
     */
    public void exit(View view) {
        String s=et.getText().toString();
        String stringread2="";
        try {
            FileInputStream fis= openFileInput("text.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            stringread2 = sb.toString();
            tv.setText(stringread2);
            isr.close();
        }
        catch (Exception e) {
        }
        try {
            FileOutputStream fos = openFileOutput("text.txt",MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(stringread2+s);
            bw.close();
            FileInputStream fis= openFileInput("text.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            String stringread = sb.toString();
            tv.setText(stringread);
            isr.close();
        }
        catch (Exception e) {
        }
        System.exit(0);
    }

    /**
     * Create Options menu
     * @param menu the menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        menu.add("Credits");
        return true;
    }

    /**
     * Click in Options menu
     * @param item the item
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String st=item.getTitle().toString();
        if (st.equals("Credits"))
        {
            Intent in=new Intent(this,CreditsActivity.class);
            startActivity(in);
        }
        return true;
    }
}