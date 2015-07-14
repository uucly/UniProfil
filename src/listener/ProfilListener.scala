

package listener

import java.awt.event.ItemEvent
import java.awt.event.ItemListener
import panels.InfoPanel
import profils.TProfil
import menue.Menue
import wahlPflicht.WahlPflichtManager
import panels.RightPanel
import panels.LeftPanel
import panels.LeftPanel

class ProfilListener(private val profil: TProfil) extends ItemListener {

  override def itemStateChanged(e: ItemEvent): Unit = {
    val selected = e.getStateChange() equals ItemEvent.SELECTED

    if (selected)
      updateProfilPanel
    else
      clearProfilPanel
      
      if(LeftPanel.getProfil != null){
        LeftPanel.getProfil.resetPoints
        LeftPanel.buttons.clear
        LeftPanel.pflichtButtons.clear
      } 
      if(RightPanel.getProfil != null) {
        RightPanel.getProfil.resetPoints
        RightPanel.buttons.clear
        RightPanel.pflichtButtons.clear
      }
      
      RightPanel.load
      LeftPanel.load
      InfoPanel.load
  }

  /////////////
  //Functions//
  def updateProfilPanel = {
    if (Menue.isCurrentPanelInUse) {
      Menue.unCheckCurrentProfilBox
      profil.resetPoints
    }

    Menue.setCurrentProfil(profil)
    profil.choosenPanel = Menue.currentPanel
    Menue.currentPanel.load()
    InfoPanel.load
    Menue.switchCurrentPanel
  }

  /**
   * Panel muss ueber profil ausgewaehlt werden, da der Listener nur das Profil kennt
   */
  def clearProfilPanel = {
    profil.resetPoints
    profil.choosenPanel.clearAll
    Menue.currentPanel = profil.choosenPanel
  }

}