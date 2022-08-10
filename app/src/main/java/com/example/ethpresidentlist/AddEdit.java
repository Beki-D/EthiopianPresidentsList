package com.example.ethpresidentlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class AddEdit extends AppCompatActivity {

    Button btn_ok, btn_cancel;
    List<President> presidentList;
    EditText et_PresidentName, et_Date, et_PictureURL;
    TextView tv_presId;
    int id;

    MyApp myApp = (MyApp) this.getApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        presidentList = myApp.getPresidentList();

        btn_ok = findViewById(R.id.btn_ok);
        btn_cancel = findViewById(R.id.btn_cancel);
        et_PresidentName = findViewById(R.id.et_PresidentName);
        et_Date = findViewById(R.id.et_Date);
        et_PictureURL = findViewById(R.id.et_PictureURL);
        tv_presId = findViewById(R.id.tv_presidentIDNumber);

        Intent intention = getIntent();
        id = intention.getIntExtra("id", -1); // id>-1 ? Treat the form as edit mode : Treat the form as new president mode
        President president = null;

        if (id >= 0){
            //edit the president
            for (President p: presidentList) {
                if (p.getId() == id){
                    president = p;
                }
            }
            et_PresidentName.setText(president.getName());
            et_Date.setText(String.valueOf(president.getDate()));
            et_PictureURL.setText(president.getImageURL());
            tv_presId.setText(String.valueOf(id));
        } else {
            //create new president
        }

        btn_ok.setOnClickListener(v -> {

            if (id >= 0){ //update mode
                President updatePresident = new President(id, et_PresidentName.getText().toString(), Integer.parseInt(et_Date.getText().toString()), et_PictureURL.getText().toString());
                presidentList.set(id, updatePresident);
            } else {
                //new president creation
                //create president object
                int nextID = myApp.getNextID();
                President newPresident = new President(nextID, et_PresidentName.getText().toString(), Integer.parseInt(et_Date.getText().toString()), et_PictureURL.getText().toString());

                //add the object to global list of presidents
                presidentList.add(newPresident);
                myApp.setNextID(nextID++);
            }

            //navigate back to main activity

            Intent intent = new Intent( AddEdit.this, MainActivity.class);
            startActivity(intent);
        });

        btn_cancel.setOnClickListener(v -> {
            Intent intent = new Intent( AddEdit.this, MainActivity.class);
            startActivity(intent);
        });
        //https://en.wikipedia.org/wiki/Barack_Obama#/media/File:President_Barack_Obama.jpg
    }
}