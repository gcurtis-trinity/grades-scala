

class Assignment (
    val name:String,
    val weight:Double,
    val grades:List[Double],
    val single:Boolean,
    val dropCount:Int)
{
  val avg = {
    if (single) grades.head
    else if (grades.length <= dropCount) 100.0
    else {
      var tempGL = grades
      for (i <- 0 until dropCount) tempGL = tempGL diff List(tempGL.min)
      tempGL.sum/tempGL.length
    }
  }
  
  /*function to return the grade needed to achieve a certain average
   *  @param want: the average to be achieved
   *  @out: the grade needed as a percentage
   */
  def whatNeeded(want:Double):Double = {
    if (single) want
    else {
      val current = grades.sum
      want*(grades.length + 1) - current
    }
  }
  
  /*function to return a new Assignment list based on the type of the argument updated
   */
  def update [A](a:A):Assignment = {
    a.match {
      case _:String => new Assignment(a, weight, grades, single, dropCount)
      case _:Double => new Assignmnet(name, a, grades, single, dropCount)
      case _:List[Double] => new Assignment(name, wieght, a, single, dropCount)
      case _:Boolean => new Assignment(name, weight, grades, a, dropCount)
      case _:Int => new Assignment(name, weight, grades, single, a)
    }
  }
  
  override def print():String = name+"["+grades.mkString(',')+"]"
}