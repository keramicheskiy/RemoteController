package com.example.remotecontroller.Utils;

import com.example.remotecontroller.Data.User;
import com.example.remotecontroller.Fragments.LogInFragment;
import com.example.remotecontroller.Fragments.SignUpFragment;
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

/**
 * FirebaseClass.kt is made to communicate with any type of Firebase's databases
 * It is usually used with collections in FireStore, however has some Auth methods
 * I will mark witch method uses Auth and Collections.
 */

class FirebaseClass {
    // declaration of fields that are necessary for firebase
    private var mFireStore = FirebaseFirestore.getInstance();
    private var mAuth = FirebaseAuth.getInstance();

    // TODO - Collections + Auth method
    fun createUser(fragment: SignUpFragment, user: User, password: String?) {
        mFireStore.collection(Constants.USERS)
            .document()
            .set(user)
            .addOnSuccessListener { registerUser(fragment, user.login, password); }
            .addOnFailureListener { fragment.registrationFailure(); };
    }


    //TODO - Auth (Used in __Firebase().createUser()__)
    private fun registerUser(fragment: SignUpFragment, login: String?, password: String?) {
        mAuth.createUserWithEmailAndPassword(login!!, password!!)
            .addOnSuccessListener { fragment.registrationSuccessful(); }
            .addOnFailureListener{ fragment.registrationFailure(); };
    }

    //TODO
    fun loginWithLoginAndPassword(fragment: LogInFragment, login: String, password: String) {
        mAuth.signInWithEmailAndPassword(login, password)
            .addOnSuccessListener { fragment.loginSuccess(); }
            .addOnFailureListener { fragment.loginFailure(); };
    }


    fun getUserEmail(): String? {
        val currentUser = mAuth.currentUser;
        var currentUserEmail: String? = "";
        if (currentUser != null) {
            currentUserEmail = currentUser.email;
        }
        return currentUserEmail;
    }
    fun getUserID(): String{
        val currentUser = FirebaseAuth.getInstance().currentUser;
        var currentUserId = "";
        if (currentUser != null) {
            currentUserId = currentUser.uid;
        }
        return currentUserId;
    }

    fun signOut() {
        mAuth.signOut();
    }

}