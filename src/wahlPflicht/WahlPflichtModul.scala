package wahlPflicht

class WahlPflichtModul(private val name: String, private val points: Double) {
  var isRightChoosen, isLeftChoosen = false;
  def getName = name;
  def getPoints = points;

  override def toString() = { "Wahlmodul[name=" + name + ", points=" + points }
}