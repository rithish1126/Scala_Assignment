package Scala_Assignment

class Bucket{
 def find_bucket(n:Double): Unit = {
   val num_string=n.toString
   val last_two_digits=(String.format("%.3f",(n*1000)%100))
   //println(last_two_digits)
   if(last_two_digits.toDouble<50){

     val left_bound=n-(last_two_digits.toDouble/1000)
     val right_bound=left_bound+0.049
     println(f"$left_bound%,.3f-$right_bound%,.3f")
   }
  else{
     val left_bound=n-(last_two_digits.toDouble/1000)+0.050
     val right_bound=left_bound+0.049
     println(f"$left_bound%,.3f-$right_bound%,.3f")
   }



 }
}
object question1 {
  def main(args:Array[String]):Unit={
    val obj1 = new Bucket
    val n=scala.io.StdIn.readInt()
    val arr = new Array[Double](n)
    for (i<- 0 until  n){
      val x=scala.io.StdIn.readDouble()
      arr(i)=x

    }

    for (i<- 0 until n)
      {
        obj1.find_bucket(arr(i))
      }
  }

}