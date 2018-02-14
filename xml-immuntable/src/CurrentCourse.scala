

class CurrentCourse with Credit (
    val name:String,
    val hours:Int,
    val semester:Int,
    private val asgmts:List[Assignment]
    protected val boundaries:List[GradeBoundary]
{
  val average = (for (a <- asgmts) yield a.avg*a.weight).sum/(for (a <- asgmts) yield a.weight).sum
  val letterGrade = boundaries.filter(b => b.lowerLimit < average).max.letterGrade
  val GradePointAverage = boundaries.filt(b => b.lowerLimit < average).max.gpa
  
  /*function that returns the lowest grade to be added that will result in a certian
   *letter grade
   *  @param wanted: the letter grade to be achieved
   *  @param category: which assignment to add the grade to
   *  @out: the grade needed as a percentage
   */
  def whatNeeded(wanted:GradeBoundary, category:Assignment):Double = {
    val current = (for (a <- asgmts; if a != category) yield a.avg*a.weight).sum
    val needed = (wanted.lowerLimit - current)/category.weight
    category.whatNeeded(needed)
  }
  
  def + (add:Assignment):CurrentCourse = new CurrentCourse(name, hours, semester, add::asgmts,boundaries)
  
  def - (minus:Assignment):CurrentCourse = new CurrentCourse(name, hours, semester, asmts diff List(minus), boundaries)
  
  def update [A](old:Assignment, a:A):CurrentCourse = {
    new CurrentCourse(name, hours, semester, old.update(a:A)::asgmts diff List(old), boundaries)
  }
  
  def toCompleted():CompletedCourse = new CompletedCourse(name, hours, semseter, average, letterGrade, gradePointAverage)
  
  val asgmtsStrings = (for (a <- asgmts) yield a.print()).mkString("\n\t")
  override def print():String = s"  $semester, $hours, $letterGrade\t$name: \n$asgmtsStrings\n"
  
}