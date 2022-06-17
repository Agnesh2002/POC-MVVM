package Authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.poc.R
import com.example.poc.databinding.FragmentLoginBinding
import com.example.poc.databinding.FragmentResetPasswordBinding


class ResetPasswordFragment : Fragment() {

    lateinit var binding: FragmentResetPasswordBinding
    lateinit var viewModel: AuthenticationViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentResetPasswordBinding.inflate(layoutInflater)
        var appCompatActivity:AppCompatActivity = activity as AppCompatActivity
        appCompatActivity.supportActionBar?.title="Reset Password"
        appCompatActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProvider(this).get(AuthenticationViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.errorCode.observe(viewLifecycleOwner, Observer {
            if(it==2) {
                binding.etResetPasswordEmailId.error = "Please enter a valid E-mail id"
                return@Observer
            }
        })

        return binding.root
    }

}