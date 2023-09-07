package com.example.tutor_hiring_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tutor_hiring_app.database.TutorAppBaseHelper;

import java.util.ArrayList;

public class UpdateTutorInfo extends AppCompatActivity {

    EditText tutorFirstName_Edit_Text;
    EditText tutorLastName_Edit_Text;
    EditText tutorCivicNumber_Edit_Text;
    EditText tutorStreetName_Edit_Text;
    EditText tutorAppNumber_Edit_Text;
    EditText tutorCityName_Edit_Text;
    EditText tutorProvinceName_Edit_Text;
    EditText tutorPostalCode_Edit_Text;
    EditText tutorCountryName_Edit_Text;
    EditText tutorTelNumber_Edit_Text;
    EditText tutorSubjName_Edit_Text;
    EditText tutorHourFees_Edit_Text;
    EditText tutorExperience_Edit_Text;
    Button updateTutorInfoNextTutor_Button;
    Button updateTutorInfoUpdate_Button;

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

    private int current_index = 0;

   private ArrayList<Tutor> tutorModalArrayList;
   private Context context;
   private TutorAppBaseHelper tutorAppBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_tutor_info);

        context = UpdateTutorInfo.this.getApplicationContext();
        tutorAppBaseHelper = new TutorAppBaseHelper(context);
        tutorModalArrayList = tutorAppBaseHelper.readTutors();

        f_name = tutorModalArrayList.get(current_index).getF_name();
        l_name = tutorModalArrayList.get(current_index).getL_name();
        civic_number = tutorModalArrayList.get(current_index).getCivic_number();
        street_name = tutorModalArrayList.get(current_index).getStreet_name();
        app_number = tutorModalArrayList.get(current_index).getApp_number();
        city_name = tutorModalArrayList.get(current_index).getCity_name();
        province_name = tutorModalArrayList.get(current_index).getProvince_name();
        postal_code = tutorModalArrayList.get(current_index).getPostal_code();
        country_name = tutorModalArrayList.get(current_index).getCountry_name();
        tel_number = tutorModalArrayList.get(current_index).getTel_number();
        subj_name = tutorModalArrayList.get(current_index).getSubj_name();
        hour_fees = tutorModalArrayList.get(current_index).getHour_fees();
        experience = tutorModalArrayList.get(current_index).getExperience();

        //get the view of tutorFirstName_Edit_Text
        tutorFirstName_Edit_Text = (EditText) findViewById(R.id.tutor_first_name_edit_text);
        tutorFirstName_Edit_Text.setText(f_name);

        //get the view of tutorLastName_Edit_Text
        tutorLastName_Edit_Text = (EditText) findViewById(R.id.tutor_last_name_edit_text);
        tutorLastName_Edit_Text.setText(l_name);

        //get the view of tutorCivicNumber_Edit_Text
        tutorCivicNumber_Edit_Text = (EditText) findViewById(R.id.tutor_civic_number_edit_text);
        tutorCivicNumber_Edit_Text.setText(civic_number);

        //get the view of tutorStreetName_Edit_Text
        tutorStreetName_Edit_Text = (EditText) findViewById(R.id.tutor_street_name_edit_text);
        tutorStreetName_Edit_Text.setText(street_name);

        //get the view of tutorAppNumber_Edit_Text
        tutorAppNumber_Edit_Text = (EditText) findViewById(R.id.tutor_app_number_edit_text);
        tutorAppNumber_Edit_Text.setText(app_number);

        //get the view of tutorCityName_Edit_Text
        tutorCityName_Edit_Text = (EditText) findViewById(R.id.tutor_city_name_edit_text);
        tutorCityName_Edit_Text.setText(city_name);

        //get the view of tutorProvinceName_Edit_Text
        tutorProvinceName_Edit_Text = (EditText) findViewById(R.id.tutor_province_name_edit_text);
        tutorProvinceName_Edit_Text.setText(province_name);

        //get the view of tutorPostalCode_Edit_Text
        tutorPostalCode_Edit_Text = (EditText) findViewById(R.id.tutor_postal_code_edit_text);
        tutorPostalCode_Edit_Text.setText(postal_code);

        //get the view of tutorCountryName_Edit_Text
        tutorCountryName_Edit_Text = (EditText) findViewById(R.id.tutor_country_name_edit_text);
        tutorCountryName_Edit_Text.setText(country_name);

        //get the view of tutorTelNumber_Edit_Text
        tutorTelNumber_Edit_Text = (EditText) findViewById(R.id.tutor_tel_number_edit_text);
        tutorTelNumber_Edit_Text.setText(tel_number+"");

        //get the view of tutorSubjName_Edit_Text
        tutorSubjName_Edit_Text = (EditText) findViewById(R.id.tutor_subj_name_edit_text);
        tutorSubjName_Edit_Text.setText(subj_name);

        //get the view of tutorHourFees_Edit_Text
        tutorHourFees_Edit_Text = (EditText) findViewById(R.id.tutor_hour_fees_edit_text);
        tutorHourFees_Edit_Text.setText(hour_fees+"");

        //get the view of tutorExperience_Edit_Text
        tutorExperience_Edit_Text = (EditText) findViewById(R.id.tutor_experience_edit_text);
        tutorExperience_Edit_Text.setText(experience+"");

        //get the view of updateTutorInfoNextTutor_Button
        updateTutorInfoNextTutor_Button = (Button) findViewById(R.id.update_tutor_info_nextTutor_button);
        updateTutorInfoNextTutor_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = UpdateTutorInfo.this.getApplicationContext();
                tutorAppBaseHelper = new TutorAppBaseHelper(context);
                tutorModalArrayList = tutorAppBaseHelper.readTutors();

                current_index = (current_index + 1) % tutorModalArrayList.size();

                f_name = tutorModalArrayList.get(current_index).getF_name();
                l_name = tutorModalArrayList.get(current_index).getL_name();
                civic_number = tutorModalArrayList.get(current_index).getCivic_number();
                street_name = tutorModalArrayList.get(current_index).getStreet_name();
                app_number = tutorModalArrayList.get(current_index).getApp_number();
                city_name = tutorModalArrayList.get(current_index).getCity_name();
                province_name = tutorModalArrayList.get(current_index).getProvince_name();
                postal_code = tutorModalArrayList.get(current_index).getPostal_code();
                country_name = tutorModalArrayList.get(current_index).getCountry_name();
                tel_number = tutorModalArrayList.get(current_index).getTel_number();
                subj_name = tutorModalArrayList.get(current_index).getSubj_name();
                hour_fees = tutorModalArrayList.get(current_index).getHour_fees();
                experience = tutorModalArrayList.get(current_index).getExperience();

                tutorFirstName_Edit_Text.setText(f_name);
                tutorLastName_Edit_Text.setText(l_name);
                tutorCivicNumber_Edit_Text.setText(civic_number);
                tutorStreetName_Edit_Text.setText(street_name);
                tutorAppNumber_Edit_Text.setText(app_number);
                tutorCityName_Edit_Text.setText(city_name);
                tutorProvinceName_Edit_Text.setText(province_name);
                tutorPostalCode_Edit_Text.setText(postal_code);
                tutorCountryName_Edit_Text.setText(country_name);
                tutorTelNumber_Edit_Text.setText(tel_number+"");
                tutorSubjName_Edit_Text.setText(subj_name);
                tutorHourFees_Edit_Text.setText(hour_fees+"");
                tutorExperience_Edit_Text.setText(experience+"");
            }
        });

        //get the view of updateTutorInfoUpdate_Button
        updateTutorInfoUpdate_Button = (Button) findViewById(R.id.update_tutor_info_update_button);
        updateTutorInfoUpdate_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                f_name = tutorFirstName_Edit_Text.getText().toString();
                l_name = tutorLastName_Edit_Text.getText().toString();
                civic_number = tutorCivicNumber_Edit_Text.getText().toString();
                street_name = tutorStreetName_Edit_Text.getText().toString();
                app_number = tutorAppNumber_Edit_Text.getText().toString();
                city_name = tutorCityName_Edit_Text.getText().toString();
                province_name = tutorProvinceName_Edit_Text.getText().toString();
                postal_code = tutorPostalCode_Edit_Text.getText().toString();
                country_name = tutorCountryName_Edit_Text.getText().toString();
                tel_number = Long.parseLong(tutorTelNumber_Edit_Text.getText().toString());
                subj_name = tutorSubjName_Edit_Text.getText().toString();
                hour_fees = Double.parseDouble(tutorHourFees_Edit_Text.getText().toString());
                experience = Integer.parseInt(tutorExperience_Edit_Text.getText().toString());

                Tutor tutor = new Tutor(f_name,l_name,civic_number,street_name,app_number,city_name,province_name,postal_code,country_name,
                        tel_number,subj_name,hour_fees,experience);

                context = UpdateTutorInfo.this.getApplicationContext();
                tutorAppBaseHelper = new TutorAppBaseHelper(context);
                tutorAppBaseHelper.updateTutor(tutor);

                Toast.makeText(UpdateTutorInfo.this, "Tutor: "+f_name+" "+l_name+" has been updated successfully", Toast.LENGTH_LONG).show();
            }
        });

    }
}