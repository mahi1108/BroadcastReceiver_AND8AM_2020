package cubex.mahesh.broadcastreceiver_and8am_2020

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var iFilter = IntentFilter()
        iFilter.addAction(Intent.ACTION_POWER_CONNECTED)
        iFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        iFilter.addAction(Intent.ACTION_SCREEN_ON)
        iFilter.addAction(Intent.ACTION_SCREEN_OFF)
        iFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        iFilter.addAction("and8am_nit_action")
        registerReceiver(MyReceiver(textView),iFilter)


        myevent.setOnClickListener {
            var i = Intent()
            i.setAction("and8am_nit_action")
            i.putExtra("text","My Own Event is triggered....")
            sendBroadcast(i)
        }
    }

      class MyReceiver(var textView: TextView) : BroadcastReceiver()
      {
          override fun onReceive(context: Context?, intent: Intent?) {
              textView.setText(intent?.action)
              if(intent?.action.equals("and8am_nit_action")){
                  textView.setText(intent?.getStringExtra("text"))
              }
          }
      }
}
