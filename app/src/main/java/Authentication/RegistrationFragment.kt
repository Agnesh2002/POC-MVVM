package Authentication

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.poc.R
import com.example.poc.databinding.FragmentRegistrationBinding


class RegistrationFragment : Fragment() {

    private lateinit var binding:FragmentRegistrationBinding
    private lateinit var viewModel: AuthenticationViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentRegistrationBinding.inflate(layoutInflater)
        var appCompatActivity: AppCompatActivity = (activity as AppCompatActivity)
        appCompatActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        appCompatActivity.supportActionBar?.title = "Registration"
        this.hasOptionsMenu()

        viewModel = ViewModelProvider(this).get(AuthenticationViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.errorCode.observe(viewLifecycleOwner, Observer {

            if(it==1) {
                binding.etUsername.error = "Please enter a valid Username"
                return@Observer
            }
            if(it==2) {
                binding.etEmailId.error = "Please enter a valid E-mail id"
                return@Observer
            }
            if(it==3) {
                binding.etPassword.error = "Please enter a password having 6 to 10 characters"
                return@Observer
            }
            if(it==4) {
                binding.etConfirmPassword.error = "Passwords does not match"
                return@Observer
            }

        })


        return binding.root
    }



}