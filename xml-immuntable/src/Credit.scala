

trait Credit {
  val name:String
  val hours:Int
  val semester:Int
  val average:Double
  val letterGrade:String
  val gradePointAverage:Double
  
  def whatNeeded(wanted:GradeBoundary, asgmnt:Assignment)
}