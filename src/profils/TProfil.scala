

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

  def getAllPoints = _pflichtMap.foldLeft(0)(_ + _._2)
  def resetPoints = {
    pflichtPoints = 0d
    wahlPoints = 0d
  }
  def loadWahlModule() = {
    WahlPflichtManager.wahlPflichtList.filter(modul => wahlModul.contains(modul.getName))
  }
}
