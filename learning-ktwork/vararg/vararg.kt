package test.vararg

fun main(args: Array<String>){
	vars(1,2,3,4,5)
	var str:String="fuck off!"
	var len:Int=judge(str)
	println ("$str 's length is $len")
}

fun vars(vararg a:Int){
	var count:Int=0
	for(ai in a){
	    count+=ai
	    println ("count is $count")
	}
}

fun judge(obj:Any):Int{
	if(obj is String){
	    return obj.length
	}
	return 0
}