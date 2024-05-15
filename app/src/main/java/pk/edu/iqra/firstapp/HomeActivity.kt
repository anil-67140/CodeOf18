package pk.edu.iqra.firstapp

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import pk.edu.iqra.firstapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private val KEY_COUNTER = "counter"
    private var counter = 0
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)

        /*binding.counterButton.setOnClickListener {
            binding.counterTextView.text = "${++counter}"
        }*/
        val isCounterExists = savedInstanceState?.containsKey(KEY_COUNTER)?:false
        if(isCounterExists){
            counter = savedInstanceState?.getInt(KEY_COUNTER)?:0
            setCounterValue()
        }
        /*binding.apply {
            counterButton.setOnClickListener {
                counterTextView.text = "${++counter}"
            }
        }*/

        binding.counterButton.setOnClickListener(MyClickHandler(this))
    }

    fun doIncrement(){
        ++counter
    }

    fun setCounterValue() {
        binding.counterTextView.text = "${counter}"
    }

    class MyClickHandler(var activity: HomeActivity): View.OnClickListener {
        override fun onClick(p0: View?) {
            activity.doIncrement()
            activity.setCounterValue()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(KEY_COUNTER,counter)
        super.onSaveInstanceState(outState)
    }
}