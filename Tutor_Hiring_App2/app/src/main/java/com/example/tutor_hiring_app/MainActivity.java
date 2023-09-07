package com.example.tutor_hiring_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Toolbar tutorHiringApp_Toolbar;
    Button parentRegister_Button;
    Button tutorRegister_Button;
    Button manageParent_Button;
    Button manageTutor_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //For Fragment
        //Fragment will receive call back from FragmentManager to fire onCreateOptionMenu()
//        setHasOptionsMenu(true);


        //get the view of tutorHiringApp_Toolbar
        tutorHiringApp_Toolbar = (Toolbar) findViewById(R.id.tutor_hiring_app_toolbar);
        AppCompatActivity activity = (AppCompatActivity) MainActivity.this;
        activity.setSupportActionBar(tutorHiringApp_Toolbar);

        //get the view of parentRegister_Button
        parentRegister_Button = (Button) findViewById(R.id.parent_register_button);
        parentRegister_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent parentRegisterIntent = new Intent(MainActivity.this, ParentRegisterActivity.class);
                startActivity(parentRegisterIntent);

            }
        });

        //get the view of tutorRegister_Button
        tutorRegister_Button = (Button) findViewById(R.id.tutor_register_button);
        tutorRegister_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tutorRegisterIntent = new Intent(MainActivity.this, TutorRegisterActivity.class);
                startActivity(tutorRegisterIntent);
            }
        });

        //get the view of manageParent_Button
        manageParent_Button = (Button) findViewById(R.id.manage_parent_button);
        manageParent_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Redirecting to ManageParentActivity
                Intent manageParentActivityIntent = new Intent(MainActivity.this, ManageParantActivity.class);
                startActivity(manageParentActivityIntent);
            }
        });

        //get the view of manageTutor_Button
        manageTutor_Button = (Button) findViewById(R.id.manage_tutor_button);
        manageTutor_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Redirecting to ManageTutorActivity
                Intent manageTutorActivityIntent = new Intent(MainActivity.this, ManageTutorActivity.class);
                startActivity(manageTutorActivityIntent);
            }
        });
    }

    //For Fragment
//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//        //inflate the menu defined in menu_course.xml
//        inflater.inflate(R.menu.menu_tutor_hiring_app, menu);
//    }

//For Activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tutor_hiring_app, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.search_tutor_item1:
                Toast.makeText(MainActivity.this, "Search A Tutor By Subject", Toast.LENGTH_LONG).show();
                //start new activity
                intent = new Intent(MainActivity.this, FindTutorActivity.class);
                startActivity(intent);
                return true;

            case R.id.contact_developer_item5:
                Toast.makeText(MainActivity.this, "Find Us in Google Maps..", Toast.LENGTH_LONG).show();
                //start new Activity of CourseContentActivity
                intent = new Intent(MainActivity.this, FindUsMaps.class);
                startActivity(intent);
                return true;

            case R.id.update_parent_info_item2:
                Toast.makeText(MainActivity.this, "Update Parent Info. Selected", Toast.LENGTH_LONG).show();
                //start new Activity of CourseContentActivity
                intent = new Intent(MainActivity.this, UpdateParentInfo.class);
                startActivity(intent);
                return true;

            case R.id.update_tutor_info_item3:
                Toast.makeText(MainActivity.this, "Update Tutor Info. Selected", Toast.LENGTH_LONG).show();
                //start new Activity of CourseContentActivity
                intent = new Intent(MainActivity.this, UpdateTutorInfo.class);
                startActivity(intent);
                return true;

            case R.id.contact_developer_item4:
                Toast.makeText(MainActivity.this, "Contact me via..", Toast.LENGTH_LONG).show();
                //start new Activity of CourseContentActivity
                intent = new Intent(MainActivity.this, ContactUs.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}