
package panels

import javax.swing.JPanel
import javax.swing.BoxLayout
import profils.TProfil
import profils.TProfil
import javax.swing.JLabel
import javax.swing.JRadioButton
import listener.PflichtProfilListener
import scala.collection.mutable.MutableList
import wahlPflicht.WahlPflichtModul
import listener.WahlProfilListener

trait TModulPanel extends JPanel {
  private var _profil: TProfil = null
  var name: String = null
  var buttons: MutableList[JRadioButton] = new MutableList

  def clearAll = {
    _profil = null
    removeAll()
    repaint()
  }
  def resetPoints = _profil.resetPoints
  def getProfil = _profil
  def setProfil(profil: TProfil) = _profil = profil

  def load() = {
    if (_profil != null) {
      removeAll();
      val ownWidth = 138
      add(new JLabel(getLines((ownWidth).toInt)))
      add(new JLabel(getSpace((ownWidth / 2).toInt - 3) + "Pflicht"))
      add(new JLabel(getLines((ownWidth).toInt)))

      addProfil(_profil._pflichtMap)
      add(new JLabel(getLines((ownWidth).toInt)))
      add(new JLabel(getSpace((ownWidth / 2).toInt - 2) + "Wahl"))
      add(new JLabel(getLines((ownWidth).toInt)))
      val modulsToShow = _profil.loadWahlModule();
      if (buttons.isEmpty) {
        loadWahlFile(modulsToShow)
      } else {
        buttons.foreach(button => {
          add(button)
          if (loadOtherPanel._profil != null && contains(loadOtherPanel._profil._pflichtMap, button.getText()))
            button.setEnabled(false)
        })

      }
      revalidate()
    }
  }

  private def getLines(lines: Int): String = {
    val buffer = new StringBuffer
    var n = 0
    for (n <- 1 to lines) {
      buffer.append(".")
    }
    return buffer.toString()
  }

  private def getSpace(space: Int): String = {
    val buffer = new StringBuffer
    var n = 0
    for (n <- 1 to space) {
      buffer.append(" ")
    }
    return buffer.toString()
  }

  def addProfil(list: Map[String, Int]) = {
    for (pflicht <- list) {
      val button = new JRadioButton(pflicht._1)
      button.addItemListener(new PflichtProfilListener(pflicht._2, _profil))
      add(button)
    }

  }

  def loadWahlFile(moduls: MutableList[WahlPflichtModul]) = {
    moduls.foreach(modul => {
      val button = new JRadioButton(modul.getName)
      button.addItemListener(new WahlProfilListener(modul, _profil))
      buttons += button
      add(button)
      println("Other " + loadOtherPanel)
      if (loadOtherPanel._profil != null && contains(loadOtherPanel._profil._pflichtMap, modul.getName))
        button.setEnabled(false)
    })
  }

  def loadOtherPanel = if (this == LeftPanel) RightPanel else LeftPanel

  def contains(map: Map[String, Int], containingName: String): Boolean = {
    for (name <- map) {
      if (name._1.equals(containingName)) return true
    }
    return false
  }
  // wird ausgefuehrt
  setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS))

}