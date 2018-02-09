

class SimpleAverage extends Assignment {
  protected var gradeList:List[Double]
  
  def setGrade(replace:Boolean, grades:List[Double]) = {
    if (replace) gradeList = grades
    else gradeList ::= grades
  }
  
  def avg() = if (gradeList == Nil) 100.0 else gradeList.sum/gradeList.length
  
    
  def print():String = {
    val stringIter = for (i <- 0 until gradeList.length) yield {
      name+" "+(i+1)+": "+gradeList(i)
    }
    val strings = ("avg: "+avg())::stringIter.toList
    strings.mkString(", ")
  }
}