class Tiempo(var hora:Int, minuto:Int, segundo:Int){

    constructor(hora: Int):this(hora,0,0)

    constructor(hora: Int, minuto: Int):this(hora)


    var minuto:Int = minuto

    set(value){
        hora += minuto / 60
        field = value % 60
    }


    var segundo:Int = segundo

        set(value){
            minuto += value / 60
            field = value % 60

        }

    init {
        require(hora in 0..23) {"hora no valida"}

        this.minuto += segundo / 60
        this.segundo %= 60


        hora += minuto / 60
        this.minuto %= 60
    }


    override fun toString(): String {
        return "$hora h:$minuto m:$segundo s"
    }

    fun incrementar(t:Tiempo):Boolean {
        val nueva_hora = hora + t.hora
        val nuevo_minuto = minuto + t.minuto
        val nuevo_segundo = segundo + t.segundo
        if(nueva_hora in 0..23 && nuevo_minuto in 0..59 && nuevo_segundo in 0..59){
            hora = nueva_hora
            minuto = nuevo_minuto
            segundo = nuevo_segundo
            return true
        }
        return false
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
}

fun main(){
    val tiempo1 = Tiempo(12, 145,66)
    tiempo1.incrementar(Tiempo(1,2,3))
    println(tiempo1)
}