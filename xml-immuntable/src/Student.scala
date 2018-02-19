

class Student (
    val name:String,
    val sem:Int,
    val current:List[CurrentCourse],
    val complete:List[CompletedCourse],)
{
  private val gpaSemTotal:(Double,Int) = ((for (a <- current) yield a.gradePointAverage*a.hours).sum , (for a <- current) yield a.hours).sum)
  private val gpaPastTotal:(Double,Int) = ((for (b <- complete) yield b.gradePointAverage*b.hours).sum , (for b <- currnet) yield b.hours).sum)
  val semesterGPA = gpaSemTotal(1)/gpaSemTotal(2)
  val gpa = (gpaSemTotal(1) + gpaPastTotal(1))/(gpaSemTotal(2) + gpaPastTotal(2))
  
  def setSem(s:Int):Student = new Student(name, s, current, completed)
  
  def + (add:CurrentCourse):Student = new Student(name, sem, add::current, complete)
  def + (add:CompletedCourse):Student = new Student(name, sem, current, add::complete)
  
  def - (minus:CurrentCourse):Student = new Student(name, sem, current diff List(minus), complete)
  def - (minus:CompletedCourse):Student = new Student(name, sem, current, completed diff List(minus))
  
  def update [A](a:A, old:Assignment, c:CurrentCourse):Student = {
    if (current.contains(c)) {
      new Student(name, sem, current.update(a, old), completed)
    }
    else this
  }
  
  override def print():String = {
    val comStr = (for (a <- completed) yield a.print).mkString()
    val curStr = (for (b <- current) yield b.print).mkString()
    val hypenLine = "-"*30
    s"Name: $name, Semester: $sem, GPA: $gpa, semester GPA: $semesterGPA\n$hypenLine\n$comStr$curStr"
  }
}