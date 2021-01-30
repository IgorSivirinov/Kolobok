package com.example.lightfuture.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.lightfuture.R;

public class ListItemActivity extends AppCompatActivity {


    TextView NameTextView, LocationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        NameTextView = findViewById(R.id.nambet_activity_list_item);
        LocationTextView = findViewById(R.id.location_activity_list_item_text_view);

        for(ModelListItem i:TipaDatabase.ItsDataList){
            if(i.id == getIntent().getIntExtra("id", 0)) {
                NameTextView.setText(i.number);
                LocationTextView.setText(i.location);
            }
        }



        ImageButton imageButton = findViewById(R.id.ib_back_toolbar_activity_list_item);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}