package Authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.poc.R
import com.example.poc.databinding.FragmentLoginBinding
import com.example.poc.databinding.FragmentResetPasswordBinding


class ResetPasswordFragment : Fragment() {

    lateinit var binding: FragmentResetPasswordBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentResetPasswordBinding.inflate(layoutInflater)


        return binding.root
    }

}