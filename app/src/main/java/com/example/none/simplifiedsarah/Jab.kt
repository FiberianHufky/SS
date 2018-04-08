package com.example.none.simplifiedsarah

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Adapter
import android.widget.LinearLayout.HORIZONTAL
import kotlinx.android.synthetic.main.jab_activity.*
import com.example.none.simplifiedsarah.FSA


class Jab : AppCompatActivity()
{

    var cg :Boolean = false

    var s :Int = 0

    var ls :Int = 0

    var x :String = ""

    var sbs :String = ""

    var eq :String = ""

    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.jab_activity)

        var extras :Bundle = intent.extras

        if(extras != null)
        {

            x = extras["x"].toString()
            sbs = extras["sbs"].toString()
            eq = extras["eq"].toString()

        }


    }

    fun Butt_genpoly(v :View)
    {

        if(cg == false)
        {

            cg = true

            var num :Int = 0

            var poly :Int = (ET_poly.text.toString()).toInt()

            if(poly > 1 && poly < 15)
            {

                num = poly
                s = poly
                ls = poly


                while(num >= 0)
                {

                    if(num != 0)
                    {

                        var ll = LinearLayout(this)
                        var tv = TextView(this) //whn y'r off thi litlma hin hasno moe hrt thaabr ain
                        var plus = TextView(this)
                        var ev = EditText(this) //hannah
                        tv.text = "x^$num"
                        ev.id = num
                        plus.text = "   +   "
                        ll.orientation = HORIZONTAL
                        ll.addView(ev)
                        ll.addView(tv)
                        ll.addView(plus)
                        Ll_poly.addView(ll)
                        num--

                    }
                    else
                    {

                        var ll = LinearLayout(this)
                        var tv = TextView(this)
                        var ev = EditText(this)
                        tv.hint = "c"
                        ev.id = num
                        ll.orientation = HORIZONTAL
                        ll.addView(tv)
                        ll.addView(ev)
                        Ll_poly.addView(ll)
                        num--

                    }

                }

            }

        }

    }

    fun Butt_subm(v :View)
    {

        var tab :MutableList<String> = mutableListOf<String>()
        var tev = EditText(this)
        var tstr :String = ""
        while(s >= 0)
        {

            tev = findViewById(s)
            tstr = tev.text.toString()
            tstr.trim().toLowerCase()
            if(tstr != "") tab.add(FSA.FTF(tstr))
            else tab.add("0")
            s--

        }

        var warning = ""

        if(tab.first() == "0" ||tab.first() == "0.0" || tab.last() == "0" ||tab.last() == "0.0")
        {

            warning = "pierwsze i ostatnie pola muszą być != 0"

        }
        else
        {

            val JB_intent = Intent(this, final::class.java)

            var arr :Array<String> = tab.toTypedArray()

            JB_intent.putExtra("poly", arr)
            JB_intent.putExtra("sbs", sbs)
            JB_intent.putExtra("x", x)
            JB_intent.putExtra("eq", eq)
            JB_intent.putExtra("ls", ls)

            startActivity(JB_intent)

        }

        tstr = ""

        for(i in tab) tstr += i + "  "
        gimme_poly.text = tstr

    }

 }