

class CurrentCourse with Credit (
    val name:String,
    val hours:String,
    val semester:Int,
    private val asgmts:List[Assignment]
    protected val boundaries:List[GradeBoundary]
{
  val average = (for (a <- asgmts) yield a.avg).sum
  val letterGrade = boundaries.filter(
}