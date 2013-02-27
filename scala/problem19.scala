 object Problem19 {
    def main(args: Array[String]) {
        var count = 0
        for (y <- (1901 to 2000); m <- (1 to 12)) {
         if (isMonday(1,m,y)) count+=1
    }
    println(count)
   }
   def isMonday(d:Int, m:Int, y:Int):Boolean = {
       val r = rank(d,m,y)
       r % 7 == 0
   }
   def rank(d:Int, m:Int, y:Int):Int = {
       //days since 1-Jan-1900
       d + (0 until m).map(m => daysInMonth(m,y)).sum + (1900 until y).map(daysInYear).sum 
   }
   def daysInYear(y:Int) = if (isLeap(y)) 366 else 365
   def isLeap(y:Int):Boolean = {
       y % 4 == 0 && (y%100 != 0 || y % 400 == 0) 
   }
   def daysInMonth(y:Int, m:Int):Int = {
       if (List(4,6,9) contains m) 30
           else if (m==2) {if (isLeap(y)) 29 else 28}
           else 31
   }
}
