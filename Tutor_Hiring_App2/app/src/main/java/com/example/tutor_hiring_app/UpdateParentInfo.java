package com.example.tutor_hiring_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tutor_hiring_app.database.TutorAppBaseHelper;

import java.util.ArrayList;

public class UpdateParentInfo extends AppCompatActivity {
    EditText parentFirstName_Edit_Text;
    EditText parentLastName_Edit_Text;
    EditText parentCivicNumber_Edit_Text;
    EditText parentStreetName_Edit_Text;
    EditText parentAppNumber_Edit_Text;
    EditText parentCityName_Edit_Text;
    EditText parentProvinceName_Edit_Text;
    EditText parentPostalCode_Edit_Text;
    EditText parentCountryName_Edit_Text;
    EditText parentTelNumber_Edit_Text;
    Button updateParentInfoUpdate_Button;
    Button updateParentInfoNextParent_Button;

    int current_index = 0;

    ArrayList<Parent> parentModalArrayList;
    Context context;
    TutorAppBaseHelper tutorAppBaseHelper;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_parent_info);

        context = UpdateParentInfo.this.getApplicationContext();
        tutorAppBaseHelper = new TutorAppBaseHelper(context);
        parentModalArrayList = tutorAppBaseHelper.readParents();

        f_name = parentModalArrayList.get(current_index).getF_name();
        l_name = parentModalArrayList.get(current_index).getL_name();
        civic_number = parentModalArrayList.get(current_index).getCivic_number();
        street_name = parentModalArrayList.get(current_index).getStreet_name();
        app_number = parentModalArrayList.get(current_index).getApp_number();
        city_name = parentModalArrayList.get(current_index).getCity_name();
        province_name = parentModalArrayList.get(current_index).getProvince_name();
        postal_code = parentModalArrayList.get(current_index).getPostal_code();
        country_name = parentModalArrayList.get(current_index).getCountry_name();
        tel_number = parentModalArrayList.get(current_index).getTel_number();

        //get the view of parentFirstName_Edit_Text
        parentFirstName_Edit_Text = (EditText) findViewById(R.id.parent_first_name_edit_text);
        parentFirstName_Edit_Text.setText(f_name);

        //get the view of parentLastName_Edit_Text
        parentLastName_Edit_Text = (EditText) findViewById(R.id.parent_last_name_edit_text);
        parentLastName_Edit_Text.setText(l_name);

        //get the view of parentCivicNumber_Edit_Text
        parentCivicNumber_Edit_Text = (EditText) findViewById(R.id.parent_civic_number_edit_text);
        parentCivicNumber_Edit_Text.setText(civic_number);

        //get the view of parentStreetName_Edit_Text
        parentStreetName_Edit_Text = (EditText) findViewById(R.id.parent_street_name_edit_text);
        parentStreetName_Edit_Text.setText(street_name);

        //get the view of parentAppNumber_Edit_Text
        parentAppNumber_Edit_Text = (EditText) findViewById(R.id.parent_app_number_edit_text);
        parentAppNumber_Edit_Text.setText(app_number);

        //get the view of parentCityName_Edit_Text
        parentCityName_Edit_Text = (EditText) findViewById(R.id.parent_city_name_edit_text);
        parentCityName_Edit_Text.setText(city_name);

        //get the view of parentProvinceName_Edit_Text
        parentProvinceName_Edit_Text = (EditText) findViewById(R.id.parent_province_name_edit_text);
        parentProvinceName_Edit_Text.setText(province_name);

        //get the view of parentPostalCode_Edit_Text
        parentPostalCode_Edit_Text = (EditText) findViewById(R.id.parent_postal_code_edit_text);
        parentPostalCode_Edit_Text.setText(postal_code);

        //get the view of parentCountryName_Edit_Text
        parentCountryName_Edit_Text = (EditText) findViewById(R.id.parent_country_name_edit_text);
        parentCountryName_Edit_Text.setText(country_name);

        //get the view of parentTelNumber_Edit_Text
        parentTelNumber_Edit_Text = (EditText) findViewById(R.id.parent_tel_number_edit_text);
        parentTelNumber_Edit_Text.setText(tel_number+"");

        //get the view of updateParentInfoNextParent_Button
        updateParentInfoNextParent_Button = (Button) findViewById(R.id.update_parent_info_nextparent_button);
        updateParentInfoNextParent_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                context = UpdateParentInfo.this.getApplicationContext();
                tutorAppBaseHelper = new TutorAppBaseHelper(context);
                parentModalArrayList = tutorAppBaseHelper.readParents();

                current_index = (current_index + 1) % parentModalArrayList.size();

                f_name = parentModalArrayList.get(current_index).getF_name();
                l_name = parentModalArrayList.get(current_index).getL_name();
                civic_number = parentModalArrayList.get(current_index).getCivic_number();
                street_name = parentModalArrayList.get(current_index).getStreet_name();
                app_number = parentModalArrayList.get(current_index).getApp_number();
                city_name = parentModalArrayList.get(current_index).getCity_name();
                province_name = parentModalArrayList.get(current_index).getProvince_name();
                postal_code = parentModalArrayList.get(current_index).getPostal_code();
                country_name = parentModalArrayList.get(current_index).getCountry_name();
                tel_number = parentModalArrayList.get(current_index).getTel_number();

                parentFirstName_Edit_Text.setText(f_name);
                parentLastName_Edit_Text.setText(l_name);
                parentCivicNumber_Edit_Text.setText(civic_number);
                parentStreetName_Edit_Text.setText(street_name);
                parentAppNumber_Edit_Text.setText(app_number);
                parentCityName_Edit_Text.setText(city_name);
                parentProvinceName_Edit_Text.setText(province_name);
                parentPostalCode_Edit_Text.setText(postal_code);
                parentCountryName_Edit_Text.setText(country_name);
                parentTelNumber_Edit_Text.setText(tel_number+"");

            }
        });

        //get the view of updateParentInfoUpdate_Button
        updateParentInfoUpdate_Button = (Button) findViewById(R.id.update_parent_info_update_button);
        updateParentInfoUpdate_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                f_name = parentFirstName_Edit_Text.getText().toString();
                l_name = parentLastName_Edit_Text.getText().toString();
                civic_number = parentCivicNumber_Edit_Text.getText().toString();
                street_name = parentStreetName_Edit_Text.getText().toString();
                app_number = parentAppNumber_Edit_Text.getText().toString();
                city_name = parentCityName_Edit_Text.getText().toString();
                province_name = parentProvinceName_Edit_Text.getText().toString();
                postal_code = parentPostalCode_Edit_Text.getText().toString();
                country_name = parentCountryName_Edit_Text.getText().toString();
                tel_number = Long.parseLong(parentTelNumber_Edit_Text.getText().toString());

                Parent parent = new Parent(f_name,l_name,civic_number,street_name,app_number,city_name,province_name,postal_code,country_name,tel_number);

                context = UpdateParentInfo.this.getApplicationContext();
                tutorAppBaseHelper = new TutorAppBaseHelper(context);
                tutorAppBaseHelper.updateParent(parent);

                Toast.makeText(UpdateParentInfo.this, "Parent: "+f_name+" "+l_name+" has been updated successfully", Toast.LENGTH_LONG).show();
            }
        });

    }
}