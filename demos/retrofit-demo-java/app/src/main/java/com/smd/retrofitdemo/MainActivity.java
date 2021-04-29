package com.smd.retrofitdemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Shows a list of the astronauts who are on ISS or in transit to it
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private PeopleInSpaceViewModel peopleInSpaceViewModel;
    private PeopleInSpaceAdapter peopleInSpaceAdapter;
    private TextView peopleCountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewModel();

        initUI();
    }

    private void initViewModel() {
        peopleInSpaceViewModel = ViewModelProviders.of(this).get(PeopleInSpaceViewModel.class);
        peopleInSpaceViewModel.init();
        peopleInSpaceViewModel.getPeopleInSpaceLiveData().observe(this, peopleInSpace -> {
            if (peopleInSpace != null) {
                Log.d(TAG, "people in space " + peopleInSpace.getNumber());

                // Update the recycler view adapter
                peopleInSpaceAdapter.replaceAll(peopleInSpace.getPeople());

                peopleCountTextView.setText(getString(R.string.astronauts_count, peopleInSpace.getNumber()));
            }
        });
    }

    private void initUI() {
        peopleInSpaceAdapter = new PeopleInSpaceAdapter(new ArrayList<>());

        Button showPeopleButton = findViewById(R.id.show_button);
        showPeopleButton.setOnClickListener(v -> peopleInSpaceViewModel.getPeopleInSpace());

        RecyclerView astronauts = findViewById(R.id.astronauts_list);
        astronauts.setAdapter(peopleInSpaceAdapter);

        peopleCountTextView = findViewById(R.id.count_tv);
    }
}