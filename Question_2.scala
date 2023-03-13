package Scala_Assignment

import scala.util.control.Breaks

case class player(year:Int,PlayerName:String,Country:String,Matches:Int,Runs:Int,Wickets:Int)
class Helperclass(arr:Array[player]){
  def display_all_players(): Unit = {
   arr.foreach(x=> println(
     s"""===============================
        |Name    :${x.PlayerName}
        |Year    :${x.year}
        |Country :${x.Country}
        |Matches :${x.Matches}
        |Runs    :${x.Runs}
        |Wickets :${x.Wickets}
        |==============================""".stripMargin))
  }

  def printIndi(x: player): Unit = {
    println(
      s"""
         |Name    :${x.PlayerName}
         |Year    :${x.year}
         |Country :${x.Country}
         |Matches :${x.Matches}
         |Runs    :${x.Runs}
         |Wickets :${x.Wickets}
         |""".stripMargin)
  }

  def highestRuns(): Unit = {
    var highestRun: player = arr(0)
    for (player <- arr) {
      highestRun = if (highestRun.Runs < player.Runs) player else highestRun
    }
   printIndi(highestRun)
  }

  def top5Runs(): Unit = {
    val top5runs = arr.sortWith(_.Runs > _.Runs)
    var i=1
    for (i <- 0 to 4) {
      println(s"=========${i+1}===============")
      printIndi(top5runs(i))
      println(s"=========================")
    }
    for (i<- 0 to 4) {
      println(s"${i+1})${top5runs(i).PlayerName}")

    }

  }

  def top5Wickets(): Unit = {
    val top5wickets = arr.sortWith(_.Wickets > _.Wickets)
    for (i <- 0 to 4) {
      println(s"=========${i+1}===============")
      printIndi(top5wickets(i))
      println(s"=========================")
    }
    for (i <- 0 to 4) {
      println(s"${i+1})${top5wickets(i).PlayerName}")

    }
  }
  def rankings(): Unit = {
    val newlist=arr.sortWith((player1,player2)=>5*player1.Wickets+(0.05*player1.Runs)>5*player2.Wickets+(0.05*player2.Runs))
    var i=1
    for (x <- newlist) {
      println(s"|=======$i=========|")
      printIndi(x)
      i = i + 1
      println(s"|==================|")
    }
    for(x <-newlist){
      println(s"$i)${x.PlayerName}")
      i=i+1
    }
  }
}
object Question_2{
  def main(args: Array[String]): Unit = {
    println("Enter the number of players")
    val n=scala.io.StdIn.readInt()
    val arr = new Array[player](n)
    for (i <- 0 until n) {
      println("=============================================================")
      println("Enter the name of the player")
      val name = scala.io.StdIn.readLine()
      println("Enter the year of the player")
      val Year = scala.io.StdIn.readInt()
      println("Enter the nationality of the player")
      val Country = scala.io.StdIn.readLine()
      println("Enter the number of matches played by the player")
      val Matches = scala.io.StdIn.readInt()
      println("Enter the Runs scored by the player")
      val runs = scala.io.StdIn.readInt()
      println("Enter the wickets taken by the player")
      val wickets= scala.io.StdIn.readInt()
      arr(i)=player(Year,name,Country,Matches,runs,wickets)
      println("=============================================================")



    }
//var arr = Array[player](
//  new player(2021, "Sam", "India", 23, 1700, 32),
//  new player(2021, "Tom", "England", 34, 2600, 2),
//  new player(2020, "Virat", "India", 56, 4566, 4),
//  new player(2021, "Bratt", "Australia", 46, 3500, 90),
//  new player(2021, "Ashwin", "India", 47, 1800, 195),
//  new player(2020, "Lee", "Austraila", 122, 2234, 255),
//  new player(2019, "Ponting", "Australia", 180, 11989, 120),
//  new player(2019, "Peeks", "West Indies", 170, 9989, 220),
//  new player(2019, "Rooks", "West Indies", 155, 3445, 140),
//  new player(2022, "Jack", "Pakistan", 89, 4578, 234),
//  new player(2013, "Rock", "USA", 19, 879, 78)
//)
    val obj1=new Helperclass(arr)
    while(true){
      println(
        """
          |1. Player with highest run scored
          |2. Top 5 players by run scored
          |3. Top 5 players by wickets taken
          |4. Rank player
          |5. Display all PLayers
          |6. Exit
          |Enter your choice
          |""".stripMargin)
      val ch=scala.io.StdIn.readInt()
      ch match {
        case 1 => obj1.highestRuns()
        case 2 => obj1.top5Runs()
        case 3 => obj1.top5Wickets()
        case 4 => obj1.rankings()
        case 5 => obj1.display_all_players()
        case 6 => {val outloop = new Breaks;
          outloop.break()}
        case exp => println("Invalid Choice")
      }
    }
  }
}