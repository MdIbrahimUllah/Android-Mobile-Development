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

public class ParentRegisterActivity extends AppCompatActivity {
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

    EditText parentFirstNameEdit_Text;
    EditText parentLastNameEdit_Text;
    EditText parentCivicNumberEdit_Text;
    EditText parentStreetNameEdit_Text;
    EditText parentAppNumberEditText;
    EditText parentCityNameEdit_Text;
    EditText parentProvinceNameEdit_Text;
    EditText parentPostalCodeEdit_Text;
    EditText parentCountryNameEdit_Text;
    EditText parentTelNumberEdit_Text;
    Button parentActivityRegister_Button;

    ArrayList<Parent> parentsList = new ArrayList<Parent>();
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_register);


        //get the view of parentActivityRegister_Button
        parentActivityRegister_Button = (Button) findViewById(R.id.parent_activity_register_button);
        parentActivityRegister_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    //get the view of parentFirstNameEdit_Text
                    parentFirstNameEdit_Text = (EditText) findViewById(R.id.parent_first_name_edit_text);
                    f_name = parentFirstNameEdit_Text.getText().toString();

                    //get the view of parentLastNameEdit_Text
                    parentLastNameEdit_Text = (EditText) findViewById(R.id.parent_last_name_edit_text);
                    l_name = parentLastNameEdit_Text.getText().toString();

                    //get the view of parentCivicNumberEdit_Text
                    parentCivicNumberEdit_Text = (EditText) findViewById(R.id.parent_civic_number_edit_text);
                    civic_number = parentCivicNumberEdit_Text.getText().toString();

                    //get the view of parentStreetNameEdit_Text
                    parentStreetNameEdit_Text = (EditText) findViewById(R.id.parent_street_name_edit_text);
                    street_name = parentStreetNameEdit_Text.getText().toString();

                    //get the view of parentAppNumberEditText
                    parentAppNumberEditText = (EditText) findViewById(R.id.parent_app_number_edit_text);
                    app_number = parentAppNumberEditText.getText().toString();

                    //get the view of parentCityNameEdit_Text
                    parentCityNameEdit_Text = (EditText) findViewById(R.id.parent_city_name_edit_text);
                    city_name = parentCityNameEdit_Text.getText().toString();

                    //get the view of parentProvinceNameEdit_Text
                    parentProvinceNameEdit_Text = (EditText) findViewById(R.id.parent_province_name_edit_text);
                    province_name = parentProvinceNameEdit_Text.getText().toString();

                    //get the view of parentPostalCodeEdit_Text
                    parentPostalCodeEdit_Text = (EditText) findViewById(R.id.parent_postal_code_edit_text);
                    postal_code = parentPostalCodeEdit_Text.getText().toString();

                    //get the view of parentCountryNameEdit_Text
                    parentCountryNameEdit_Text = (EditText) findViewById(R.id.parent_country_name_edit_text);
                    country_name = parentCountryNameEdit_Text.getText().toString();

                    //get the view of parentTelNumberEdit_Text
                    parentTelNumberEdit_Text = (EditText) findViewById(R.id.parent_tel_number_edit_text);
                    tel_number = Long.parseLong(parentTelNumberEdit_Text.getText().toString());

                    //Creating an object of Parent using given info
                    Parent parent2 = new Parent(f_name, l_name, civic_number, street_name, app_number,
                            city_name, province_name, postal_code, country_name, tel_number);

                    //adding Parent object to the ArrayList
                    parentsList.add(parent2);

                    //adding a parent record to database TutorAppBase.db
                    context = ParentRegisterActivity.this.getApplicationContext();
                    TutorAppBaseHelper tutorAppBaseHelper = new TutorAppBaseHelper(context);
                    tutorAppBaseHelper.addNewParent(parent2);


                    //Display the successfully register message using Toast Class
                    Toast.makeText(ParentRegisterActivity.this, "Parent: " + f_name + " " + l_name + ", Tel. #: " + tel_number +
                            "\n has been registered successfully.", Toast.LENGTH_LONG).show();

                    Intent manageParentActivityIntent = new Intent(ParentRegisterActivity.this, ManageParantActivity.class);
                    startActivity(manageParentActivityIntent);
                }
                catch(Exception ex){
                    Toast.makeText(ParentRegisterActivity.this, "Please Enter the Information", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}