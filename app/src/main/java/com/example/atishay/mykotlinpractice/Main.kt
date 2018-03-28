package com.example.atishay.mykotlinpractice

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.atishay.mykotlinpractice.R
import com.ideal.retrofitdemo.ApiInterface
import com.ideal.retrofitdemo.model.Category
import com.ideal.retrofitdemo.model.CategoryResponse
import kotlinx.android.synthetic.main.main.*
import retrofit2.Call
import retrofit2.Callback

class Main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)


        btnClick.setOnClickListener(View.OnClickListener {

            DisplayProgressDialog()
            callWebService()
        })

    }

    fun callWebService() {

        val apiService = ApiInterface.create()

        val call = apiService.getCategoryDetails()
        Log.d("REQUEST", call.toString() + "")
        call.enqueue(object : Callback<CategoryResponse> {
            override fun onResponse(call: Call<CategoryResponse>, response: retrofit2.Response<CategoryResponse>?) {
                if (response != null) {
                    if (pDialog != null && pDialog!!.isShowing()) {
                        pDialog.dismiss()
                    }

                    var list: List<Category> = response.body()?.categories!!

                    Log.d("MainActivity", "" + list.size)


                    var msg: String = ""
                    for (item: Category in list.iterator()) {

                        msg = msg + item.title + "\n"

                    }
                    Toast.makeText(this@Main, "List of Category  \n  " + msg, Toast.LENGTH_LONG).show()
                    txtDisplay.setText(msg + "")
                }

            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                //                Log.e(TAG, t.toString());
                if (pDialog != null && pDialog.isShowing()) {
                    pDialog.dismiss()
                }

            }
        })
    }


    lateinit var pDialog: ProgressDialog

    fun DisplayProgressDialog() {

        pDialog = ProgressDialog(this@Main)
        pDialog!!.setMessage("Loading..")
        pDialog!!.setCancelable(false)
        pDialog!!.isIndeterminate = false
        pDialog!!.show()
    }

}
