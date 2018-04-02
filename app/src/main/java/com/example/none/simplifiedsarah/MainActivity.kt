package com.example.none.simplifiedsarah

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun Butt_Next(v : View)
    {

        var warning :String = ""

        var x :Int = 0

        for(i in ET_1.text.toString().toLowerCase().trim())
        {

            if ((i == 'x') || (i in '0'..'9') || (i == '/') || (i == '-') || (i == '+') || (i == '.'))
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

            if ((i == 'x') || (i in '0'..'9') || (i == '/') || (i == '-') || (i == '+') || (i == '.'))
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

        if (x != 1) warning += "Podałeś za dużo lub za mało x \n"

        if (warning == "")
        {

            gimme_div.text = "Wszystko jest dobrze można kontynuować"

            var a :String = ET_1.text.toString().trim()
            var b :String = ET_2.text.toString().trim()

            if (Butt_PM.text == "-")
            {

                when(b[0])
                {

                    '-' -> { b = b.drop(1)}

                }

                gimme_div.text = b

            }

            if (Switch_SBS.isChecked) gimme_div.text = "CHECKED" else gimme_div.text = "Wszyqweqewqeqwewqe"

            RageKage()


        }
        else
        {

            gimme_div.text = warning
            warning = ""

        }


    }

}
