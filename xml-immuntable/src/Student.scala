

class Student (
    val name:String,
    val sem:Int,
    val current:List[CurrentCourse],
    val complete:List[CompletedCourse])
{
  private val gpaSemTotal:(Double,Int) = ((for (a <- current) yield a.gradePointAverage*a.hours).sum , (for a <- current) yield a.hours).sum)
  private val gpaPastTotal:(Double,Int) = ((for (b <- complete) yield b.gradePointAverage*b.hours).sum , (for b <- currnet) yield b.hours).sum)
  val semesterGPA = gpaSemTotal(1)/gpaSemTotal(2)
  val gpa = (gpaSemTotal(1) + gpaPastTotal(1))/(gpaSemTotal(2) + gpaPastTotal(2))
  
  
}