package com.example.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.accept
import android.system.Os.bind
import android.view.View
import android.widget.Toast
import com.example.signin.databinding.ActivityLogRegBinding

class LogRegActivity : AppCompatActivity() {
    var avatar= 0
    lateinit var binding: ActivityLogRegBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogRegBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.getStringExtra(Constance.stateRegLog)==Constance.stateReg){
            binding.btnAccept.setOnClickListener { acceptInfoREG() }
        }else if (intent.getStringExtra(Constance.stateRegLog)==Constance.stateLog){
            binding.radioGroup.visibility=View.GONE
            binding.ava1.visibility=View.GONE
            binding.ava2.visibility=View.GONE
            binding.ava3.visibility=View.GONE
            binding.etReply.visibility=View.GONE
            binding.btnAccept.setOnClickListener { acceptInfoLog() }
        }
    }
    fun acceptInfoREG(){
        if (binding.etPassword.text.toString() != binding.etReply.text.toString() || binding.etPassword.text.toString().length<5){
            Toast.makeText(this, R.string.pass_dont_match, Toast.LENGTH_SHORT).show()
            return
        }
        avatar = when (binding.radioGroup.checkedRadioButtonId){
            R.id.rAva1 -> R.drawable.ava1
            R.id.rAva2 -> R.drawable.ava2
            R.id.rAva3 -> R.drawable.ava3
            else -> 0
        }

        if (binding.etLogin.text.isEmpty()){
            Toast.makeText(this, R.string.no_log, Toast.LENGTH_SHORT).show()
            return
        }

        val intent= Intent()
        intent.putExtra(Constance.login,binding.etLogin.text.toString())
        intent.putExtra(Constance.password, binding.etPassword.text.toString())
        intent.putExtra(Constance.avatarID,avatar)
        setResult(RESULT_OK, intent)
        finish()


    }

    fun acceptInfoLog(){
        if (binding.etLogin.text.isEmpty()) {
            Toast.makeText(this, R.string.no_log, Toast.LENGTH_SHORT).show()
            return
        }
        intent.putExtra(Constance.login,binding.etLogin.text.toString())
        intent.putExtra(Constance.password,binding.etPassword.text.toString())
        setResult(RESULT_OK, intent)
        finish()
    }
}