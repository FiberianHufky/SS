package com.example.none.simplifiedsarah

import com.example.none.simplifiedsarah.FSA
import android.app.Application
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import java.lang.Math.sqrt


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun Butt_Next(v: View) {

        var warning: String = ""

        var x: Int = 0

        var dunbar: String = ET_1.text.toString().toLowerCase().trim()
        var walters: String = ET_2.text.toString().toLowerCase().trim()

        for (i in dunbar) {

            if ((i == 'x') || (i in '0'..'9') || (i == '/') || (i == '-') || (i == '*') || (i == '+') || (i == '.') || (i == 's') || (i == ')') || (i == '(')) {

                gimme_div.text = "Dobrze"

                if (i == 'x') x++

            } else {

                warning += "W pierwszym polu jest niedozwolony znak \n"
                break

            }

        }

        for (i in walters) {

            if ((i == 'x') || (i in '0'..'9') || (i == '/') || (i == '-') || (i == '*') || (i == '+') || (i == '.') || (i == 's') || (i == ')') || (i == '(')) {

                gimme_div.text = "Dobrze"

                if (i == 'x') x++

            } else {

                warning += "W drugim polu jest niedozwolony znak \n"
                break

            }

        }


        if (dunbar == "0x" || walters == "0x") warning += "0x + ... nie jest wielomianem 1-go stopnia"

        if (x != 1) warning += "Podałeś za dużo lub za mało 'x' \n"

        if (warning == "") {

            gimme_div.text = "Wszystko jest dobrze można kontynuować"

            if (dunbar.contains('x')) {

                if (dunbar != "x") {

                    dunbar.replace("x", "")
                    dunbar = FSA.FTF(dunbar)
                    dunbar += "x"

                }

            } else dunbar = FSA.FTF(dunbar)

            if (walters.contains('x')) {

                if (walters == "x") {

                    walters.replace("x", "")
                    walters = FSA.FTF(walters)
                    walters += "x"

                }

            } else walters = FSA.FTF(walters)

            val intent = Intent(this, RageKage::class.java)

            intent.putExtra("a", dunbar)
            intent.putExtra("b", walters)
            intent.putExtra("sbs", Switch_SBS.isChecked)

            startActivity(intent)

        } else {

            gimme_div.text = warning
            warning = ""

        }


    }
}

    ///////////////////////////////////////////////////////////////////////////////////////////////