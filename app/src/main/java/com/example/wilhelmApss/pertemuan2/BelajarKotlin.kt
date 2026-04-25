package com.example.wilhelmApss.pertemuan2

fun main(){
    println("Hai rekan-rekan..")
    println("Selamat datang d bahasa pemograman Kotlin")

    println("=========")

    val angka = 15
    println("hasil dari 15 + 10 = ${angka + 10}")

    val nilaiInt = 10000
    val nilaiDouble = 100.003
    val nilaiFloat = 100.0f

    println("Nilai Interger = $nilaiInt")
    println("Niai Double = $nilaiDouble")
    println("NilaI Float = $nilaiFloat")

    print("======STRING=======")
    val huruf = 'a'
    println("Ini penggunaan karakter '$huruf'")

    val nilaiString = "Mawar"
    println("Halo $nilaiString!\nApa kabar")

    println("=====KONDISI=======")

    val nilai = 10
    if (nilai<0)
        println("Bilangan negatif")
    else {
        if (nilai%2 == 0)
            println("Bilangan Genap")
        else {
            println("Bilangan Ganjil")
        }

        println("=======PERULANGAN=======")
        val kampusKu: Array<String>  = arrayOf("Kampus", "Politeknik", "Caltex", "Riau")
        for (kampus: String in kampusKu) {
            println(kampus)
        }
    }
}
