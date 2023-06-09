package com.example.remotecontroller.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.remotecontroller.R
import com.example.remotecontroller.Utils.FirebaseClass
import com.example.remotecontroller.databinding.LogInFragmentBinding

class LogInFragment : Fragment() {
    var _binding:  LogInFragmentBinding? = null;
    val binding get() = _binding!!;

    lateinit var navController: NavController;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LogInFragmentBinding.inflate(inflater, container, false);
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        binding.btnSignIn.setOnClickListener {
            val login = binding.enterEmail.text.toString();
            val password = binding.enterPassword.text.toString();
            FirebaseClass().loginWithLoginAndPassword(this, login, password);
        }

        binding.btnRegister.setOnClickListener {
            navController.navigate(R.id.action_logInFragment_to_signUpFragment);
        }


    }

    fun loginSuccess() {
        Toast.makeText(requireContext(), "", Toast.LENGTH_LONG).show();
        navController.navigate(R.id.action_logInFragment_to_signUpFragment); //kllllllllllllllllllllllll
    }
    fun loginFailure() {
        Toast.makeText(requireContext(), "Ошибка соединения.", Toast.LENGTH_LONG).show();
    }
}