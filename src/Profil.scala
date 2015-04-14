

import javax.swing.JPanel
import javax.swing.JRadioButton
import javax.swing.JCheckBoxMenuItem
import javax.swing.JLabel
import scala.io.Source
import scala.collection.mutable.MutableList

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

  def loadWahlModule(wahlModul: List[String]) = {
    WahlPflichtManager.wahlPflichtList.filter(modul => wahlModul.contains(modul.getName))
  }

  def loadWahlFile(moduls: MutableList[WahlPflichtModul], panel: TBlaPanel) = {
    moduls.foreach(modul => {
      val button = new JRadioButton(modul.getName)
      button.addItemListener(new WahlProfilListener(modul.getPoints, this))
      if(modul.inUse) 
        button.setEnabled(false) 
      else {
        modul.inUse = true;
      }
      println(modul.inUse)
      panel.add(button)
    })
  }
}
