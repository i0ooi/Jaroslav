package com.example.signin


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.signin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var avatarUser:Int =0
    lateinit var nameUser: String
    lateinit var passwordUser : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

//Jarik
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Constance.rqReg){
            nameUser = data?.getStringExtra(Constance.login)!!
            avatarUser = data.getIntExtra(Constance.avatarID, R.drawable.ava2)
            passwordUser = data.getStringExtra(Constance.password)!!

            binding.userAva.setImageResource(avatarUser)
            binding.textView.text = "Welcome $nameUser!"

        }else if (requestCode == Constance.rqLog){
            val passwordTry = data?.getStringExtra(Constance.password)
            if (passwordTry==passwordUser){
                binding.userAva.setImageResource(avatarUser)
                binding.textView.text = "Hello $nameUser!"
            }else{
                binding.textView.visibility= View.INVISIBLE
                binding.userAva.visibility=View.INVISIBLE
                Toast.makeText(this, R.string.error_account,Toast.LENGTH_LONG).show()
            }


        }




    }




    fun openActivityREG(view:View){
        val intent = Intent(this, LogRegActivity::class.java)
        intent.putExtra(Constance.stateRegLog,Constance.stateReg)
        startActivityForResult(intent,Constance.rqReg)
    }
    fun openActivityLOG(view: View){
        val intent = Intent(this,LogRegActivity::class.java)
        intent.putExtra(Constance.stateRegLog,Constance.stateLog)
        startActivityForResult(intent, Constance.rqLog)
    }
}