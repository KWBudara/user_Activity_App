package com.test.useractivityapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        TextView = findViewById(R.id.Username)
        TextView = findViewById(R.id.email)

        editName = findViewById(R.id.editTextTextPersonName)
        editEmail = findViewById(R.id.editTextTextEmailAddress6)
        editAge = findViewById(R.id.editTextNumber)
        editPhone = findViewById(R.id.editTextPhone)

        button.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }

        button2.setOnClickListener {
            val dataToSend = User(
                editName.text.toString(),
                editEmail.text.toString(),
                editAge.text.toString(),
                editPhone.text.toString(),
                imageUri.toString()
            )

            val intent = Intent(applicationContext, ProfileActivity::class.java)
            intent.putExtra("message_key", dataToSend);
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            imageView.setImageURI(imageUri)
        }

        }
    }
}