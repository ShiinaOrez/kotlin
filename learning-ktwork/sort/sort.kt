package test.sort
//kotlin 下的冒泡排序
fun main(args:Array<String>){
    var a:IntArray= intArrayOf(1,5,6,9,8,7,4,3,2)
    var b:IntArray
    print("now we use kotlin to sort array-A:");println()
    print("array-A:");Print(a)
    println()
    b=globSort(a)
    print("glob-sort:  ");Print(b)
    b=bucketSort(a)
    print("bucket-sort:");Print(b)
    b=mergeSort(a.size,0,a.size-1,a)
    print("merge-sort: ");Print(b)
    b=heapSort(a.size,a)
    print("heap-sort:  ");Print(b)
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

fun heapSort(S:Int,a:IntArray):IntArray{
    var c:IntArray=heapUp(a)
    var b=Array(S+1,{i->(i*0)})
    for(i in c.indices)
        b[i+1]=c[i]
//    for(i in b) print("$i ")
//    println()
    var Size:Int=S
//    print("S=$S $Size")
    for(i in a.indices){
//        for(j in b) print("$j ")
//        println()
        a[i]=b[1]
//        print ("b[0]=${b[0]} ")
        b[1]=b[Size]
        Size-=1
        var point:Int=1
        while(point in 1..Size){
            if(point*2 in 1..Size&&point*2+1 in 1..Size){
                if(b[point]>b[point*2]&&b[point]>b[point*2+1]){
                    if(b[point*2]<b[point*2+1]){
                        var s=b[point];b[point]=b[point*2];b[point*2]=s;
                        point*=2;continue;
                    }
                    else{
                        var s=b[point];b[point]=b[point*2+1];b[point*2+1]=s;
                        point=point*2+1;continue;
                    }
                }
                if(b[point]>b[point*2]){
                    var s=b[point];b[point]=b[point*2];b[point*2]=s;
                    point*=2;continue;
                }
                if(b[point]>b[point*2+1]){
                    var s=b[point];b[point]=b[point*2+1];b[point*2+1]=s;
                    point=point*2+1;continue;
                }
            }
            if(point*2 in 1..Size && b[point]>b[point*2]){
                var s=b[point];b[point]=b[point*2];b[point*2]=s;
                point*=2;continue;
            }
            if(point*2+1 in 1..Size && b[point]>b[point*2+1]){
                var s=b[point];b[point]=b[point*2+1];b[point*2+1]=s;
                point=point*2+1;continue;
            }
            break;
        }
    }
    return a
}

fun heapUp(a:IntArray):IntArray{
    for(i in a.indices){
        var point:Int=i
        while(point!=0){
            if(a[point]<a[point/2]){
                var s:Int=a[point]
                a[point]=a[point/2]
                a[point/2]=s
                point/=2
            }
            else break
        }
    }
    return a
}