package rpek.simplecaculation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isNewOp=true
    var oldNumber:Int?=null
    var newNumber: Int?=null
    var op:String?="*"
    var result:Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun callEventCal(view:View) {
        if(isNewOp){
            edDisplayValue.setText("")
        }
        isNewOp=false

        var selectButton: Button = view as Button
        var tvDisplay=edDisplayValue.text.toString()



        var btnClickValue: String = tvDisplay

        when (selectButton.id) {
            btnZero.id -> {
                if(tvDisplay.length>0) {
                    if(!tvDisplay[0].equals("0")){
                        btnClickValue += "0"
                    }
                }

            }
            btnOne.id -> btnClickValue += "1"
            btnTwo.id -> btnClickValue += "2"
            btnThree.id -> btnClickValue += "3"
            btnFour.id -> btnClickValue += "4"
            btnFive.id -> btnClickValue += "5"
            btnSix.id -> btnClickValue += "6"
            btnSeven.id -> btnClickValue += "7"
            btnEight.id -> btnClickValue += "8"
            btn9.id -> btnClickValue +="9"
            btnDot.id -> btnClickValue += "."

            btnAC.id -> {
                btnClickValue = ""
                edDisplayValue.setText(btnClickValue)
            }
        }
        edDisplayValue.setText(btnClickValue)
    }

    fun callEventOperation(view: View) {
        var selectButton: Button = view as Button
        when (selectButton.id) {
            btnPlus.id -> op="+"
            btnMinus.id-> op="-"
            btnDivide.id -> op="/"
            btnMulti.id-> op="*"
        }
        if(!edDisplayValue.text.toString().equals("")) {
            oldNumber = edDisplayValue.text.toString().toInt()
        }
        edDisplayValue.setText("")
    }

    fun callEventEqual(view:View){
        if(!edDisplayValue.text.toString().equals("")) {

             newNumber= edDisplayValue.text.toString().toInt()
            when (op) {
                "+" -> result = oldNumber!!.plus(newNumber!!)
                "-" -> result = oldNumber!!.minus(newNumber!!)
                "/" -> result = oldNumber!!.div(newNumber!!)
                "*" -> result = oldNumber!!.times(newNumber!!)
            }
            edDisplayValue.setText(result.toString())
            isNewOp = true
        }
    }
}
