package com.rishabhsharma1212.scrapitems.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rishabhsharma1212.scrapitems.R

class ActivitySignUpPage : AppCompatActivity() {
    lateinit var etEnterYourName: EditText
    lateinit var etEnterPassword:EditText
    lateinit var etEnterEmailAddress:EditText
    lateinit var etEnterMobileNumber:EditText
    lateinit var btnSignUp:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        etEnterYourName=findViewById(R.id.etEnterYourName)
        etEnterPassword=findViewById(R.id.etEnterPassword)
        etEnterEmailAddress=findViewById(R.id.etEnterEmailAddress)
        etEnterMobileNumber=findViewById(R.id.etEnterMobileNumber)
        btnSignUp=findViewById(R.id.btnSignUp)


        btnSignUp.setOnClickListener{
            val entername=etEnterYourName.text.toString()
            val enterpassword=etEnterPassword.text.toString()

            val phonenumber=etEnterMobileNumber.text.toString()
            val message="Scrap Items"
            val intent=Intent(Intent.ACTION_VIEW).apply {
                data= Uri.parse("https://api.whatsapp.com/send?phone=$phonenumber&text=$message")
            }
            startActivity(intent)

            val recipient = "rishabhxyzsharma2002@gmail.com" // The email address of the recipient
            val subject = "Subject of the email" // The subject of the email
            val message1 = "Hello, World!" // The message body of the email

            val intent1 = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, message1)
            }

            if (intent1.resolveActivity(packageManager) != null) {
                startActivity(intent1)
            }
            /*val mIntent = Intent(Intent.ACTION_SEND)
            mIntent.data= Uri.parse("mailto:")
            mIntent.type="text/plain"
            mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf( etEnterEmailAddress))
            mIntent.putExtra(Intent.EXTRA_SUBJECT,"Scrap Items")
            mIntent.putExtra(Intent.EXTRA_TEXT,"ScrapItems\uD83C\uDF43- A Mobile App/Website for households & enterprises to Get Paid & Recycle their scrap in an organized manner with:\n" +
                    "✅Recycling of Paper, Metals, Plastics, Appliances, etc.\uD83D\uDDDE️\n" +
                    "✅100% True Weight & Best Rates⚖️\uD83D\uDCB8\n" +
                    "✅Trained & Verified Pickup Staff \uD83E\uDDBA\n" +
                    "✅Contribution to Swachh Bharat \uD83C\uDDEE\uD83C\uDDF3")

            try {
                startActivity(Intent.createChooser(mIntent,"Choose Email Client"))
            }
            catch (e:java.lang.Exception){
                Toast.makeText(this@ActivitySignUpPage, "Error message not sent", Toast.LENGTH_SHORT).show()
            }*/
            if(entername!=null && enterpassword!=null)
            {
                val intent2=Intent(this@ActivitySignUpPage,MainActivity::class.java)
                startActivity(intent2)
            }

        }
    }
}