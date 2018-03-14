package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText nameField, BusField,addrField, priBusField, provinField;
    Contact receivedPersonInfo;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        appState = ((MyApplicationData) getApplicationContext());

        nameField = (EditText) findViewById(R.id.name);
        BusField = (EditText) findViewById(R.id.BusID);
        addrField = (EditText)findViewById(R.id.address);
        priBusField = (EditText)findViewById(R.id.priBus);
        provinField = (EditText)findViewById(R.id.province);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            BusField.setText(receivedPersonInfo.Bid);
            addrField.setText(receivedPersonInfo.add);
            priBusField.setText(receivedPersonInfo.priBus);
            provinField.setText(receivedPersonInfo.province);
        }
    }

    public void updateContact(View v){
        //TODO: Update contact funcionality

        String pID = receivedPersonInfo.uid;
        String name = nameField.getText().toString();
        String busID = BusField.getText().toString();
        String address = addrField.getText().toString();
        String priBusiness = priBusField.getText().toString();
        String province = provinField.getText().toString();
//
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
//
//        if(result == true){
            Contact person=new Contact(pID,name,busID,address,priBusiness,province);
            appState.firebaseReference.child(pID).setValue(person);
            finish();
//        }
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        String uid = receivedPersonInfo.uid;
        appState.firebaseReference.child(uid).removeValue();
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);

    }
}
