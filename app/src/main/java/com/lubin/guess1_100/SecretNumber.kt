package com.lubin.guess1_100

import kotlin.random.Random

class SecretNumber {
    var min=1//var可變動任何一值 val則是固定而無法改變任何的值
    var max=100
    val secret:Int = Random.nextInt(min,max)//隨機產生一數字min-max
    var count=0//var count:Int=0
    //kotlin可依等號右邊的值的型態來推斷你這個值是要甚麼樣的型態(固可省略:Int)
    fun validate(number:Int):Int{//驗證此值,傳入整數的值給我,並且回傳Int的值
        count++//猜測次數
        return number-secret//希望可用number-secret做回傳來告訴我差異是大or小
    }
}

fun main() {
    val secretNumber=SecretNumber()//產生可使用的物件並呼叫此類別的"建構值"讓它產生在記憶體中
    println(secretNumber.secret)
    //println(secretNumber.validate(70))//傳入70,輸出number-secret後的差異值
    println("${secretNumber.validate(70)},count=${secretNumber.count}")
}