package com.example.none.simplifiedsarah

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import com.example.none.simplifiedsarah.R.id.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.sbs_rk_activity.*

/**
 * Created by none on 02.04.18.
 */
class RageKage :AppCompatActivity()
{

    var x :Float = 0f

    var eq :String = ""

    var sbs :String = ""

    override fun onCreate(savedInstanceState: Bundle?)
    {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.sbs_rk_activity)

        var extras :Bundle = intent.extras



        if(extras != null)
        {

            var a :String = extras["a"].toString()
            var b :String = extras["b"].toString()
            sbs = extras["sbs"].toString()
            var visi :Int
            var equa = ""


            if (sbs == "false") {visi = View.INVISIBLE} else {visi = View.VISIBLE; sbs = "check"}

            if(a.contains('x')){equa = "W(x) = ($a) + ($b)"; eq = "($a) + ($b)"}
            else {b = extras["a"].toString(); a = extras["b"].toString(); equa = "W(x) = ($b) + ($a)"; eq = "($b) + ($a)"}

            gimme_equa.text = equa



            a = a.substring(0, a.length).reversed()

            var tempstr :String = "" //anoth mirclnth e scree



            for(c in a)
            {

                if(c != 'x') tempstr += c

            }

            a = tempstr.reversed()

            gimme_SBS1.visibility = View.INVISIBLE
            gimme_SBS2.visibility = View.INVISIBLE
            gimme_SBS3.visibility = View.INVISIBLE

            Butt_SBS1.visibility = visi
            Butt_SBS2.visibility = visi
            Butt_SBS3.visibility = visi

            when(a)
            {

                "" -> //sun no lng sets mfr
                {

                    gimme_result.text = "x = " + (b.toInt() * -1).toString()
                    x = (b.toFloat() * -1)

                    gimme_SBS1.text = "0 = x + $b / - (x)"
                    gimme_SBS2.text = "-x = $b / *(-1)"
                    gimme_SBS3.text = "x = ${b.toInt() * -1}"

                }

                "-" ->
                {

                    gimme_result.text = "x = " + b
                    x = b.toFloat()

                    gimme_SBS1.text = "0 = -x + $b / + (x)"
                    gimme_SBS2.text = "x = $b"
                    Butt_SBS3.visibility = View.INVISIBLE
                    gimme_SBS3.visibility = View.INVISIBLE

                }

                else ->
                {

                    gimme_SBS1.text = "0 = ${a}x + $b / + (${a.substring(0, a.length).toFloat() * -1}x)"
                    gimme_SBS2.text = "${a.substring(0, a.length).toFloat() * -1}x = $b / : (${a.substring(0, a.length).toFloat() * -1})"
                    gimme_SBS3.text = "x = ${b.toFloat() / a.substring(0, a.length).toFloat() * - 1}"
                    gimme_result.text = "x = ${b.toFloat() / a.substring(0, a.length).toFloat() * - 1}"
                    x = b.toFloat() / a.substring(0, a.length).toFloat() * - 1

                }

            }

        }//F10 5O50.4

    }

    fun Butt_SBS1(v :View)
    {

        gimme_SBS1.visibility = View.VISIBLE

    }

    fun Butt_SBS2(v :View)
    {

        gimme_SBS2.visibility = View.VISIBLE

    }

    fun Butt_SBS3(v :View)
    {

        gimme_SBS3.visibility = View.VISIBLE

    }

    fun Butt_RK(v :View)
    {

        val RK_intent = Intent(this, Jab::class.java)

        RK_intent.putExtra("x", x)
        RK_intent.putExtra("sbs", sbs)
        RK_intent.putExtra("eq", eq)

        startActivity(RK_intent)

    }

}

//0222123320220240430020023022