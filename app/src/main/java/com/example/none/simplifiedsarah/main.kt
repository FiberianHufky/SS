import java.lang.Math.pow
import kotlin.math.sqrt

fun larry (eq :MutableList<String>, paro :Int, parc :Int) :String
{

    var counter :Int = paro + 1

    var i :Int = 0

    var tempeq :MutableList<String> = mutableListOf<String>()

    var eqstr :String = ""

    print("Larry's fun: \n")

    while(counter < parc)
    {

        print(eq[counter] + "\n")
        if(eq[counter] == "+" || eq[counter] == "-") counter ++
        if(eq[counter] in "0".."9")
        {

            if(counter > paro + 1)
            {

                when(eq[counter - 1])
                {

                    "-" -> eqstr += "-"
                    else -> eqstr += "+"

                }

                eqstr += eq[counter]
                counter++
                while(eq[counter] in "0".."9")
                {

                    eqstr += eq[counter]
                    counter++

                }

            }
            else
            {

                eqstr += "+"

                while(eq[counter] in "0".."9")
                {

                    eqstr += eq[counter]
                    counter++

                }

            }

            tempeq.add(eqstr)

        }
        else
        {

            tempeq.add(eq[counter])
            counter++

        }

        eqstr = ""


    }

    for(c in tempeq)
    {

        println("tempeq: $c")

    }

    var tot :MutableList<String> = mutableListOf<String>()

    while(i <= tempeq.lastIndex)
    {

        when (tempeq[i])
        {

            "s" ->
            {

                tempeq[i] = sqrt(tempeq[i + 1].toFloat()).toString()
                tempeq.removeAt(i+1)
                i = 0


            }

            "^" ->
            {

                tempeq[i] = pow(tempeq[i - 1].toDouble(), tempeq[i + 1].toDouble()).toString()
                tempeq.removeAt(i+1)
                tempeq.removeAt(i-1)
                i = 0

            }

        }

        i++

    }


    i = 0

    while(i <= tempeq.lastIndex)
    {

        when(tempeq[i])
        {

            "*" ->
            {

                tempeq[i] = (tempeq[i - 1].toDouble() * tempeq[i + 1].toDouble()).toString()
                tempeq.removeAt(i+1)
                tempeq.removeAt(i-1)
                i = 0

            }

            "/" ->
            {

                tempeq[i] = (tempeq[i - 1].toDouble() / tempeq[i + 1].toDouble()).toString()
                tempeq.removeAt(i+1)
                tempeq.removeAt(i-1)
                i = 0

            }

        }

        i++

    }

    i = 0

    while(tempeq.lastIndex > 0)
    {

        tempeq[0] = (tempeq[0].toDouble() + tempeq[1].toDouble()).toString()
        tempeq.removeAt(1)

    }

    for (c in tempeq)
    {

        println("CHYBA DZIAŁA: $c")

    }

    return tempeq[0]

}




fun main(args :Array<String>)
{

    var a :String

    a="20-(-7)+13+(-2+20 + (s4))-1-(-3 * 20 * 2 )"
    a.decapitalize()
    a = a.replace("\\s".toRegex(), "")

    var eq = mutableListOf<String>()

    if (a != null)
    {

        for(c in a)
        {

         eq.add(c.toString())

        }

        var i :Int = 0
        var par :Int = 0
        var paro :Int = 0
        var parc :Int = 0

        asdf@ while(i <= eq.lastIndex)
        {

             when(eq[i])
            {


                "(" ->
                {

                    par++
                    paro = i
                    println("WHEN '(' par = $par   paro = $paro")

                }

                ")" ->
                {

                    par--
                    parc = i
                    var z :Int = 0
                    println("Sending to Larry: paro: $paro   parc: $parc")
                    //larry(eq, paro, parc)
                    for(c in eq)
                    {

                        print(c)

                    }
                    var tempeq :MutableList<String> = mutableListOf<String>()
                    while(z <= eq.lastIndex)
                    {


                        if(z == paro + 1) tempeq.add(larry(eq, paro, parc))
                        if(z < paro || z > parc) tempeq.add(eq[z])
                        z++

                    }

                    eq = tempeq
                    i = 0
                    continue@asdf

                }

            }

            i++

        }

        for(c in eq)
        {

            print(c)

        }

    }



}
