package com.fire.fire.firebasecarouseltutorial.utils;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by brad on 2017/03/05.
 */

public class FirebaseUtils {
    public static DatabaseReference getItemsRef(){
        return FirebaseDatabase.getInstance().getReference(Constants.KEY_ITEMS);
    }
}
