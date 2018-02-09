

class CurrentCourse extends Credit {
  case class Boundary(lowerLimit:Double, letterGrade:String, gpa:Double)
  private var avg[Double] = 100
  private var grades List[Assignment] = Nil
  private var bounds = List[Boundary] = Nil
  
  def setBounds(ll:Array[Double], lg:Array[String], gp:Array[Double]):Unit = {
    bounds = (for (i <- 0 until ll.length) { Boundary(ll(i), lg(i), gp(i)) }).toArray
  }
  
  def addSimpleAverage(name:String, weight:Double):Unit = {
    grades ::= new SimpleAverage(name, weight)
  }
  def addDropLowAverage(name:String, weight:Double, dropCount:Int):Unit = {
    grades ::= new DropLowAverage(name, weight, dropCount)
  }
  
  def addGrade(name:String, grade:Double):Unit = {
    
  }
  
  def calcAvg:Unit = {
    avg = (for (gTypes <- grades) {gType.avg*gType.weight}).sum
  }
  
  def gpaValue:Double = {
    val whatBounds = bounds.filter(b => (b.lowerLimit < avg))
    whatBounds(0).gpa
  }
  
  
}