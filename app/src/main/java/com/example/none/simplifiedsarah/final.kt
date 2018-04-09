package com.example.none.simplifiedsarah

import android.graphics.Color
import com.example.none.simplifiedsarah.FSA
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.final_activity.*
import org.w3c.dom.Text

class final : AppCompatActivity()
{

    var x :String = ""

    var sbs :String = ""

    var eq :String = ""

    var warning :String = ""

    var ls :String = ""

    lateinit var poly :Array<String>

    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.final_activity)

        var extras: Bundle = intent.extras

        if (extras != null)
        {

            x = extras["x"].toString()
            sbs = extras["sbs"].toString()
            eq = extras["eq"].toString()
            ls = extras["ls"].toString()

            poly = extras["poly"] as Array<String>

            poly.reverse()

            var ts :String = ""
            var i :Int = ls.toInt()
            while(i >= 0)
            {


                if(poly[i].toDouble() != 0.0)
                {
                    if(i == 0) ts += " " + poly[i]
                    else ts += poly[i]+" x^${i}  + "

                }

                i--

            }

            gimme_finaleq.text = ts + " : " + eq

            i = ls.toInt()
            var z :Int = 0

            var ft :MutableList<String> = mutableListOf<String>()


            if(ls.toInt() == 9999)
            {

                var tv :TextView = TextView(this)
                tv.textSize = 16f
                tv.setTextColor(Color.BLACK)

            }
            else
            {


                while(i >= 0)
                {

                    var tv :TextView = TextView(this)
                    tv.textSize = 16f
                    tv.setTextColor(Color.BLACK)
                    if(sbs == "check") tv.visibility = View.VISIBLE
                    else tv.visibility = View.INVISIBLE

                    if(i == 1)
                    {

                        tv.text = "c = ($x * ${ft[z-1]}) + ${poly[i]} == ${x.toDouble() * ft[z-1].toDouble() + poly[i].toDouble()}"
                        ft.add((x.toDouble() * ft[z-1].toDouble() + poly[i].toDouble()).toString())
                        z++
                        Ll_final.addView(tv)
                        i--
                        continue

                    }
                    if(i == 0)
                    {

                        tv.text = "reszta = ${x.toDouble() * ft[z-1].toDouble() + poly[i].toDouble()}"
                        Ll_final.addView(tv)
                        if(x.toDouble() * ft[z-1].toDouble() + poly[i].toDouble() != 0.0) warning = "reszta jest != 0 (${x.toDouble() * ft[z-1].toDouble() + poly[i].toDouble()}). Podany wielomian nie jest podzielny przez $eq"
                        i--
                        continue

                    }

                    if(i == ls.toInt())
                    {

                        tv.text = "x^${i-1} = ${poly[i]}"
                        ft.add(poly[i])
                        z++
                        Ll_final.addView(tv)

                    }
                    else
                    {

                        tv.text = "x^${i-1} = ($x * ${ft[z-1]}) + ${poly[i]} == ${x.toDouble() * ft[z-1].toDouble() + poly[i].toDouble()}"
                        ft.add((x.toDouble() * ft[z-1].toDouble() + poly[i].toDouble()).toString())
                        z++
                        Ll_final.addView(tv)

                    }

                    i--

                }

            }

            if(warning == "")
            {

                var tempstr :String = ""

                for(x in ft) //Zdran
                {

                    if(z > 1)
                    {

                        if(x.toDouble() != 0.0)
                        {

                            if(x.toDouble() == 1.0) tempstr += "x^${z-1} + "
                            else tempstr += "${x}x^${z-1}"//csoema
                        }
                        z--

                    }
                    else
                    {

                        tempstr += "$x"
                        z--

                    }

                }

                gimme_eqfin.text = " WYNIK: " + tempstr

            }
            else
            {

                gimme_eqfin.text = warning

            }

        }

    }

}

