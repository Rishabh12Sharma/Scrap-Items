package com.rishabhsharma1212.scrapitems.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.rishabhsharma1212.scrapitems.R

class ActivityLoginPage : AppCompatActivity() {
    private lateinit var etEnterYourName:EditText
    private lateinit var etPassword:EditText
    private lateinit var btnLogin:Button
    private lateinit var btnSignUp: Button
    private val validName="rishabh"
    private val validPassword="sharma"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        etEnterYourName=findViewById(R.id.etEnterYourName)
        etPassword=findViewById(R.id.etEnterPassword)
        btnLogin=findViewById(R.id.btnLogin)
        btnSignUp=findViewById(R.id.btnSignUp)

        btnLogin.setOnClickListener{
            val name=etEnterYourName.text.toString()
            val password=etPassword.text.toString()
            if(validName==name && validPassword==password)
            {
                val intent=Intent(this@ActivityLoginPage,MainActivity::class.java)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this@ActivityLoginPage, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }
        }
        btnSignUp.setOnClickListener{
            val intent1=Intent(this@ActivityLoginPage,ActivitySignUpPage::class.java)
            startActivity(intent1)
        }
    }
    override fun onPause() {
        super.onPause()
        finish()
    }
}