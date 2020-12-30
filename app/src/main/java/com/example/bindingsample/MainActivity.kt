package com.example.bindingsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.example.bindingsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val liveText = MutableLiveData<String>()
    val liveVisible = MutableLiveData<Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            lifecycleOwner = this@MainActivity  // **중요** binding에 LifeCycleOwner을 지정해줘야 LiveData가 실시간으로 변화
            activity = this@MainActivity        // xml 파일에 선언한 activity

            btnChange1.setOnClickListener {
                liveVisible.value = true
            }
            btnChange2.setOnClickListener {
                liveVisible.value = false
            }
        }

        liveText.value = "Hello DataBinding!"
    }
}