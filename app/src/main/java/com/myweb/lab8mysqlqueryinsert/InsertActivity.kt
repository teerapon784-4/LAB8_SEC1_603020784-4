package com.myweb.lab8mysqlqueryinsert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_insert.*
import layout.student
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.security.auth.callback.Callback

class InsertActivity : AppCompatActivity() {

    override fun onCreate(savedIntanceState: Bundle?) {
        super.onCreate(savedIntanceState)
        setContentView(R.layout.activity_insert)
    }
    fun addStudent(v : View){

        val api : StudentAPI = Retrofit.Builder()
            .baseUrl( "http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StudentAPI ::class.java)

        api.insertStd(
            edt_id.text.toString(),
            edt_name.text.toString(),
            edt_age.text.toString().toInt()).enqueue(object : Callback<student> {

            override fun onResponse(call : Call<student>, response: retrofit2.Response<student>) {

                if (response.isSuccessful()) {

                    Toast.makeText(applicationContext, "Successfully Inserted", Toast.LENGTH_SHORT).show()
                    finish()

                }else{
                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call : Call<student>, t: Throwable) {
                Toast.makeText(applicationContext, "Error onFailure " + t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun resetStudent(v : View) {

        edt_id.getText().clear()
        edt_name.getText().clear()
        edt_age.getText().clear()
    }
}