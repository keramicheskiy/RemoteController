package com.example.remotecontroller.Fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.openmouse.utils.BaseActivity
import com.example.remotecontroller.R
import com.example.remotecontroller.Utils.FirebaseClass
import com.example.remotecontroller.Data.User
import com.example.remotecontroller.databinding.SignUpFragmentBinding

class SignUpFragment : Fragment() {
    var _binding: SignUpFragmentBinding? = null;
    val binding get() = _binding!!;
    val mBaseActivity = BaseActivity();
    val mFireBase = FirebaseClass();

    lateinit var navController: NavController;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SignUpFragmentBinding.inflate(inflater, container, false);
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        binding.btnRegistrate.setOnClickListener {
            if (validate()) {
                val user = User(
                    binding.enterEmail.text.toString().trim(),
                    binding.enterFirstName.text.toString().trim(),
                    binding.enterLastName.text.toString().trim()
                );
                mFireBase.createUser(
                    this,
                    user,
                    binding.enterPassword.text.toString().trim()
                );
            }
        }


    }




    fun registrationSuccessful() {
        Toast.makeText(requireContext(), "Successfully", Toast.LENGTH_SHORT).show();
        Thread.sleep(1000);
        navController.navigate(R.id.action_signUpFragment_to_logInFragment);
    }
    fun registrationFailure() {
        Toast.makeText(requireContext(), "Registration failed", Toast.LENGTH_SHORT).show();
    }

    fun validate(): Boolean {
        return when {
            TextUtils.isEmpty(binding.enterEmail.text.toString().trim()) ->
                emptyResult("email");
            TextUtils.isEmpty(binding.enterPassword.text.toString().trim()) ->
                emptyResult("password 1");
            TextUtils.isEmpty(binding.enterRepeatPassword.text.toString().trim()) ->
                emptyResult("password 2");
            TextUtils.isEmpty(binding.enterFirstName.text.toString().trim()) ->
                emptyResult("first name");
            TextUtils.isEmpty(binding.enterLastName.text.toString().trim()) ->
                emptyResult("last name");
            TextUtils.isEmpty(binding.enterPhoneNumber.text.toString().trim()) ->
                emptyResult("number");
            else -> true;
        }
    }
    fun emptyResult(value: String): Boolean {
        mBaseActivity.showErrorSnackBar("Fill $value", true);
        return false;
    }

}