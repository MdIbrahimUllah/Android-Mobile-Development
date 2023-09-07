package com.example.tutor_hiring_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManageParantActivity extends AppCompatActivity {
    Button manageChild_Button;
    Button findTutor_Button;
    Button updateParentInfo_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_parant);

        //get the view of findTutor_Button
        findTutor_Button = (Button) findViewById(R.id.find_tutor_button);
        findTutor_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManageParantActivity.this, FindTutorActivity.class);
                startActivity(intent);
            }
        });

        //get the view of updateParentInfo_Button
        updateParentInfo_Button = (Button) findViewById(R.id.update_Parent_info_button);
        updateParentInfo_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManageParantActivity.this, UpdateParentInfo.class);
                startActivity(intent);

            }
        });

        //get the view of manageChild_Button
        manageChild_Button = (Button) findViewById(R.id.manage_child_button);
        manageChild_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManageParantActivity.this, ManageChildActivity.class);
                startActivity(intent);

            }
        });
    }
}