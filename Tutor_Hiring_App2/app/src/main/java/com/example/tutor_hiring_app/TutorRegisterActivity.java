package com.example.tutor_hiring_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tutor_hiring_app.database.TutorAppBaseHelper;

import java.util.ArrayList;

public class TutorRegisterActivity extends AppCompatActivity {
    //fields
    private String f_name;
    private String l_name;
    private String civic_number;
    private String street_name;
    private String app_number;
    private String city_name;
    private String province_name;
    private String postal_code;
    private String country_name;
    private long tel_number;
    private String subj_name;
    private double hour_fees;
    private int experience;

    EditText tutorFirstNameEdit_Text;
    EditText tutorLastNameEdit_Text;
    EditText tutorCivicNumberEdit_Text;
    EditText tutorStreetNameEdit_Text;
    EditText tutorAppNumberEdit_Text;
    EditText tutorCityNameEdit_Text;
    EditText tutorProvinceNameEdit_Text;
    EditText tutorPostalCodeEdit_Text;
    EditText tutorCountryNameEdit_Text;
    EditText tutorTelNumberEdit_Text;
    EditText tutorSubjNameEdit_Text;
    EditText tutorHourFeesEdit_Text;
    EditText tutorExperienceEdit_Text;
    Button tutorActivityRegister_Button;

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_register);

        //get the view of tutorActivityRegister_Button
        tutorActivityRegister_Button = (Button) findViewById(R.id.tutor_activity_register_button);
        tutorActivityRegister_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    //get the view of tutorFirstNameEdit_Text
                    tutorFirstNameEdit_Text = (EditText) findViewById(R.id.tutor_first_name_edit_text);
                    f_name = tutorFirstNameEdit_Text.getText().toString();

                    //get the view of tutorLastNameEdit_Text
                    tutorLastNameEdit_Text = (EditText) findViewById(R.id.tutor_last_name_edit_text);
                    l_name = tutorLastNameEdit_Text.getText().toString();

                    //get the view of tutorCivicNumberEdit_Text
                    tutorCivicNumberEdit_Text = (EditText) findViewById(R.id.tutor_civic_number_edit_text);
                    civic_number = tutorCivicNumberEdit_Text.getText().toString();

                    //get the view of tutorStreetNameEdit_Text
                    tutorStreetNameEdit_Text = (EditText) findViewById(R.id.tutor_street_name_edit_text);
                    street_name = tutorStreetNameEdit_Text.getText().toString();

                    //get the view of tutorAppNumberEdit_Text
                    tutorAppNumberEdit_Text = (EditText) findViewById(R.id.tutor_app_number_edit_text);
                    app_number = tutorAppNumberEdit_Text.getText().toString();

                    //get the view of tutorCityNameEdit_Text
                    tutorCityNameEdit_Text = (EditText) findViewById(R.id.tutor_city_name_edit_text);
                    city_name = tutorCityNameEdit_Text.getText().toString();

                    //get the view of tutorProvinceNameEdit_Text
                    tutorProvinceNameEdit_Text = (EditText) findViewById(R.id.tutor_province_name_edit_text);
                    province_name = tutorProvinceNameEdit_Text.getText().toString();

                    //get the view of tutorPostalCodeEdit_Text
                    tutorPostalCodeEdit_Text = (EditText) findViewById(R.id.tutor_postal_code_edit_text);
                    postal_code = tutorPostalCodeEdit_Text.getText().toString();

                    //get the view of tutorCountryNameEdit_Text
                    tutorCountryNameEdit_Text = (EditText) findViewById(R.id.tutor_country_name_edit_text);
                    country_name = tutorCountryNameEdit_Text.getText().toString();

                    //get the view of tutorTelNumberEdit_Text
                    tutorTelNumberEdit_Text = (EditText) findViewById(R.id.tutor_tel_number_edit_text);
                    tel_number = Long.parseLong(tutorTelNumberEdit_Text.getText().toString());

                    //get the view of tutorSubjNameEdit_Text
                    tutorSubjNameEdit_Text = (EditText) findViewById(R.id.tutor_subj_name_edit_text);
                    subj_name = tutorSubjNameEdit_Text.getText().toString();

                    //get the view of tutorHourFeesEdit_Text
                    tutorHourFeesEdit_Text = (EditText) findViewById(R.id.tutor_hour_fees_edit_text);
                    hour_fees = Double.parseDouble(tutorHourFeesEdit_Text.getText().toString());

                    //get the view of tutorExperienceEdit_Text
                    tutorExperienceEdit_Text = (EditText) findViewById(R.id.tutor_experience_edit_text);
                    experience = Integer.parseInt(tutorExperienceEdit_Text.getText().toString());

                    //creating an object with registered info.
                    Tutor tutor2 = new Tutor(f_name, l_name, civic_number, street_name, app_number,
                            city_name, province_name, postal_code, country_name, tel_number, subj_name, hour_fees, experience);

                    //adding a Tutor record to database TutorAppBase.db
                    context = TutorRegisterActivity.this.getApplicationContext();
                    TutorAppBaseHelper tutorAppBaseHelper = new TutorAppBaseHelper(context);
                    tutorAppBaseHelper.addNewTutor(tutor2);

                    //display register message using Toast class
                    Toast.makeText(TutorRegisterActivity.this, "Tutor: " + f_name + " " + l_name + ", Subject: " + subj_name +
                            "\n has been registered successfully.", Toast.LENGTH_LONG).show();

                    //forwarding to the next page ManageTutorActivity using Intent Class
                    Intent manageTutorActivityIntent = new Intent(TutorRegisterActivity.this, ManageTutorActivity.class);
                    startActivity(manageTutorActivityIntent);
                }
                catch (Exception ex){
                    Toast.makeText(TutorRegisterActivity.this, "Please enter the Information", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}