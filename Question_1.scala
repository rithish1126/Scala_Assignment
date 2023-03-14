package Scala_Assignment
//The class that contains all the required functions regarding finding the bucket in which a number belongs to.
/*
Buckets :
0.000 -0.049

0.050-0.099

0.100-0.149

0.150-0.199

0.200-0.249

0.250-0.299

0.300-0.349

0.350-0.399

100.000-100.049
 */
//We notice that all the bucket bounds have a difference of 0.049 so we just take the input of the number and take the last two digits
//to see if it falls in the bucket xx.00 - xx.x49 or xx.x50 - xx.x99
class Bucket{
 def find_bucket(n:Double): Unit = {//function that is responsible for printing the bucket the input number(n) belongs to.
   //val num_string=n.toString
   val last_two_digits=(String.format("%.3f",(n*1000)%100))// This line takes the last two digits of the number to decide if it belongs to either(xx.00 - xx.x49) or (xx.x50 - xx.x99)
   //println(last_two_digits)
   if(last_two_digits.toDouble<50){ //If last two digits are less than 50 then it falls in (xx.00 - xx.x49) bracket

     val left_bound=n-(last_two_digits.toDouble/1000)// we are subtracting the last two digits from the number to get the lower bound
     val right_bound=left_bound+0.049 //Then we are adding the bucket difference that is 0.049 and getting the right bound
     println(f"$left_bound%,.3f-$right_bound%,.3f") //printing the the results recieved of the left and right bound
   }
  else{
     val left_bound=n-(last_two_digits.toDouble/1000)+0.050 // since we find that the number now falls in the bucket xx.50 - xx.x99 we just minus the last two digits and add 0.050 to get in the right format
     val right_bound=left_bound+0.049 // and the right bound is just the left bound plus the bucket difference
     println(f"$left_bound%,.3f-$right_bound%,.3f") //printing the the results recieved of the left and right bound
   }



 }
}
object question1 {
  def main(args:Array[String]):Unit={//Main function to run the program
    val obj1 = new Bucket // the object of the bucket class required to run the function
    println("Enter the size of the array") // take input of the size of the array
    val n=scala.io.StdIn.readInt()
    val arr = new Array[Double](n) // define array
    for (i<- 0 until  n){
      println(s"Enter the ${i+1} element of the array")
      val x=scala.io.StdIn.readDouble() //input array elements from the stdin
      arr(i)=x // append to array

    }

    for (i<- 0 until n)
      {
        obj1.find_bucket(arr(i))// print output for every input
      }
  }

}