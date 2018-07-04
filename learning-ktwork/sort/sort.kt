package test.sort
//kotlin 下的冒泡排序
fun main(args:Array<String>){
    var a:IntArray= intArrayOf(1,5,6,9,8,7,4,3,2)
    var b:IntArray
    b=globSort(a)
    Print(b)
    b=bucketSort(a)
    Print(b)
    b=mergeSort(a.size,0,a.size-1,a)
    Print(b)
    b=heapSort(a.size,a)
    Print(b)
}

fun Print(a:IntArray){
    for(i in a.indices){
        print ("${a[i]} ")
    }
    println()
}

fun globSort(a:IntArray):IntArray{
    for(i in (a.size-1) downTo 0){
        for(j in 0..(i-1)){
            if(a[i]<a[j]){
                var s=a[i];
                a[i]=a[j];a[j]=s;
            }
        }
    }
    return a
}

fun bucketSort(a:IntArray):IntArray{
    var b=Array(10,{k->(k*0)})
    for(i in a.indices){
        b[a[i]]+=1
    }
    var e:Int=0;
    for(i in b.indices){
        for(j in 1..b[i]){
            a[e]=i
            e+=1
        }
    }
    return a
}

fun mergeSort(Size:Int,l:Int,r:Int,v:IntArray):IntArray{
    if(l+1==r||l==r){
        if(v[l]<=v[r]||l==r) return v
        else{
            var s:Int=v[l];v[l]=v[r];v[r]=s
            return v
        }
    }
    var mid:Int=(l+r)/2
    var a:IntArray=v
    a= mergeSort(Size,l,mid,a)
    a= mergeSort(Size,mid+1,r,a)
    var e:Int=0
    var p1:Int=l;var p2:Int=mid+1
    var b=Array(Size,{k->(k*0)})
    while(p1<=mid&&p2<=r){
        if(a[p1]<a[p2]){
            b[e]=a[p1]
            p1+=1
        }else{
            b[e]=a[p2]
            p2+=1
        }
        e+=1
    }
    while(p1<=mid){
        b[e]=a[p1]
        p1+=1;e+=1
    }
    while(p2<=r){
        b[e]=a[p2]
        p2+=1;e+=1
    }
    for(i in b.indices) a[i]=a[i]
    return a
}

fun heapSort