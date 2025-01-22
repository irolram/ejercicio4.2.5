class Tiempo(var hora:Int, var minuto:Int, var segundo:Int){

    constructor(hora: Int):this(hora,0,0)

    constructor(hora: Int, minuto: Int):this(hora)



    init {
        require(hora in 0..23 || hora == 24 && minuto == 0 && segundo == 0) {"hora no valida"}
        require(minuto >= 0){"Los minutos deben ser positivos"}
        require(segundo >= 0){"Los segundos deben ser positivos"}
        require(hora >= 0){"Las horas deben ser positivos"}


        if (segundo > 59){
            this.minuto += segundo / 60
            this.segundo %= 60
        }

        if (minuto >59){
            hora += minuto / 60
            this.minuto %= 60
        }


    }


    override fun toString(): String {
        return "${"%02d".format(hora)} h:${"%02d".format(minuto)} m:${"%02d".format(segundo)}s"
    }

    fun incrementar(t:Tiempo):Boolean {
        val nueva_hora = hora + t.hora
        val nuevo_minuto = minuto + t.minuto
        val nuevo_segundo = segundo + t.segundo
        if(nuevo_segundo in 0..59  && nuevo_minuto in 0..59 && nueva_hora in 0..23){
            hora = nueva_hora
            minuto = nuevo_minuto
            segundo = nuevo_segundo
            return true
        }else{
            return false
        }

    }

    fun decrementar(t:Tiempo):Boolean {
        val nueva_hora = hora - t.hora
        val nuevo_minuto = minuto - t.minuto
        val nuevo_segundo = segundo - t.segundo
        if(nueva_hora in 0..23 && nuevo_minuto in 0..59 && nuevo_segundo in 0..59){
            hora = nueva_hora
            minuto = nuevo_minuto
            segundo = nuevo_segundo
            return true
        }
        return false
    }

    fun copiar(): Tiempo {
        return Tiempo(hora, minuto, segundo)
    }
    fun copiarT(t:Tiempo):Tiempo{
        return Tiempo(t.hora, t.minuto, t.segundo)
    }

    fun comparar(t:Tiempo):Int{
        if(hora > t.hora) return 1
        if(hora < t.hora) return -1
        if(minuto > t.minuto) return 1
        if(minuto < t.minuto) return -1
        if(minuto == t.minuto) return 0
        if(segundo > t.segundo) return 1
        if(segundo < t.segundo) return -1
        if(segundo == t.segundo) return 0
        return 0
    }

    fun sumar(t:Tiempo):Tiempo?{
        val newhora = t.hora + hora
        val newmin = t.minuto + minuto
        val newseg = t.segundo + segundo

        if (newhora > 24 && newmin > 60 && newseg > 60){
            return null
        }else{
            return Tiempo(hora,minuto,segundo)
        }
    }
    fun restar(t:Tiempo):Tiempo?{
        val newhora = t.hora - hora
        val newmin = t.minuto - minuto
        val newseg = t.segundo + segundo

        if (newhora < 0 && newmin < 0 && newseg < 0){
            return null
        }else{
            return Tiempo(hora,minuto,segundo)
        }
    }


    fun esMayorQue(t: Tiempo): Boolean {
        if (hora > t.hora) {
            return true
        } else if (hora == t.hora) {
            if (minuto > t.minuto) {
                return true
            } else if (minuto == t.minuto) {
                if (segundo > t.segundo) {
                    return true
                }
            }
        }
        return false
    }
    fun esMenorQue(t: Tiempo): Boolean {
        if (hora < t.hora) {
            return true
        } else if (hora == t.hora) {
            if (minuto < t.minuto) {
                return true
            } else if (minuto == t.minuto) {
                if (segundo < t.segundo) {
                    return true
                }
            }
        }
        return false
    }

}