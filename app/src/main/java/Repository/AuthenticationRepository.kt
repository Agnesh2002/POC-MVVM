package Repository

import android.app.Application
import android.content.Context
import android.widget.Toast
import com.firebase.ui.auth.data.model.User
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest

class AuthenticationRepository {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private var firebaseUser:FirebaseUser = auth.currentUser!!

    fun registerUser(application: Application,username: String, email:String, password:String)
    {
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    updateUsername(application, username)
                } else {
                    Toast.makeText(application.applicationContext, it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener {
                Toast.makeText(application.applicationContext, it.message, Toast.LENGTH_SHORT).show()
            }
    }

    private fun updateUsername(application: Application, username: String)
    {
        var profileChangeRequest: UserProfileChangeRequest = UserProfileChangeRequest.Builder()
            .setDisplayName(username)
            .build()

        firebaseUser.updateProfile(profileChangeRequest)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(application.applicationContext, "User registered successfully", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(application.applicationContext, it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener {
                Toast.makeText(application.applicationContext, it.message, Toast.LENGTH_SHORT).show()
            }
    }


    fun loginUser(application: Application, email:String, password:String)
    {
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(application.applicationContext, "Hi, "+firebaseUser.displayName, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(application.applicationContext, it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener {
                Toast.makeText(application.applicationContext, it.message, Toast.LENGTH_SHORT).show()
            }
    }

    fun resetPassword(application: Application, email: String)
    {
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(application.applicationContext, "Password reset link has been sent to the provided email address", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(application.applicationContext, it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener {
                Toast.makeText(application.applicationContext, it.message, Toast.LENGTH_SHORT).show()
            }
    }

}