package com.example.pr4_demo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var input_ref_browser: EditText
    lateinit var input_ref_call:EditText
    lateinit var input_ref_alarm:EditText


    lateinit var btn_ref_browser:Button
    lateinit var btn_ref_contact:Button
    lateinit var btn_ref_call_log:Button
    lateinit var btn_ref_call:Button
    lateinit var btn_ref_alerm:Button
    lateinit var btn_ref_camera:Button
    lateinit var btn_ref_gallery:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input_ref_browser = findViewById(R.id.input_browser)
        input_ref_call = findViewById(R.id.input_call)
        input_ref_alarm = findViewById(R.id.input_alarm)


        btn_ref_browser = findViewById(R.id.btn_browser)
        btn_ref_contact = findViewById(R.id.btn_contact)
        btn_ref_call_log = findViewById(R.id.btn_call_log)
        btn_ref_call = findViewById(R.id.btn_call)
        btn_ref_alerm = findViewById(R.id.btn_openAlarm)
        btn_ref_camera = findViewById(R.id.btn_camera)
        btn_ref_gallery = findViewById(R.id.btn_gallery)

        implicitIntent()
    }
    fun implicitIntent(){

        btn_ref_browser.setOnClickListener {
            val message: String = input_ref_browser.getText().toString()
            val i1 = Intent(Intent.ACTION_VIEW, Uri.parse(message))
            startActivity(i1)
        }

        btn_ref_call.setOnClickListener {
            val message: String = input_ref_call.getText().toString()
            val call = "tel:$message"
            val i2 = Intent(Intent.ACTION_DIAL,Uri.parse((call)))
            startActivity(i2)
        }

        btn_ref_contact.setOnClickListener {
            val contactList = "content://contacts/people/"
            val i3: Intent = Intent(Intent.ACTION_VIEW, Uri.parse(contactList))
            startActivity(i3)
        }

        btn_ref_call_log.setOnClickListener {
            val i4: Intent = Intent(Intent.ACTION_VIEW)
            i4.setType(CallLog.Calls.CONTENT_TYPE)
            startActivity(i4)
        }

        btn_ref_gallery.setOnClickListener {
            val i5: Intent = Intent(Intent.ACTION_VIEW)
            i5.setType("image/*");
            startActivity(i5)
        }

        btn_ref_camera.setOnClickListener {
            val i6 = Intent("android.media.action.IMAGE_CAPTURE")
            startActivity(i6)
        }

        btn_ref_alerm.setOnClickListener {
            val i7:Intent = Intent(AlarmClock.ACTION_SHOW_ALARMS)
            startActivity(i7)
        }
    }
}