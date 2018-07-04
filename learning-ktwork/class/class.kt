package test.Class

class Person constructor(lastName:String,no:Int,heiht:Float){
    init{
        println("lastName is $lastName")
        foo()
    }
    var lastname:String=lastName
        get()=field.toUpperCase()
    var NO:Int=no
        get()=field*100
        set(value){
            field*=100
            if(value==600) field=value*3
        }
    var Heiht:Float=heiht
        private set
    public fun cal(){
        println("rua!")
    }
    private fun foo(){
        println("rua?")
    }
}

private class Juice(){
    var price:Float=23.5f
}

class Bag(){
    var p:Person= Person(lastName = "fuck",no = 1,heiht = 132.0f)
//    var j:Juice() it doesn't work
}

fun main(args:Array<String>){
    var Me:Person=Person(lastName = "Ruyang",no = 6,heiht = 174.0f)
    print("${Me.lastname} ${Me.NO} ${Me.Heiht}")
    Me.cal()
    var cola:Juice= Juice()
    print(cola.price)
    var b:Bag=Bag()
//    println(b.j.price)
}
