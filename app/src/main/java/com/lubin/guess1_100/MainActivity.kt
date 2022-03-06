package com.lubin.guess1_100

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.lubin.guess1_100.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    val secretNumber=SecretNumber()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //binding.edNumber.setText("70")
        Log.d("MainActivity","secret"+secretNumber.secret)
    }
    fun check(view: View){//Please select "app" to run your project.
        val n=ed_number.text.toString().toInt()//將可編輯的類別的文字轉成字串再將他轉成整數放入n
        println("number:$n")
        Log.d("MainActivity","number:" +n)
        val diff=secretNumber.validate(n)
        var message = "Yeah,you guess right!"
        if(diff<0){//if(secretNumber.validate(n)<0)為使之簡化，可另外做暫存
            message = "Bigger" //Toast.makeText(this,"Bigger",Toast.LENGTH_LONG).show()
        }
        else if(diff>0){
            message = "Smaller"//Toast.makeText(this,"Smaller",Toast.LENGTH_LONG).show()
        }
        //Toast.makeText(this,message,Toast.LENGTH_LONG).show()
        //Toast.makeText(this,"Yeah,you guess right!",Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)
            .setTitle("Messasge")
            .setMessage(message)
            .setPositiveButton("Try again",null)
            .show()
    /*var min = 1
        var max = 100
        val secret = Random.nextInt(min,max)//隨機找出min-max中的一個整數值
        var guess = 0
        var count = 0
        while(secret!=guess){
            println("Please input your number $min to $max")
            readLine()?.let {
                guess = it.toInt()
                if(guess>secret) {
                    guess=binding.edButton.text.toString().toInt()
                    min=guess
                    Log.d("smaller",min.toString())
                    count++
                }else if(guess<secret) {
                    guess=binding.edNumber.text.toString().toInt()
                    max=guess
                    Log.d("bigger",max.toString())
                    count++
                }
                else{
                    guess=binding.edNumber.text.toString().toInt()
                    Log.d("You got it!",guess.toString())
                }
            }
            break
        }*/
    }
}