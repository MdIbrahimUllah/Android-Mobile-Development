package com.example.tutor_hiring_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class ManageChildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_child);

        //Use FragmentManager to add CourseFragment to MainActivity
        FragmentManager fm = getSupportFragmentManager();

        //Creating the Fragment object
        Fragment fragment = fm.findFragmentById(R.id.manage_child_container);

        if(fragment == null){
            fragment = new ManageChildFragment();
            fm.beginTransaction().add(R.id.manage_child_container, fragment).commit();
//            fm.beginTransaction().replace(R.id.manage_child_container, fragment, fragment.getTag()).commit();
        }
    }
}