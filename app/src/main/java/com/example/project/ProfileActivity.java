package com.example.project;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    private TextView usernameTextView;
    private TextView overviewTextView;
    private ListView wishListListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize views
        usernameTextView = findViewById(R.id.usernameTextView);
        overviewTextView = findViewById(R.id.overviewTextView);
        wishListListView = findViewById(R.id.wishListListView);

        // Populate profile information
        String username = "John Doe";
        String overview = "Plant lover from California";
        //List<String> wishList = Arrays.asList("Rose", "Orchid", "Fern");
        ArrayList<String> wishList = (ArrayList<String>) getIntent().getSerializableExtra("key");
        usernameTextView.setText(username);
        overviewTextView.setText(overview);

        ArrayAdapter<String> wishListAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, wishList);
        wishListListView.setAdapter(wishListAdapter);
    }
}
