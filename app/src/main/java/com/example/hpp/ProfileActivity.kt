package com.example.hpp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.w3c.dom.Text

class ProfileActivity : AppCompatActivity() {

    private lateinit var etBsName: EditText
    private lateinit var etBsType: EditText
    private lateinit var etAddress: EditText
    private lateinit var etPhoneNum: EditText
    private lateinit var etOwner: EditText
    private lateinit var btnSaveProf: Button

    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        etBsName = findViewById(R.id.bnEt)
        etBsType = findViewById(R.id.btEt)
        etAddress = findViewById(R.id.addrEt)
        etPhoneNum = findViewById(R.id.telpEt)
        etOwner = findViewById(R.id.ownerEt)
        btnSaveProf = findViewById(R.id.btnSaveProf)

        dbRef = FirebaseDatabase.getInstance().getReference("Bussiness")
    }

    private fun saveBussinessData(){

        //get value
        val bsName = etBsName.text.toString()
        val bsType = etBsType.text.toString()
        val address = etAddress.text.toString()
        val phoneNum = etPhoneNum.text.toString()
        val owner = etOwner.text.toString()


    }
}