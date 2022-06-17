package Repository

import android.app.Application
import android.content.Context
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.auth.FirebaseAuth

class AuthenticationRepository {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun registerUser(application: Application,email:String, password:String)
    {
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(OnCompleteListener {
                if(it.isSuccessful)
                {
                    Toast.makeText(application.applicationContext,"User registered successfully",Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(application.applicationContext,it.exception?.message,Toast.LENGTH_SHORT).show()
                }
            })
            .addOnFailureListener(OnFailureListener {
                Toast.makeText(application.applicationContext,it.message,Toast.LENGTH_SHORT).show()
            })
    }

    fun loginUser(application: Application,email:String, password:String)
    {
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(OnCompleteListener {
                if(it.isSuccessful)
                {
                    Toast.makeText(application.applicationContext,"User logged in successfully",Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(application.applicationContext,it.exception?.message,Toast.LENGTH_SHORT).show()
                }
            })
            .addOnFailureListener(OnFailureListener {
                Toast.makeText(application.applicationContext,it.message,Toast.LENGTH_SHORT).show()
            })
    }

}