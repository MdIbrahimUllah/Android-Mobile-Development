package com.example.tutor_hiring_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tutor_hiring_app.database.TutorAppBaseHelper;

import java.util.ArrayList;

public class FindTutorActivity extends AppCompatActivity {
    EditText findTutorActivitySearchEdit_Text;
    EditText tutorFirstName_Edit_Text;
    EditText tutorLastName_Edit_Text;
    EditText tutorTelNumber_Edit_Text;
    EditText tutorHourFees_Edit_Text;
    EditText tutorExperience_Edit_Text;
    TextView findTutorActivity_Text_View;
    Button searchTutor_Button;
    Button reserveTutor_Button;

    private Tutor tutor;
    private String search_word;
    public static String tutorDetails = "";

    String f_name, l_name;
    Long tel_number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_tutor);

        //get the view of searchTutor_Button
        searchTutor_Button = (Button) findViewById(R.id.search_tutor_button);
        searchTutor_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get the view of findTutorActivity_Search_Box
                findTutorActivitySearchEdit_Text = (EditText) findViewById(R.id.find_tutor_activity_search_edit_text);
                search_word = findTutorActivitySearchEdit_Text.getText().toString();
                Context context = FindTutorActivity.this.getApplicationContext();
                TutorAppBaseHelper tutorAppBaseHelper = new TutorAppBaseHelper(context);

                tutor = tutorAppBaseHelper.findTutor(search_word);

                try{
                    //get the view of findTutorActivity_Text_View
                    findTutorActivity_Text_View = (TextView) findViewById(R.id.find_tutor_activity_text_view);
                    findTutorActivity_Text_View.setText(tutor.toString());

                    //get the view of tutorFirstName_Edit_Text
                    tutorFirstName_Edit_Text = (EditText) findViewById(R.id.tutor_first_name_edit_text);
                    tutorFirstName_Edit_Text.setText(tutor.getF_name());

                    //get the view of tutorLastName_Edit_Text
                    tutorLastName_Edit_Text = (EditText) findViewById(R.id.tutor_last_name_edit_text);
                    tutorLastName_Edit_Text.setText(tutor.getL_name());

                    //get the view of tutorTelNumber_Edit_Text
                    tutorTelNumber_Edit_Text = (EditText) findViewById(R.id.tutor_tel_number_edit_text);
                    tutorTelNumber_Edit_Text.setText(tutor.getTel_number()+"");

                    //get the view of tutorHourFees_Edit_Text
                    tutorHourFees_Edit_Text = (EditText) findViewById(R.id.tutor_hour_fees_edit_text);
                    tutorHourFees_Edit_Text.setText(tutor.getHour_fees()+"");

                    //get the view of tutorExperience_Edit_Text
                    tutorExperience_Edit_Text = (EditText) findViewById(R.id.tutor_experience_edit_text);
                    tutorExperience_Edit_Text.setText(tutor.getExperience()+"");


                }
                catch (Exception ex){
                    findTutorActivity_Text_View.setText("No Tutor have been found for this Subject");
                }
            }
        });

        //get the view of reserveTutor_Button
        reserveTutor_Button = (Button) findViewById(R.id.reserve_tutor_button);
        reserveTutor_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    tutorDetails = "Tutor: " + tutor.getF_name() + " " + tutor.getL_name() + ", Tel. num.: " + tutor.getTel_number();

                    Intent intent = new Intent(FindTutorActivity.this, ConfirmParent.class);
                    startActivity(intent);

                    Toast.makeText(FindTutorActivity.this, "Tutor: " + tutor.getF_name() + " " + tutor.getL_name() + " reserved successfully " +
                            "by the following Parent", Toast.LENGTH_LONG).show();
                }
                catch(Exception ex){
                    Toast.makeText(FindTutorActivity.this, "Please Find a Tutor to Reserve", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}