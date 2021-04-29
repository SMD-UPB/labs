package com.smd.lab7;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private CryptoManager cryptoManager;

    private Handler handler;

    private com.smd.lab7.databinding.ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // view binding (the ActivityMainBinding is generated based on the layout file's name)
        // more info on ViewBinding: https://developer.android.com/topic/libraries/view-binding

        binding = com.smd.lab7.databinding.ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        try {
            cryptoManager = new CryptoManager();
            cryptoManager.init();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Could not initialize crypto", Toast.LENGTH_LONG).show();
        }
        initComponents();
    }

    private void initComponents() {

        binding.savePinButton.setOnClickListener(new SavePinButtonListener());
        binding.showPinButton.setOnClickListener(new ShowPinButtonListener());
    }

    private String getPinDescription() {
        String pinDescription = binding.pinDescriptionEditText.getText().toString().trim();
        return pinDescription.length() > 0 ? pinDescription : "No specified description";
    }

    private boolean checkPinValidity(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private class SavePinButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            // TODO
            // Encrypt pin & description, store them in SharedPreferences
            // Encryption must be done on a different thread
            // ---> a possible way: https://ocw.cs.pub.ro/courses/smd/laboratoare/04#handlers_and_runnables
        }
    }

    private class ShowPinButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            // TODO
            // Load pin & description from SharedPreferences, decrypt them and show them in UI
            // Decryption must be done on a different thread
            // ---> a possible way: https://ocw.cs.pub.ro/courses/smd/laboratoare/04#handlers_and_runnables
        }
    }

    private static class PinData {
        public String pin;
        public String pinDescription;

        PinData(String pin, String pinDescription) {
            this.pin = pin;
            this.pinDescription = pinDescription;
        }
    }
}
