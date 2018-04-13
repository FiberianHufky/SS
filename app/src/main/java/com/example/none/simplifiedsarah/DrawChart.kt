package com.example.none.simplifiedsarah

import android.content.Context

import android.graphics.Canvas

import android.graphics.Color

import android.graphics.Paint

import android.view.View
import java.lang.Math.pow


class DrawChart(context: Context, var arr :Array<String>, var ls :String) : View(context)
{

    var nls = ls
    var narr = arr

    var paint :Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = Color.BLACK
        paint.strokeWidth = 5f
        var i = 0f

        canvas?.drawLine(10f, 550f, 710f, 550f, paint)
        canvas?.drawLine(360f, 190f, 360f, 880f, paint)
        while(i <= 700)
        {
            canvas?.drawLine(350f, 190f + i, 370f, 190f + i, paint)
            canvas?.drawLine(0f + i, 540f, 0f + i, 560f, paint)
            i+=30

        }

        i = 0f

        paint.strokeWidth = 1f
        paint.color = Color.BLUE

        while(i <= 700)
        {
            canvas?.drawLine(0f, 190f + i, 720f, 190f + i, paint)
            canvas?.drawLine(0f + i, 190f, 0f + i, 880f, paint)
            i+=30

        }

        var x = -40f

        paint.strokeWidth = 10f
        paint.color = Color.BLACK

        var lx :Float = 0f
        var ly :Float = 190f

        while(x <= 40f)
        {
            var counter :Float = nls.toFloat() -1
            var y :Float = 0f

            while(counter >= 0f)
            {

                if(counter == 0f)
                {

                    y += narr[counter.toInt()].toFloat()

                }
                else
                {

                    var p = pow(x.toDouble(), counter.toDouble())
                    var z = narr[counter.toInt()].toFloat()
                    y += (p * z).toFloat()

                }

                counter--

            }

            if (y <= 80 && y >= -80)
            {

                canvas?.drawLine(lx * 10 + 1, y * 10 + 1, lx * 10 - 1, y * 10 - 1, paint)

            }

            lx++
            ly = y

            x++

        }

    }

}
