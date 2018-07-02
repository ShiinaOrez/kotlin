package test

fun main(args:Array<String>){
    take(1,2,3,4,5)
}

fun take(vararg v:Int){
    for(vi in v){
        println(vi)
        for(i in 1..5){
            print("$i ")
            if(vi == i) break
        }
    }
}
