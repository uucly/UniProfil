

import java.awt.event.ItemEvent
import java.awt.event.ItemListener

class ProfilListener(private val profil: Profil) extends ItemListener {

  override def itemStateChanged(e: ItemEvent): Unit = {
    val selected = e.getStateChange() equals ItemEvent.SELECTED

    if (selected)
      updateProfilPanel
    else
      clearProfilPanel
  }

  /////////////
  //Functions//
  def updateProfilPanel = {
    if (ProfilMenue.isCurrentPanelInUse) {
      ProfilMenue.unCheckCurrentProfilBox
      profil.resetPoints
    }

    ProfilMenue.setCurrentProfil(profil)

    profil.load(ProfilMenue.currentPanel)
    InfoPanel.load
    ProfilMenue.switchCurrentPanel
  }

  def clearProfilPanel = {
    profil.resetPoints
    profil.choosenPanel.clearAll
    ProfilMenue.currentPanel = profil.choosenPanel
  }

}