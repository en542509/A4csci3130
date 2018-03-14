package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.List;
import java.util.*;


public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText nameField, BusField,addrField, priBusField, provinField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.name);
        BusField = (EditText) findViewById(R.id.BusID);
        addrField = (EditText)findViewById(R.id.addr);
        priBusField = (EditText)findViewById(R.id.priBus);
        provinField = (EditText)findViewById(R.id.province);

    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID

        String personID = appState.firebaseReference.push().getKey();

        String name = nameField.getText().toString();
        String busID = BusField.getText().toString();
        String address = addrField.getText().toString();
        String priBusiness = priBusField.getText().toString();
        String province = provinField.getText().toString();

//        boolean result= true;
//
//        List<String> pros = Arrays.asList("AB", "BC", "MB", "NB", "NL", "NS", "NT", "NU", "ON", "PE", "QC", "SK", "YT", " ");
//
//        if (name.length() >= 2 || name.length() <= 48) {
//            if (busID.length() == 9) {
//                if (address.length() <= 50) {
//                    if (priBusiness.equalsIgnoreCase("Fisher") ||
//                            priBusiness.equalsIgnoreCase("Distributor") ||
//                            priBusiness.equalsIgnoreCase("Processor") ||
//                            priBusiness.equalsIgnoreCase("Fish Monger")) {
//                        if (pros.contains(province)) {
//                            result = true;
//                        }
//                        else{
//                            result = false;
//                        }
//                    }
//                }
//            }
//        }
//        if(result == true){

            Contact person=new Contact(personID,name,busID,address,priBusiness,province);

            appState.firebaseReference.child(personID).setValue(person);

            finish();
        }
}
//}

