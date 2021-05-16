package com.ahuja.dev.example.saidtester;

import androidx.appcompat.app.AppCompatActivity;
import java.text.DateFormatSymbols;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etID;
    Button btnSubmit;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);
        tvResults.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idNumber = etID.getText().toString().trim();
                String birth = idNumber.substring(0,6);
                String year = birth.substring(0,2);
                String month = birth.substring(2,4);
                String day = birth.substring(4,6);
                int iYear = Integer.parseInt(year);
                int iMonth = Integer.parseInt(month);
                if(iYear > 21){
                    year = "19" + year;
                }
                else{
                    year = "20"+ year;
                }
                String monthString = new DateFormatSymbols().getMonths()[iMonth-1];

                int gen = Integer.parseInt(Character.toString(idNumber.charAt(6)));
                String gender;
                if(gen < 5){
                    gender = "Female";
                }
                else{
                    gender= "Male";
                }
                int residency = Integer.parseInt(Character.toString(idNumber.charAt(10)));
                String status;
                if(residency==0){
                    status = "Citizen of South Africa";
                }
                else{
                    status = "Permanent Resident";
                }
                String resultsF = getString(R.string.birthDate) + " " + day + " " + monthString + " " +
                        year + getString(R.string.newLine) + getString(R.string.MaleFemale) + " "+ gender + getString(R.string.newLine) +
                        getString(R.string.Natio) + " "+ status;
                String results = getString(R.string.birthDate) + " "+ birth + getString(R.string.newLine) +
                        getString(R.string.MaleFemale) + " "+ gender + getString(R.string.newLine) +
                        getString(R.string.Natio) + " "+ status;
                tvResults.setText(resultsF);
                tvResults.setVisibility(View.VISIBLE);
            }
        });

    }
}