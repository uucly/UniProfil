

package listener

import java.awt.event.ItemEvent
import java.awt.event.ItemListener
import panels.InfoPanel
import profils.TProfil
import wahlPflicht.WahlPflichtModul
import menue.Menue
import panels.TModulPanel
import panels.RightPanel
import panels.LeftPanel

class WahlProfilListener(private var wahlModul: WahlPflichtModul, private val profil: TProfil, private val panel: TModulPanel) extends ItemListener {

  override def itemStateChanged(e: ItemEvent): Unit = {
    val selected = e.getStateChange() equals ItemEvent.SELECTED

    if (selected) {
      wahlModul.inUse = true
      profil.wahlPoints += wahlModul.getPoints
    } else {
      wahlModul.inUse = false
      profil.wahlPoints -= wahlModul.getPoints
    }

    val p = loadUnUsedPanel(panel)
    println(p.name )
    p.load
    InfoPanel.load
  }

  /**
   * Anderes Panel als das Panel, dass ausgewaehlt wurde, muss neu geladen werden, denn das muss eventuell
   * Wahlpflichtmodule disablen
   */
  def loadUnUsedPanel(panel: TModulPanel): TModulPanel = {
    if (panel == RightPanel)
      RightPanel
    else
      LeftPanel
  }

}