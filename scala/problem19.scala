 object Problem19 {
    def main(args: Array[String]) {
        val mondays:Seq[Unit] = (for (y <- (1901 to 2000); m <- (1 to 12); if (isMonday(1,m,y))) yield ())
        println(mondays.length)
   }

   def isMonday(d:Int, m:Int, y:Int):Boolean = rank(d,m,y) % 7 == 0
   
   def rank(d:Int, m:Int, y:Int):Int = {
       //days since 1-Jan-1900
       d + (0 until m).map(daysInMonth(_,y)).sum + (1900 until y).map(daysInYear).sum 
   }
   def isLeap(y:Int):Boolean = y % 4 == 0 && (y%100 != 0 || y % 400 == 0) 
   
   def daysInMonth(y:Int, m:Int):Int = {
       (m,y) match {
        case (2, y) if isLeap(y) => 29
        case (2, _ ) => 28
        case (m, _) if List(4,6,9,11) contains m => 30
        case (_, _) => 31
       }
   }

   def daysInYear(y:Int) = if (isLeap(y)) 366 else 365
}
