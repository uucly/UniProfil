
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

  def clearAll = {
    _profil = null
    removeAll()
    repaint()
  }
  def resetPoints = _profil.resetPoints
  def getProfil = _profil
  def setProfil(profil: TProfil) = _profil = profil

  def load() = {
    println("Hier")
    println(name)
    println(_profil .name )
    removeAll();
    add(new JLabel("-----------------------------------------------------------------"))
    add(new JLabel("                              Pflicht"))
    add(new JLabel("-----------------------------------------------------------------"))

    addProfil(_profil._pflichtMap)

    add(new JLabel("-----------------------------------------------------------------"))
    add(new JLabel("                              Wahl"))
    add(new JLabel("-----------------------------------------------------------------"))

    val modulsToShow = _profil.loadWahlModule();
    loadWahlFile(modulsToShow)
    revalidate()
  }

  def addProfil(list: Map[String, Int]) = {
    for (pflicht <- list) {
      val button = new JRadioButton(pflicht._1)
      button.addItemListener(new PflichtProfilListener(pflicht._2, _profil))
      add(button)
    }
  }

  def loadWahlFile(moduls: MutableList[WahlPflichtModul]) = {
    val panel = loadOtherPanel
    moduls.foreach(modul => {
      val button = new JRadioButton(modul.getName)
      button.addItemListener(new WahlProfilListener(modul, _profil, panel))
      if (modul.inUse)
        button.setEnabled(false)
      add(button)
    })
  }

  def loadOtherPanel = if(this == RightPanel) RightPanel else LeftPanel
  // wird ausgefuehrt
  setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS))

}