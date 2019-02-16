package com.padc.book_flight;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);


        final EditText etDepature = findViewById(R.id.tiet_depature);
        etDepature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);
                // date picker dialog
                DatePickerDialog picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                etDepature.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();

                // to hide keyboard
                InputMethodManager imm = (InputMethodManager)MainActivity.this.getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(etDepature.getWindowToken(), 0);

            }
        });


        final EditText etArrival = findViewById(R.id.tiet_arrival);
        etArrival.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);
                // date picker dialog
                DatePickerDialog picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                etArrival.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();

                // to hide keyboard
                InputMethodManager imm = (InputMethodManager)MainActivity.this.getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(etArrival.getWindowToken(), 0);

            }
        });






        final Button btnOneway = findViewById(R.id.btn_oneway);
        final Button btnRoundTrip = findViewById(R.id.btn_roundtrip);
        final TextInputLayout tilDepature = findViewById(R.id.til_depature);
        final TextInputLayout tilArrival = findViewById(R.id.til_arrival);





        btnRoundTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRoundTrip.setBackground(getDrawable(R.drawable.round_trip_btn));
                btnRoundTrip.setTextColor(getResources().getColor(R.color.white));

                btnOneway.setBackgroundColor(getResources().getColor(R.color.colorTransparent));
                btnOneway.setTextColor(getResources().getColor(R.color.colorInactive));


                LinearLayout.LayoutParams paramDepature = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT,1);
                tilDepature.setLayoutParams(paramDepature);

                LinearLayout.LayoutParams paramArrival = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT,1);
                tilArrival.setLayoutParams(paramArrival);
                tilArrival.setVisibility(View.VISIBLE);


            }
        });


        btnOneway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRoundTrip.setBackgroundColor(getResources().getColor(R.color.colorTransparent));
                btnOneway.setBackground(getDrawable(R.drawable.round_trip_btn));

                btnOneway.setTextColor(getResources().getColor(R.color.white));
                btnRoundTrip.setTextColor(getResources().getColor(R.color.colorInactive));

                LinearLayout.LayoutParams paramDepature = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT,2);
                tilDepature.setLayoutParams(paramDepature);

                LinearLayout.LayoutParams paramArrival = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT,0);
                tilArrival.setLayoutParams(paramArrival);

                tilArrival.setVisibility(View.GONE);


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
}
