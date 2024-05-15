package pk.edu.iqra.firstapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity()/*, View.OnClickListener*/ {
    private lateinit var myTextView:TextView
    private lateinit var myButton:Button
    private lateinit var myButton2:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val myTextView = findViewById<TextView>(R.id.my_text_view)
        val myButton = findViewById<Button>(R.id.my_button)*/

        myTextView = findViewById(R.id.my_text_view)
        myButton = findViewById(R.id.my_button)
        myButton2 = findViewById(R.id.my_button_2)

        /*myButton.setOnClickListener {
            myTextView.text = "Hello World Text Updated!"
        }*/

        /*myButton.setOnClickListener(this)
        myButton2.setOnClickListener(this)*/

        myButton.setOnClickListener(MyClickHandler(this))
        myButton2.setOnClickListener(MyClickHandler(this))
    }

    /*override fun onClick(p0: View?) {
        if(p0?.id == R.id.my_button){
            myTextView.text = "Hello World Text Updated!"
        }
        else if(p0?.id == R.id.my_button_2){
            myTextView.text = "Hello World!"
        }
    }*/

    class MyClickHandler(var activity:MainActivity) : View.OnClickListener {
        override fun onClick(p0: View?) {
            /*if(p0?.id == R.id.my_button){
                activity.myTextView.text = "Hello World Text Updated!"
            }
            else if(p0?.id == R.id.my_button_2){
                activity.myTextView.text = "Hello World!"
            }*/
            when(p0?.id){
                R.id.my_button -> activity.myTextView.text = "Hello World Text Updated!"
                R.id.my_button_2 -> activity.myTextView.text = "Hello World!"
            }
        }
    }
}