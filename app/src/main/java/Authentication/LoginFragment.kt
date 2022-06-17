package Authentication

import android.app.ActionBar
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.poc.R
import com.example.poc.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    lateinit var binding:FragmentLoginBinding
    lateinit var viewModel: AuthenticationViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentLoginBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this).get(AuthenticationViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.errorCode.observe(viewLifecycleOwner, Observer {
            if(it==2) {
                binding.etLoginEmailId.error = "Please enter a valid E-mail id"
                return@Observer
            }
            if(it==3) {
                binding.etLoginPassword.error = "Please enter a password having 6 to 10 characters"
                return@Observer
            }
        })

        binding.tvLoginGoToRegister.setOnClickListener(View.OnClickListener {
            fragmentChange(RegistrationFragment())
        })

        binding.tvLoginResetPassword.setOnClickListener(View.OnClickListener {
            fragmentChange(ResetPasswordFragment())
        })


        return binding.root
    }

    fun fragmentChange(fragment: Fragment)
    {
        var transaction:FragmentTransaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_authentication,fragment).commit()
    }


}