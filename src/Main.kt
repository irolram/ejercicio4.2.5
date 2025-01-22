
fun pedirTiempo(msj:String, aceptarVacio:Boolean = false):Int{
    var num:Int? = null
    do {
        print(msj)
        val entrada = readln().trim()
        if (aceptarVacio && entrada.isNotEmpty()){
            num = 0
        }else{
            try {
                num = entrada.toInt()
            }catch (e: NumberFormatException){
                println("Número no valido")
            }
        }

    }while (num == null)
    return num
}


fun main(){

   // val hora = pedirTiempo("Introduzca la hora")
    //val minuto = pedirTiempo("Introduzca los min")
    //val segundo = pedirTiempo("Introduzca los seg")
    val tiempo1 = Tiempo(12, 51,6)
    tiempo1.decrementar(Tiempo(1,2,3))
    println(tiempo1)
}