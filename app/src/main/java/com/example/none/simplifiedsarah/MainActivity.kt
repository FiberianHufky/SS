package com.example.none.simplifiedsarah

import android.app.Application
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import java.lang.Math.sqrt


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun calc(num :String) :String
    {


        var i :Int = 0
        var x :Boolean = true
        var z :Int = 0

        var tempstr :String = ""

        for (c in num)
        {

            if(c != 'x') {tempstr += c; x = false}

        }

        while(i < tempstr.length)
        {


            if(tempstr[i] == '/')
            {

                var a :String = ""
                var b :String = ""

                while (z < i)
                {


                    a += tempstr[z]

                    z++


                }

                z = i+1

                while (z < tempstr.length)
                {


                    b += tempstr[z]

                    z++


                }

                if (a.contains('s') || a.contains('/')) a = calc(a)
                if (b.contains('s') || b.contains('/')) b = calc(b)

                tempstr = (a.toFloat() / b.toFloat()).toString()

                if (x == true) return( tempstr + 'x')
                else return(tempstr)

            }

            z = 0

            if(tempstr[i] == 's')
            {

                var a :String = ""

                z = i + 1

                while (z < tempstr.length)
                {


                    a += tempstr[z]

                    z++


                }

                if (a.contains('s') || a.contains('/')) a = calc(a)

                tempstr = Math.sqrt(a.toDouble()).toString()

                if (x == true) return(tempstr + 'x')
                else return(tempstr)


            }

            i++

        }

        return(tempstr)

    }


    fun Butt_Next(v : View)
    {

        var warning :String = ""

        var x :Int = 0

        for(i in ET_1.text.toString().toLowerCase().trim())
        {

            if ((i == 'x') || (i in '0'..'9') || (i == '/') || (i == '-') || (i == '+') || (i == '.') || (i == 's'))
            {

                gimme_div.text = "Dobrze"

                if (i == 'x') x++

            }
            else
            {

                warning += "W pierwszym polu jest niedozwolony znak \n"
                break

            }

        }

        for(i in ET_2.text.toString().toLowerCase().trim())
        {

            if ((i == 'x') || (i in '0'..'9') || (i == '/') || (i == '-') || (i == '+') || (i == '.')  || (i == 's'))
            {

                gimme_div.text = "Dobrze"

                if (i == 'x') x++

            }
            else
            {

                warning += "W drugim polu jest niedozwolony znak \n"
                break

            }

        }


        if(ET_1.text.toString().toLowerCase().trim() == "0x" || ET_2.text.toString().toLowerCase().trim() == "0x") warning += "0x + ... nie jest wielomianem 1-go stopnia"

        if (x != 1) warning += "Podałeś za dużo lub za mało x \n"

        if (warning == "")
        {

            gimme_div.text = "Wszystko jest dobrze można kontynuować"

            var a :String = ET_1.text.toString().trim()
            var b :String = ET_2.text.toString().trim()

            a = calc(a)
            b = calc(b)

            if (Butt_PM.text == "-")
            {

                when(b[0])
                {

                    '-' -> { b = b.drop(1)}
                    else -> {b = (b.toFloat() * -1).toString()}

                }

                gimme_div.text = b

            }

            val intent = Intent(this, RageKage::class.java)

            intent.putExtra("a", a)
            intent.putExtra("b", b)
            intent.putExtra("sbs", Switch_SBS.isChecked)

            startActivity(intent) //start RageKage

            if (Switch_SBS.isChecked) gimme_div.text = "CHECKED" else gimme_div.text = "Wszyqweqewqeqwewqe"

        }
        else
        {

            gimme_div.text = warning
            warning = ""

//            val intent = Intent(this, RageKage::class.java)
//
//            intent.putExtra("a", "23")
//            intent.putExtra("b", "123x")
//            intent.putExtra("sbs", Switch_SBS.isChecked)
//
//
//            startActivity(intent)

        }


    }

}
