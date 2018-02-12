

case class GradeBoundary with scala.math.Ordered(
    lowerLimit:Double,
    letterGrade:String,
    gpa:Double)
{
  def compare(other:GradeBoundry):Int {
    this.lowerLimit.compare(other.lowerLimit)
  }
  
  def compart(avg:Double):Int {
    this.lowerLimit.compare(avg)
  }
}