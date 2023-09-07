package com.example.tutor_hiring_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tutor_hiring_app.database.TutorAppBaseHelper;

import java.util.ArrayList;

public class ConfirmParent extends AppCompatActivity {
    TextView confirmParentFullName_Text_View;
    TextView confirmParentAddress_Text_View;
    TextView confirmParentTel_Text_View;
    Button confirmParentNextParent_Button;
    Button confirmParentConfirm_Button;

    private int current_index = 0;
    private String fullName = "";
    private String address = "";
   private Long telNumber = 0L;

    private Context context;
    private TutorAppBaseHelper tutorAppBaseHelper;
    private ArrayList<Parent> parentModalArrayList;

    public static final String PARENT_DETAILS = "com.example.tutor_hiring_app.confirm_parent_details";
    public static final String TUTOR_DETAILS = "com.example.tutor_hiring_app.find_tutor_details";

    String parentDetails = "";
    String tutorDetails = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_parent);

        context = ConfirmParent.this.getApplicationContext();
        tutorAppBaseHelper = new TutorAppBaseHelper(context);
        parentModalArrayList = tutorAppBaseHelper.readParents();

        fullName = parentModalArrayList.get(current_index).getF_name()+" "+parentModalArrayList.get(current_index).getL_name()+"\n";
        address = parentModalArrayList.get(current_index).getCivic_number()+" "+parentModalArrayList.get(current_index).getStreet_name()+
                ", app.: "+parentModalArrayList.get(current_index).getApp_number()+"\n"+parentModalArrayList.get(current_index).getCity_name()+
                ", "+parentModalArrayList.get(current_index).getProvince_name()+", "+parentModalArrayList.get(current_index).getPostal_code()+
                "\n"+parentModalArrayList.get(current_index).getCountry_name();
        telNumber = parentModalArrayList.get(current_index).getTel_number();

        //get the view of confirmParentFullName_Text_View
        confirmParentFullName_Text_View = (TextView) findViewById(R.id.confirm_parent_full_name_text_view);
        confirmParentFullName_Text_View.setText(fullName);

        //get the view of confirmParentAddress_Text_View
        confirmParentAddress_Text_View = (TextView) findViewById(R.id.confirm_parent_address_text_view);
        confirmParentAddress_Text_View.setText(address);

        //get the view of confirmParentTel_Text_View
        confirmParentTel_Text_View = (TextView) findViewById(R.id.confirm_parent_tel_text_view);
        confirmParentTel_Text_View.setText(telNumber+"");

        //get the view of confirmParentNextParent_Button
        confirmParentNextParent_Button = (Button) findViewById(R.id.confirm_parent_next_parent_button);
        confirmParentNextParent_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current_index = (current_index + 1) % parentModalArrayList.size();

                fullName = parentModalArrayList.get(current_index).getF_name()+" "+parentModalArrayList.get(current_index).getL_name()+"\n";
                address = parentModalArrayList.get(current_index).getCivic_number()+" "+parentModalArrayList.get(current_index).getStreet_name()+
                        ", app.: "+parentModalArrayList.get(current_index).getApp_number()+"\n"+parentModalArrayList.get(current_index).getCity_name()+
                        ", "+parentModalArrayList.get(current_index).getProvince_name()+", "+parentModalArrayList.get(current_index).getPostal_code()+
                        "\n"+parentModalArrayList.get(current_index).getCountry_name();
                telNumber = parentModalArrayList.get(current_index).getTel_number();

                confirmParentFullName_Text_View.setText(fullName);
                confirmParentAddress_Text_View.setText(address);
                confirmParentTel_Text_View.setText(telNumber+"");
            }
        });

        //get the view of confirmParentConfirm_Button
        confirmParentConfirm_Button = (Button) findViewById(R.id.confirm_parent_confirm_button);
        confirmParentConfirm_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parentDetails = "Parent: "+parentModalArrayList.get(current_index).getF_name()+" "+parentModalArrayList.get(current_index).getL_name()+
                                ", Tel. Num.: "+parentModalArrayList.get(current_index).getTel_number();
                tutorDetails = FindTutorActivity.tutorDetails;
                Intent intent = new Intent(ConfirmParent.this, Payment.class);
                intent.putExtra(PARENT_DETAILS,parentDetails);
                intent.putExtra(TUTOR_DETAILS, tutorDetails);
                startActivity(intent);
            }
        });
    }
}