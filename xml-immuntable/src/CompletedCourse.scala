

class CompletedCourse with Credit (
    val name:String,
    val hours:Int,
    val semester:Int,
    val average:Double,
    val letterGrade:String,
    val gradePointAverage:Double)
{
  override def print():String = s"  $semester, $hours, $letterGrade\t$name\ncomplete\n"
}