

package listener

import java.awt.event.ItemEvent
import java.awt.event.ItemListener
import panels.InfoPanel
import profils.TProfil
import wahlPflicht.WahlPflichtModul
import menue.Menue
import panels.TModulPanel
import panels.LeftPanel
import panels.RightPanel
import start.MainFrame
import javax.swing.JButton
import javax.swing.JRadioButton
import scala.collection.mutable.MutableList

class WahlProfilListener(private var wahlModul: WahlPflichtModul, private val profil: TProfil) extends ItemListener {

  override def itemStateChanged(e: ItemEvent): Unit = {
    val button = e.getItem().asInstanceOf[JRadioButton]
    val selected = e.getStateChange() equals ItemEvent.SELECTED
    val p = loadUnUsedPanel(profil)
    val otherButtons = profil.choosenPanel.buttons
    if (selected) {
      p.buttons.filter(b => b.getText().equals(button.getText())).foreach(button => button.setEnabled(false))
      profil.wahlPoints += wahlModul.getPoints
    } else {
      p.buttons.filter(b => b.getText().equals(button.getText())).foreach(button => button.setEnabled(true))
      profil.wahlPoints -= wahlModul.getPoints
    }

    p.load
    InfoPanel.load
  }

  /**
   * Anderes Panel als das Panel, dass ausgewaehlt wurde, muss neu geladen werden, denn das muss eventuell
   * Wahlpflichtmodule disablen
   */
  def loadUnUsedPanel(profil: TProfil): TModulPanel = {
    if (profil.choosenPanel == LeftPanel)
      RightPanel
    else
      LeftPanel
  }

}