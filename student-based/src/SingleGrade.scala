

class SingleGrade extends Assignment (private val grade:Double) {
  def avg() = grade
  def print() = name+":"+grade
}