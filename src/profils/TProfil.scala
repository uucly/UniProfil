

package profils

import javax.swing.JPanel
import javax.swing.JRadioButton
import javax.swing.JCheckBoxMenuItem
import scala.collection.mutable.MutableList
import panels.TModulPanel
import listener.PflichtProfilListener
import wahlPflicht.WahlPflichtModul
import wahlPflicht.WahlPflichtManager
import listener.WahlProfilListener

trait TProfil {

  var name: String = null
  var choosenPanel: TModulPanel = null
  var _checkBox: JCheckBoxMenuItem = null
  var _pflichtMap: Map[String, Int] = null
  var wahlModul: List[String] = null;

  var pflichtPoints = 0d
  var wahlPoints = 0d

  //def load(panel: TModulPanel)
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

  def loadWahlModule() = {
    WahlPflichtManager.wahlPflichtList.filter(modul => wahlModul.contains(modul.getName))
  }
}
