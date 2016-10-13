package com.digitalinterruption.research.read_hci_log;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readFile();
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

    private void readFile()
    {
        BufferedReader br = null;
        TextView textView = (TextView) findViewById(R.id.textView);
        try {
            String fpath = "/sdcard/btsnoop_hci.log";
            try {
                br = new BufferedReader(new FileReader(fpath));
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            String line = "";
            while ((line = br.readLine()) != null) {
                //Do something here
                textView.append(line);
            }
        }
        catch(java.io.IOException ex)
        {
            ex.printStackTrace();
        }

    }
}
