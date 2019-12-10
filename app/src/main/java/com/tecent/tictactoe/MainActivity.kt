package com.tecent.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var currentPlayer=1
    private var values= intArrayOf(0,0,0,0,0,0,0,0,0)
    var stopGame=false
    var moves=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resetGame()
        iv1.setOnClickListener { setValue(iv1,0) }
        iv2.setOnClickListener { setValue(iv2,1) }
        iv3.setOnClickListener { setValue(iv3,2) }
        iv4.setOnClickListener { setValue(iv4,3) }
        iv5.setOnClickListener { setValue(iv5,4) }
        iv6.setOnClickListener { setValue(iv6,5) }
        iv7.setOnClickListener { setValue(iv7,6) }
        iv8.setOnClickListener { setValue(iv8,7) }
        iv9.setOnClickListener { setValue(iv9,8) }
    }

    private fun setValue(view: TextView,int: Int){
        if (stopGame) {
            Toast.makeText(this,"Reset",Toast.LENGTH_SHORT).show()
            resetGame()
            return
        }
        if (view.text!="")
            return
        moves++
        if(currentPlayer==1) {
            view.text = "X"
            currentPlayer=2
            values[int]=1
        }
        else if(currentPlayer==2) {
            view.text = "O"
            currentPlayer=1
            values[int]=-1
        }
        if (verifyWin()){
            if (currentPlayer==1)
                Toast.makeText(this,"Player 2 is winner. Tap again to reset.",Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this,"Player 1 is winner. Tap again to reset.",Toast.LENGTH_LONG).show()
            stopGame=true
        }else if(moves==9){
            stopGame=true
            Toast.makeText(this,"The game is draw. Tap again to reset.",Toast.LENGTH_LONG).show()
        }
    }


    fun verifyWin():Boolean{
        return (Math.abs(values[0]+values[1]+values[2])==3)||
                (Math.abs(values[3]+values[4]+values[5])==3)||
                (Math.abs(values[6]+values[7]+values[8])==3)||
                (Math.abs(values[0]+values[3]+values[6])==3)||
                (Math.abs(values[1]+values[4]+values[7])==3)||
                (Math.abs(values[2]+values[5]+values[8])==3)||
                (Math.abs(values[0]+values[4]+values[8])==3)||
                (Math.abs(values[2]+values[4]+values[6])==3)
    }




    private fun resetGame(){
        stopGame=false
        moves=0
        values= intArrayOf(0,0,0,0,0,0,0,0,0)
        iv1.text=""
        iv2.text=""
        iv3.text=""
        iv4.text=""
        iv5.text=""
        iv6.text=""
        iv7.text=""
        iv8.text=""
        iv9.text=""
    }
}
