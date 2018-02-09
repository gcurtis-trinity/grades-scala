

abstract class Assignment (
    val name:String,
    val weight:Double)
{ 
  def gradeSet(replace:Boolean, grades:List[Double]):Unit
  def avg():Double
  override def print():String
}