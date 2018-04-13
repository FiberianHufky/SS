package com.example.none.simplifiedsarah

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.chart_activity.*

class chart :AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {

        var extras: Bundle = intent.extras

        var ts :String= ""

        if(extras != null)
        {

            var arr :Array<String> = extras["ft"] as Array<String>
            var ls :String = extras["ls"] as String

            var draw = DrawChart(this, arr, ls)
            super.onCreate(savedInstanceState)
            setContentView(draw)

        }


    }



}

