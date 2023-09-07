package com.example.tutor_hiring_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactUs extends AppCompatActivity {
    TextView contactUsNameText_View;
    Button contactUsVanierLink_Button;
    Button contactUsGithubLink_Button;
    Button contactUsLinkedinLink_Button;
    String name = "Vanier College"+"\n Md Ibrahim Ullah"+"\nID#: 2295025";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        //get the view of contactUsNameText_View
        contactUsNameText_View = (TextView) findViewById(R.id.contact_us_name_text_view);
        contactUsNameText_View.setText(name);

        //get the view of contactUsVanierLink_Button
        contactUsVanierLink_Button = (Button) findViewById(R.id.contact_us_vanier_link_button);
        contactUsVanierLink_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.vaniercollege.qc.ca/"));
                startActivity(intent);
            }
        });

        //get the view of contactUsGithubLink_Button
        contactUsGithubLink_Button = (Button) findViewById(R.id.contact_us_github_link_button);
        contactUsGithubLink_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/MdIbrahimUllah"));
                startActivity(intent);
            }
        });

        //get the view of contactUsLinkedinLink_Button
        contactUsLinkedinLink_Button = (Button) findViewById(R.id.contact_us_linkedin_link_button);
        contactUsLinkedinLink_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/md-ibrahim-ullah/"));
                startActivity(intent);
            }
        });
    }
}