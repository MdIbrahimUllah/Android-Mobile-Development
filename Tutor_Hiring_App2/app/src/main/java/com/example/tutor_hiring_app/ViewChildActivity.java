package com.example.tutor_hiring_app;

//import static com.example.tutor_hiring_app.ManageChildFragment.EXTRA_CHILD_VIEW;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tutor_hiring_app.database.TutorAppBaseHelper;

import java.util.ArrayList;

public class ViewChildActivity extends AppCompatActivity {

    private EditText viewChildActivityChildFNameEdit_Text;
    private EditText viewChildActivityChildLNameEdit_Text;
    private EditText viewChildActivityChildAgeEdit_Text;
    private TextView viewChildActivityText_View;
    private Button viewChildActivityNextChild_Button;
    private Button viewChildActivityUpdateChild_Button;
    private Button viewChildActivityDeleteChild_Button;

    public static final String EXTRA_CHILD_FIRST_NAME = "com.example.ViewChildActivity_child_first_name";
    public static final String EXTRA_CHILD_LAST_NAME = "com.example.ViewChildActivity_child_last_name";
    public static final String EXTRA_CHILD_AGE = "com.example.ViewChildActivity_child_age";
    public static final String EXTRA_CHILD_VIEW = "com.example.ViewChildActivity_child_view";

    private String first_name;
    private String last_name;
    private int age;
    private String childList;

    private int currentIndex = 0;
    Context context;
    TutorAppBaseHelper tutorAppBaseHelper;
    private ArrayList<Child> childModalArrayList;

    //method to return an Intent object.
    public static Intent newIntent(Context packageContext, String child_firstName, String child_lastName, int child_age, String child_list){
        Intent intent = new Intent(packageContext, ViewChildActivity.class);

        intent.putExtra(EXTRA_CHILD_FIRST_NAME,child_firstName);
        intent.putExtra(EXTRA_CHILD_LAST_NAME, child_lastName);
        intent.putExtra(EXTRA_CHILD_AGE, child_age);
        intent.putExtra(EXTRA_CHILD_VIEW, child_list);

        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_child);

        first_name = getIntent().getStringExtra(EXTRA_CHILD_FIRST_NAME);
        last_name = getIntent().getStringExtra(EXTRA_CHILD_LAST_NAME);
        age = getIntent().getIntExtra(EXTRA_CHILD_AGE,0);
        childList = getIntent().getStringExtra(EXTRA_CHILD_VIEW);

        //get the view of viewChildActivityChildFNameEdit_Text
        viewChildActivityChildFNameEdit_Text = (EditText) findViewById(R.id.view_child_activity_child_fname_edit_text);
        viewChildActivityChildFNameEdit_Text.setText(first_name);

        //get the view of viewChildActivityChildLNameEdit_Text
        viewChildActivityChildLNameEdit_Text = (EditText) findViewById(R.id.view_child_activity_child_lname_edit_text);
        viewChildActivityChildLNameEdit_Text.setText(last_name);

        //get the view of viewChildActivityChildAgeEdit_Text
        viewChildActivityChildAgeEdit_Text = (EditText) findViewById(R.id.view_child_activity_child_age_edit_text);
        viewChildActivityChildAgeEdit_Text.setText(age+"");

        //get the view of viewChildActivityText_View
        viewChildActivityText_View = (TextView) findViewById(R.id.view_child_activity_text_view);
        viewChildActivityText_View.setText(childList);

        //get the view of viewChildActivityNextChild_Button
        viewChildActivityNextChild_Button = (Button) findViewById(R.id.view_child_activity_next_child_button);
        viewChildActivityNextChild_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = ViewChildActivity.this.getApplicationContext();
                tutorAppBaseHelper = new TutorAppBaseHelper(context);
                childModalArrayList = tutorAppBaseHelper.readChilds();

                currentIndex = (currentIndex + 1) % childModalArrayList.size();

                //get the record of current child object
                first_name = childModalArrayList.get(currentIndex).getChildFirstName();
                last_name = childModalArrayList.get(currentIndex).getChildLastName();
                age = childModalArrayList.get(currentIndex).getChildAge();

                viewChildActivityChildFNameEdit_Text.setText(first_name);
                viewChildActivityChildLNameEdit_Text.setText(last_name);
                viewChildActivityChildAgeEdit_Text.setText(age+"");

            }
        });

        //get the view of viewChildActivityUpdateChild_Button
        viewChildActivityUpdateChild_Button = (Button) findViewById(R.id.view_child_activity_update_child_button);
        viewChildActivityUpdateChild_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                first_name = viewChildActivityChildFNameEdit_Text.getText().toString();
                last_name =  viewChildActivityChildLNameEdit_Text.getText().toString();
                age = Integer.parseInt(viewChildActivityChildAgeEdit_Text.getText().toString());

                //Update the Child record
                Child child = new Child(first_name, last_name, age);
                context = ViewChildActivity.this.getApplicationContext();
                tutorAppBaseHelper = new TutorAppBaseHelper(context);
                tutorAppBaseHelper.updateChild(child);

                //Display the updated child list in the viewChildActivityText_View Scrollview
                childModalArrayList = tutorAppBaseHelper.readChilds();
                String updated_childList = "";
                for(Child updatedChild : childModalArrayList){
                    updated_childList += updatedChild;
                }
                viewChildActivityText_View.setText(updated_childList);


                Toast.makeText(ViewChildActivity.this, "Name: "+first_name+" "+last_name+" has been updated successfully.", Toast.LENGTH_SHORT).show();

            }
        });

        //get the view of viewChildActivityDeleteChild_Button
        viewChildActivityDeleteChild_Button = (Button) findViewById(R.id.view_child_activity_delete_child_button);
        viewChildActivityDeleteChild_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                first_name = viewChildActivityChildFNameEdit_Text.getText().toString();
                last_name =  viewChildActivityChildLNameEdit_Text.getText().toString();
                age = Integer.parseInt(viewChildActivityChildAgeEdit_Text.getText().toString());

                Child child = new Child(first_name, last_name, age);
                context = ViewChildActivity.this.getApplicationContext();
                tutorAppBaseHelper = new TutorAppBaseHelper(context);
                tutorAppBaseHelper.deleteChild(child);

                //Display the updated child list in the viewChildActivityText_View Scrollview
                childModalArrayList = tutorAppBaseHelper.readChilds();
                String updated_childList = "";
                for(Child updatedChild : childModalArrayList){
                    updated_childList += updatedChild;
                }
                viewChildActivityText_View.setText(updated_childList);

                Toast.makeText(ViewChildActivity.this, "Name: "+first_name+" "+last_name+" has been deleted successfully.", Toast.LENGTH_SHORT).show();

            }
        });

    }
}