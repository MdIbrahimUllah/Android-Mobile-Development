package com.example.tutor_hiring_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManageTutorActivity extends AppCompatActivity {

    Button updateTutorInfo_Button;
    Button manageTutorActivityExit_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_tutor);

        //get the view of updateTutorInfo_Button
        updateTutorInfo_Button = (Button) findViewById(R.id.update_tutor_info_button);
        updateTutorInfo_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManageTutorActivity.this, UpdateTutorInfo.class);
                startActivity(intent);
            }
        });

        //get the view of manageTutorActivityExit_Button
        manageTutorActivityExit_Button = (Button) findViewById(R.id.manage_tutor_activity_exit_button);
        manageTutorActivityExit_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManageTutorActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}