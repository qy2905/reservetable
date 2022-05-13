package sg.edu.rp.c346.id21027604.reservetable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView name;
    EditText nameInput;
    TextView phoneNum;
    EditText numInput;
    TextView noPax;
    EditText paxInput;
    DatePicker reserveDp;
    TimePicker reserveTp;
    RadioGroup tableReserve;
    Button submitBtn;
    Button resetBtn;
    TextView thankYou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        nameInput = findViewById(R.id.nameInput);
        phoneNum = findViewById(R.id.phoneNum);
        numInput = findViewById(R.id.phoneNumInput);
        noPax = findViewById(R.id.grpSize);
        paxInput = findViewById(R.id.paxInput);
        reserveDp = findViewById(R.id.datePicker);
        reserveTp = findViewById(R.id.timePicker);
        tableReserve = findViewById(R.id.tableReserve);
        submitBtn = findViewById(R.id.submit);
        resetBtn = findViewById(R.id.reset);
        thankYou = findViewById(R.id.thankyou);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tableCheck = tableReserve.getCheckedRadioButtonId();
                reserveTp.setIs24HourView();
                int day = reserveDp.getDayOfMonth();
                int month = reserveDp.getMonth();
                int year = reserveDp.getYear();
                int hour = reserveTp.getCurrentHour();
                int min = reserveTp.getCurrentMinute();
                String stringName = "Name: " + nameInput.getText().toString();
                String getTime = String.format("Time of Reservation: %d:%d",hour, min);
                String getDate = String.format("Date of Reservation: %d/%d/%d",day, month, year);
                String getNoPax ="Number of people: " + paxInput.getText().toString();
                String getMobileNo = "Mobile Number:" + numInput.getText().toString();
                if (nameInput.getText().length() !=0 && numInput.getText().length() !=0 && paxInput.getText().length() !=0){
                    if(tableCheck == R.id.smoking){
                        Toast.makeText(MainActivity.this,stringName + "\n" + getMobileNo + "\n" + getNoPax + "\n" + getDate + "\n" + getTime + "\n" + "" +
                                "SMOKING TABLE NEEDED", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this,stringName + "\n" + getMobileNo + "\n" + getNoPax + "\n" + getDate + "\n" + getTime + "\n" + "" +
                                "NON-SMOKING TABLE NEEDED", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        resetBtn.setOnClickListener(new View.OnClickListener()){
            @Override
            public void onClick(View view) {
                reserveDp.updateDate(2020,7,1);
                reserveTp.setCurrentHour(19);
                reserveTp.setCurrentMinute(30);
            }
        };
    }
}