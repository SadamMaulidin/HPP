package com.example.hpp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hpp.databinding.ActivitySignUpBinding
import com.example.hpp.model.BussinessModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.tvToSignIn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        binding.btnSignUp.setOnClickListener {
            val data = BussinessModel(
                email = binding.emailEt.text.toString(),
                password = binding.passET.text.toString(),
            )
            val confPass = binding.confirmPass.text.toString()

            if (data.email!!.isNotEmpty()&&data.password!!.isNotEmpty()&&confPass.isNotEmpty()){
                if (data.password==confPass){

//                    FirebaseDatabase.getInstance().getReference("bussiness")
//                        .child(FirebaseAuth.getInstance().currentUser!!.email!!)
//                        .setValue(data).addOnCompleteListener {
//                            if (it.isSuccessful){
//                                val intent = Intent(this, SignInActivity::class.java)
//                                startActivity(intent)
//                            }else{
//                                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
//                            }
//                        }

                    firebaseAuth.createUserWithEmailAndPassword(data.email!!, data.password!!).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this, "Register Berhasil", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, SignInActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }

                }else{
                    Toast.makeText(this, "Password tidak sama", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Pastikan semua bagian telah terisi!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}