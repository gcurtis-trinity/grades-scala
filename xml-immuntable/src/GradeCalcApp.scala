

object GradeCalcApp extends JFXApp {
  var Students:Buffer[Student] = () 
  def addStudent(filePath:String):Unit = {
    ???
  }
  def parseAssignmentLine(l:String):Assignment = {
    ???
  }
  def parseCurrentCourse(lines:Array[Strings]):??? = {
    ???
  }
  def parseStudent(file:???) = {
    ???
  }
  
  stage = new JFX.PrimaryStage {
    title = "Grade Caclulator"
    scene = new Scene(400,800) {
      ???
    }
  }
}