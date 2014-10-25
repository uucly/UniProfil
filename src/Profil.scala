

import javax.swing.JPanel
import javax.swing.JRadioButton
import javax.swing.JCheckBoxMenuItem
import javax.swing.JLabel
import scala.io.Source

trait Profil {

  var name: String = null
  var choosenPanel: TBlaPanel = null
  var _checkBox: JCheckBoxMenuItem = null
  var _pflichtMap: Map[String, Int] = null

  var pflichtPoints = 0d
  var wahlPoints = 0d

  def load(panel: TBlaPanel)
  def getAllPoints = _pflichtMap.foldLeft(0)(_ + _._2)
  def resetPoints = {
    pflichtPoints = 0
    wahlPoints = 0
  }
  def addProfil(list: Map[String, Int], panel: JPanel) = {
    for (pflicht <- list) {
      val button = new JRadioButton(pflicht._1)
      button.addItemListener(new PflichtProfilListener(pflicht._2, this))
      panel.add(button)
    }
  }

  def loadWahlFile(fileName: String, panel: TBlaPanel) = {
    val fileLines = Source.fromFile(fileName).getLines
    fileLines.foreach(line => {
      val l = line.split(",")
      val button = new JRadioButton(l(0))
      button.addItemListener(new WahlProfilListener(l(1).toDouble, this))
      panel.add(button)
    })
  }
}
