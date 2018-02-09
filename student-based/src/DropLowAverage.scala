

class DropLowAverage extends SimpleAverage (val dropCount:Int) {
  override def avg():Double = {
    if (gradeList.length <= dropCount) 100.0
    else {
      var tempGL = gradeList
      for (i <- 0 until dropCount) tempGL = tempGL diff List(tempGL.min)
      tempGL.sum/tempGL.length
    }
  }
}