package sg.edu.rp.c346.id22004686.l04reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText number;
    EditText size;
    DatePicker dates;
    TimePicker time;
    RadioGroup smoke;
    Button confirm;
    Button reset;
    TextView finals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameEdit);
        number = findViewById(R.id.numberEdit);
        size = findViewById(R.id.sizeEdit);
        dates = findViewById(R.id.datePicker);
        time = findViewById(R.id.timePicker);
        smoke = findViewById(R.id.smoke);
        confirm = findViewById(R.id.confirm);
        reset = findViewById(R.id.reset);
        finals = findViewById(R.id.totalz);

        time.setCurrentHour(19);
        time.setCurrentMinute(30);
        dates.updateDate(2020,6,1);


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (name.getText().toString().trim().isEmpty() || number.getText().toString().trim().isEmpty() || size.getText().toString().trim().isEmpty()){
                    Toast.makeText(MainActivity.this, "Error: Fill up Form", Toast.LENGTH_SHORT).show();
                } else {
                    int hour = time.getCurrentHour();
                    int minute = time.getCurrentMinute();
                    int date = dates.getDayOfMonth();
                    int month = dates.getMonth();
                    int year = dates.getYear();
                    String ok = "";


                    int smokezs = smoke.getCheckedRadioButtonId();
                    String smoking = "";
                    if (smokezs == R.id.smokes){
                        smoking = "Smoking";
                    } else if (smokezs == R.id.nonsmokes){
                        smoking = "Non-Smoking";
                    }

                    if (minute < 10){
                        ok = String.format("%d:0%d",hour,minute);
                    } else{
                        ok = hour+":"+minute;
                    }

                    if (year <2020){
                        Toast.makeText(MainActivity.this, "Error: How do you go back in time?", Toast.LENGTH_SHORT).show();
                    }else{
                        if (time.getCurrentHour() >= 8 && time.getCurrentHour() < 21) {
                            finals.setText("Name: " + name.getText().toString() + "\nMobile Number: " + number.getText().toString() + "\nSize of the Group: " + size.getText().toString() + "\nDate: " +
                                    date + "/" + month + "/" + year + "\nTime: " + ok + "\nTable Type: " + smoking);

                            Toast.makeText(MainActivity.this, "Name: " + name.getText().toString() + "\nMobile Number: " + number.getText().toString() + "\nSize of the Group: " + size.getText().toString() + "\nDate: " +
                                    date + "/" + month + "/" + year + "\nTime: " + ok + "\nTable Type: " + smoking, Toast.LENGTH_SHORT).show();

                            Toast.makeText(MainActivity.this, "Confirmed", Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(MainActivity.this, "Error: Shop closed bruh", Toast.LENGTH_SHORT).show();
                        }
                    }


                }

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                time.setCurrentHour(19);
                time.setCurrentMinute(30);
                dates.updateDate(2020,6,1);
                smoke.check(R.id.smokes);
                name.setText("");
                number.setText("");
                size.setText("");
                finals.setText("");
            }});


    }
}