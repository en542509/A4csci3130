package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Contact implements Serializable {

    public  String uid;
    public  String name;
    public  String Bid;
    public  String add;
    public  String priBus;
    public  String province;


    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    public Contact( String uid, String name,String Bid, String add,String priBus, String province){
        this.uid = uid;
        this.Bid = Bid;
        this.name = name;
        this.add = add;
        this.priBus = priBus;
        this.province = province;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid",uid);
        result.put("name", name);
        result.put("Bid", Bid);
        result.put("priBus", priBus);
        result.put("Address", add);
        result.put("province", province);

        return result;
    }
}
