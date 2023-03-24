package com.example.personalinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    var fieldName: EditText? = null
    var fieldAdress: EditText? = null
    var fieldTel: EditText? = null
    var fieldMail: EditText? = null
    var fieldDoc: EditText? = null
    var fieldAge: EditText? = null
    var fieldInfo: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnInfo:Button= findViewById(R.id.btnInfo)
        btnInfo.setOnClickListener{onClick()}


        fieldName = findViewById(R.id.fieldName)
        fieldAdress = findViewById(R.id.fieldAdress)
        fieldTel = findViewById(R.id.fieldTel)
        fieldMail = findViewById(R.id.fieldMail)
        fieldDoc = findViewById(R.id.fieldDoc)
        fieldAge = findViewById(R.id.fieldAge)
        fieldInfo=findViewById(R.id.fieldInfo)

    }

    private fun onClick(){
        val age : Int = fieldAge!!.text.toString().toInt()
        var typePerson : String? = null

        if (age<0)
            Toast.makeText(this, "Ingrese Una Edad Valida", Toast.LENGTH_LONG).show()
        else{
            if (age>=0 || age<15){
                typePerson = "Infante"
            }
            else if (age>=15 || age <18){

                typePerson = "Adolescente"
                }
            else if (age>=18 || age <65){
                typePerson = "Adulto"
            }
            else{
                typePerson = "Adulto mayor"
            }
            showInfo(age, typePerson)
        }

    }
    private fun  showInfo(age: Int, typePerson: String?) {
        val name : String= fieldName!!.text.toString()
        val adress : String= fieldAdress!!.text.toString()
        val tel : String= fieldTel!!.text.toString()
        val mail : String= fieldMail!!.text.toString()
        val doc: String=fieldDoc!!.text.toString()
        fieldInfo?.text= " Nombre: ${name} \n Direccion: ${adress} \nTelefono: ${tel} \n Email: ${mail} \n Documento: ${doc}\n Edad: ${age} \n Persona: ${typePerson}"

        Toast.makeText(this, "Bienvenido ${name}, edad ${age} años, $typePerson", Toast.LENGTH_LONG).show()
    }

}