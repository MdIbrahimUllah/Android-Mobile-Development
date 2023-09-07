package com.example.tutor_hiring_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tutor_hiring_app.database.TutorAppBaseHelper;

import java.util.ArrayList;

public class ManageChildFragment extends Fragment {
    ImageButton addChild_Button;
    ImageButton viewChild_Button;

    Context context;
    TutorAppBaseHelper tutorAppBaseHelper;

    private ArrayList<Child> childModalArrayList;
    private int current_index = 0;
    public String childList = "";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_manage_child, container,false);

        //get the view of addChild_Button
        addChild_Button = (ImageButton) v.findViewById(R.id.add_child_button);
        addChild_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddChildActivity.class);
                startActivity(intent);
            }
        });

        //get the view of viewChild_Button
        viewChild_Button = (ImageButton) v.findViewById(R.id.view_child_button);
        viewChild_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get the list of child from database
                context = getContext().getApplicationContext();
                childModalArrayList = new TutorAppBaseHelper(context).readChilds();

                String child_firstName = childModalArrayList.get(current_index).getChildFirstName();
                String child_lastName = childModalArrayList.get(current_index).getChildLastName();
                int child_age = childModalArrayList.get(current_index).getChildAge();

                 childList = "";

                for(Child child : childModalArrayList){
                    childList += child.toString();
                }
                Intent intent = ViewChildActivity.newIntent(getActivity(), child_firstName, child_lastName, child_age, childList);
                startActivity(intent);
            }
        });
        return v;
    }
}
