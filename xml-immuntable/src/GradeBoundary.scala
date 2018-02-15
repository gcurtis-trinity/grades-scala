

case class GradeBoundary(
    lowerLimit:Double,
    letterGrade:String,
    gpa:Double) with scala.math.Ordered
{
  def compare(other:GradeBoundry):Int {
    this.lowerLimit.compare(other.lowerLimit)
  }
  
  def compare(avg:Double):Int {
    this.lowerLimit.compare(avg)
  }
}