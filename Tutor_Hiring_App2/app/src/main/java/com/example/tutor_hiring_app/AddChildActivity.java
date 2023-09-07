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

public class AddChildActivity extends AppCompatActivity {

    private String childFirstName;
    private String childLastName;
    private int childAge;

    EditText addChildActivityChildFNameEdit_Text;
    EditText addChildActivityChildLNameEdit_Text;
    EditText addChildActivityChildAgeEdit_Text;
    Button addChildActivitySave_Button;

    Context context;
    TutorAppBaseHelper tutorAppBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_child);

        //grt the view of addChildActivitySave_Button
        addChildActivitySave_Button = (Button) findViewById(R.id.add_child_activity_save_button);
        addChildActivitySave_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                try {
                    //get the view of addChildActivityChildFNameEdit_Text
                    addChildActivityChildFNameEdit_Text = (EditText) findViewById(R.id.add_child_activity_child_f_name_edit_text);
                    childFirstName = addChildActivityChildFNameEdit_Text.getText().toString();

                    //get the view of addChildActivityChildLNameEdit_Text
                    addChildActivityChildLNameEdit_Text = (EditText) findViewById(R.id.add_child_activity_child_l_name_edit_text);
                    childLastName = addChildActivityChildLNameEdit_Text.getText().toString();

                    //get the view of addChildActivityChildAgeEdit_Text
                    addChildActivityChildAgeEdit_Text = (EditText) findViewById(R.id.add_child_activity_child_age_edit_text);
                    childAge = Integer.parseInt(addChildActivityChildAgeEdit_Text.getText().toString());

                    //creating a Child object
                    Child child = new Child(childFirstName, childLastName, childAge);

                    //adding child record to the TutorAppBase.db
                    context = AddChildActivity.this.getApplicationContext();
                    tutorAppBaseHelper = new TutorAppBaseHelper(context);
                    tutorAppBaseHelper.addNewChild(child);

                    //toast message to added record to database
                    Toast.makeText(AddChildActivity.this, "Child: " + childFirstName + " " + childLastName + " was added successfully.", Toast.LENGTH_LONG).show();

                    //Redirect to the ManageChildFragment
                    Intent intent = new Intent(AddChildActivity.this, ManageChildActivity.class);
                    startActivity(intent);
                }
                catch(Exception ex){
                    Toast.makeText(AddChildActivity.this, "Please Enter the Information", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}