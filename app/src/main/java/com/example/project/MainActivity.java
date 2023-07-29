package com.example.project;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LinearLayout homeButton;
    private LinearLayout profileButton;
    private LinearLayout qnaButton;
    private Button addToListCorn;
    private Button addToListRaddish;
    private Button addToListBeans;
    private Button addToListCarrot;
    private Button addToListCabbage;

    ArrayList<String> plants = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize the menu buttons
        homeButton = findViewById(R.id.homeButton);
        profileButton = findViewById(R.id.profileButton);
        qnaButton = findViewById(R.id.qnaButton);
        addToListCorn = findViewById(R.id.addCornButton);
        addToListRaddish = findViewById(R.id.addRadishButton);
        addToListBeans = findViewById(R.id.addBeansButton);
        addToListCarrot = findViewById(R.id.addCarrotButton);
        addToListCabbage = findViewById(R.id.addCabbageButton);



        // Set click listeners for the menu buttons
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle home button click event
                openHomeActivity();
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle profile button click event
                openProfileActivity();
            }
        });

        qnaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle Q&A button click event
                openQnAActivity();
            }
        });


    }
    public void CornInfo(View view) {
        Intent intent = new Intent(this, CornProfileActivity.class);
        startActivity(intent);
    }
    public void RadishInfo(View view) {
        Intent intent = new Intent(this, RaddishActivity.class);
        startActivity(intent);
    }

    public void BeansInfo(View view) {
        Intent intent = new Intent(this, BeansProfileActivity.class);
        startActivity(intent);
    }

    public void CarrotInfo(View view) {
        Intent intent = new Intent(this, CarrotProfileActivity.class);
        startActivity(intent);
    }

    public void CabbageInfo(View view) {
        Intent intent = new Intent(this, CabbageProfileActivity.class);
        startActivity(intent);
    }

    public void addCorn(View view){
        plants.add("Corn");
        addToListCorn.setText("Added");
        addToListCorn.setClickable(false);

    }
    public void addRadish(View view){
        plants.add("Radish");
        addToListRaddish.setText("Added");
        addToListRaddish.setClickable(false);
    }
    public void addBeans(View view){
        plants.add("Beans");
        addToListBeans.setText("Added");
        addToListBeans.setClickable(false);
    }
    public void addCarrot(View view){
        plants.add("Carrot");
        addToListCarrot.setText("Added");
        addToListCarrot.setClickable(false);
    }
    public void addCabbage(View view){
        plants.add("Cabbage");
        addToListCabbage.setText("Added");
        addToListCabbage.setClickable(false);
    }

    // Handle the home button click event
    private void openHomeActivity() {
        // Add your code to open the home activity or perform the desired action
    }

    // Handle the profile button click event
    private void openProfileActivity() {
        // Add your code to open the profile activity or perform the desired action
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        intent.putExtra("key", plants);
        startActivity(intent);
    }

    // Handle the Q&A button click event
    private void openQnAActivity() {
        Intent intent = new Intent(this, QuestionAnswerActivity.class);
        startActivity(intent);

    }
}
