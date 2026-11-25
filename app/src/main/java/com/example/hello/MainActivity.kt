package com.example.hello

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tv = TextView(this).apply {
            text = "Hello from cloud build\n构建成功"
            textSize = 22f
            setPadding(48, 96, 48, 48)
        }
        setContentView(tv)
    }
}
