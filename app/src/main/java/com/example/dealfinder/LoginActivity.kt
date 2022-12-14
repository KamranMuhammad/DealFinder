package com.example.dealfinder

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

public class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    lateinit var email : EditText
    lateinit var password: EditText
    lateinit var logiNBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.username)
        password = findViewById(R.id.password)
        logiNBtn = findViewById(R.id.login)
        auth = FirebaseAuth.getInstance()

        logiNBtn.setOnClickListener{
            loginUser()
        }

    }

    private fun loginUser() {

        val emailInput = email.text.toString()
        val passInput = password.text.toString()

        auth.signInWithEmailAndPassword(emailInput, passInput)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,SelectActivity::class.java))
                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(baseContext, "Login failed.",
                        Toast.LENGTH_SHORT).show()

                    
                }
            }

        }
    }




