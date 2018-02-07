

class DropLowType extends Assignment (
    val dropCount:Int)
{
  private var gradeList:List[Double] = Nil
  
  def addGrade(g:Double) = gradeList ::= g
  
  def avg():Double = {
    if (gradeList.length <= dropCount) 100.0
    else {
      var tempGL = gradeList
      for (i <- 0 until dropCount) tempGL = tempGL diff List(tempGL.min)
      tempGL.sum/tempGL.length
    }
  }
  
  def print():String = {
    val stringIter = for (i <- 0 until gradeList.length) yield {
      name+" "+(i+1)+": "+gradeList(i)
    }
    val strings = ("avg: "+avg())::stringIter.toList
    strings.mkString(", ")
  }
}