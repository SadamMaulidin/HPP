package com.example.hpp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.hpp.databinding.ActivityProfileBinding
import com.example.hpp.model.BussinessModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.w3c.dom.Text

class ProfileActivity : AppCompatActivity() {

//    private lateinit var etBsName: EditText
//    private lateinit var etBsType: EditText
//    private lateinit var etAddress: EditText
//    private lateinit var etPhoneNum: EditText
//    private lateinit var etOwner: EditText
//    private lateinit var btnSaveProf: Button

    private lateinit var dbRef: DatabaseReference
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        etBsName = findViewById(R.id.bnEt)
//        etBsType = findViewById(R.id.btEt)
//        etAddress = findViewById(R.id.addrEt)
//        etPhoneNum = findViewById(R.id.telpEt)
//        etOwner = findViewById(R.id.ownerEt)
//        btnSaveProf = findViewById(R.id.btnSaveProf)
//
//        dbRef = FirebaseDatabase.getInstance().getReference("Bussiness")

        binding.btnSaveProf.setOnClickListener {
            val bName = binding.bnEt.text.toString()
            val bType = binding.btEt.text.toString()
            val addr = binding.addrEt.text.toString()
            val phone = binding.telpEt.text.toString()
            val owner = binding.ownerEt.text.toString()

            dbRef = FirebaseDatabase.getInstance().getReference("BussinessProf")
            val bussiness = BussinessModel(bName,bType,addr,phone,owner)
            dbRef.child(bName).setValue(bussiness).addOnSuccessListener {
                binding.bnEt.text?.clear()
                binding.btEt.text?.clear()
                binding.addrEt.text?.clear()
                binding.telpEt.text?.clear()
                binding.ownerEt.text?.clear()

                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@ProfileActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

//    private fun saveBussinessData(){
//
//        //get value
//        val bsName = etBsName.text.toString()
//        val bsType = etBsType.text.toString()
//        val address = etAddress.text.toString()
//        val phoneNum = etPhoneNum.text.toString()
//        val owner = etOwner.text.toString()
//
//
//    }
}