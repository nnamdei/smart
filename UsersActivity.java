package com.kunle.smartair.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.view.View;
import android.widget.DatePicker;
import com.kunle.smartair.Checkout;
import com.kunle.smartair.R;
import com.kunle.smartair.model.BookingCheckOut;

/**
 * Created by kunle on 3/27/17.
 */
public class UsersActivity extends AppCompatActivity {

    private TextView textViewName;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView, dateView1;
    int year, month, day;
    private Spinner spinner_departure, spinner_destination, adult_spinner, children_spinner, infant_spinner;
    private String spinner_departure_selected, spinner_destination_selected,
            adult_spinner_selected, children_spinner_selected, infant_spinner_selected;
    private String[] departure = {"Lagos(LOS)", "Abuja(ABV)", "Owerri(QOW)", "Port Harcourt (PHC)", "Uyo(QUO)"};
    private String[] destination = {"Lagos(LOS)", "Abuja(ABV)", "Owerri(QOW)", "Port Harcourt (PHC)", "Uyo(QUO)"};
    String oneWayRB, returnRB, way = null, onDate, offDate;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private EditText Fullname;
    private EditText phone_number;
    private EditText contact_address;
    private String EditValueName;
    private String EditValueAddress;
    private long EditValuePhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        Fullname = (EditText) findViewById(R.id.FullName);
        contact_address = (EditText) findViewById(R.id.ContactAddress);

        dateView = (TextView) findViewById(R.id.textview3);
        dateView1 = (TextView) findViewById(R.id.textView4);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        showDate(year, month + 1, day);
        showDate1(year, month + 1, day);


        EditValueName = Fullname.getText().toString();//get input value for user full name
        EditValueAddress = contact_address.getText().toString();//get input value for contact address

        spinner_departure = (Spinner) findViewById(R.id.departure);
        ArrayAdapter<String> adapterDeparture = new ArrayAdapter<String>(UsersActivity.this, android.R.layout.simple_spinner_item, departure);
        spinner_departure.setAdapter(adapterDeparture);

        spinner_departure.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                spinner_departure_selected = spinner_departure.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });

        spinner_destination = (Spinner) findViewById(R.id.destination);
        ArrayAdapter<String> adapterDestination = new ArrayAdapter<String>(UsersActivity.this, android.R.layout.simple_spinner_item, destination);
        spinner_destination.setAdapter(adapterDestination);

        spinner_destination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                spinner_destination_selected = spinner_destination.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });


        adult_spinner = (Spinner) findViewById(R.id.adult);
        Integer[] itemsAdult = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayAdapter<Integer> adapterAdult = new ArrayAdapter<Integer>(UsersActivity.this, android.R.layout.simple_spinner_item, itemsAdult);
        adult_spinner.setAdapter(adapterAdult);

        adult_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                adult_spinner_selected = adult_spinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });


        children_spinner = (Spinner) findViewById(R.id.children);
        Integer[] itemsChildren = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayAdapter<Integer> adapterChildren = new ArrayAdapter<Integer>(UsersActivity.this, android.R.layout.simple_spinner_item, itemsChildren);
        children_spinner.setAdapter(adapterChildren);

        children_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                children_spinner_selected = children_spinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });


        infant_spinner = (Spinner) findViewById(R.id.infant);
        Integer[] itemsInfant = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayAdapter<Integer> adapterInfant = new ArrayAdapter<Integer>(UsersActivity.this, android.R.layout.simple_spinner_item, itemsInfant);
        infant_spinner.setAdapter(adapterInfant);

        infant_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                infant_spinner_selected = infant_spinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });




    }


    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
    }

    @SuppressWarnings("deprecation")
    public void setDateReturn(View view) {
        showDialog(999);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2 + 1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
        onDate = String.valueOf(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    private void showDate1(int year, int month, int day) {
        dateView1.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
        offDate = String.valueOf(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }


    public void onRadioButton(View view) {
        boolean checked = ((RadioButton) view).isChecked();


        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.oneWay:
                if (checked)
                    oneWayRB = "One Way";
                way = oneWayRB;
                    break;
            case R.id.retur:
                if (checked)
                    returnRB = "Return";
                way = returnRB;
                    break;
        }
    }


    public void CustomerName{

    }
    public void booking(View view) {
        BookingCheckOut bookingCheckOut = new BookingCheckOut();
        bookingCheckOut.setDeparture(spinner_departure_selected);
        bookingCheckOut.setDestination(spinner_destination_selected);
        bookingCheckOut.setAdult(adult_spinner_selected);
        bookingCheckOut.setChildren(children_spinner_selected);
        bookingCheckOut.setInfant(infant_spinner_selected);
        bookingCheckOut.setOneWayRB(way);
        bookingCheckOut.setOnDate(onDate);
        bookingCheckOut.setOffDate(offDate);
        bookingCheckOut.setEditValueName(EditValueName);
        bookingCheckOut.setEditValueAddress(EditValueAddress);


        Intent intent = new Intent(getApplicationContext(), Checkout.class);
        intent.putExtra(BookingCheckOut.EXTRA, bookingCheckOut);
        startActivity(intent);

    }
}