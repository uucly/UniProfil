
package menue

import javax.swing.JMenuBar
import javax.swing.JMenu
import javax.swing.JLabel
import panels.TModulPanel
import panels.RightPanel
import profils.Profil
import profils.HinzProfil
import profils.HennesProfil
import profils.BreunigProfil
import listener.LinkMouseListener
import profils.HeckProfil
import panels.WahlPanel
import profils.ErgaenzungsProfil
import menue.Aufbau

object ProfilMenue extends JMenuBar {

  var currentPanel: TModulPanel = RightPanel
  var aufbauCreditPoints = 0d
  var ergaenungCreditPoints = 0d
  var keyCreditPoints = 0d

  def load = {

    val menueProfil = new JMenu("Profil")
    val menueAufbau = new JMenu("Aufbaufächer")
    val menueErgaenzung = new JMenu("Ergänzungsfächer")
    val menueKey = new JMenu("Schlüsselqualifikationen")
    val newWindow = new JMenu("new Window");
    menueProfil.add(HinzProfil._checkBox)
    menueProfil.add(BreunigProfil._checkBox)
    menueProfil.add(HennesProfil._checkBox)
    menueProfil.add(HeckProfil._checkBox)
    add(menueProfil)

    menueAufbau.add(Aufbau.compVision)
    menueAufbau.add(Aufbau.datenanalyse)
    menueAufbau.add(Aufbau.geoinfo)
    menueAufbau.add(Aufbau.mathe)
    menueAufbau.add(Aufbau.schaetztheorie)
    menueAufbau.add(Aufbau.senso)
    menueAufbau.add(Aufbau.weltRaum)
    add(menueAufbau)

    menueErgaenzung.add(ErgaenzungsProfil.astro)
    menueErgaenzung.add(ErgaenzungsProfil.boden)
    menueErgaenzung.add(ErgaenzungsProfil.geschGeod)
    menueErgaenzung.add(ErgaenzungsProfil.hydro)
    menueErgaenzung.add(ErgaenzungsProfil.immo)
    menueErgaenzung.add(ErgaenzungsProfil.karto)
    menueErgaenzung.add(ErgaenzungsProfil.kataster)
    menueErgaenzung.add(ErgaenzungsProfil.neuOrdnung)
    menueErgaenzung.add(ErgaenzungsProfil.strasse)
    menueErgaenzung.add(ErgaenzungsProfil.umwelt)
    add(menueErgaenzung)

    menueKey.add(KeyQualification.key)
    add(menueKey)
  }

  load

  val urlLink = new JLabel("Link")
  urlLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR))
  urlLink.addMouseListener(new LinkMouseListener(urlLink))
  urlLink.setOpaque(true)
  add(urlLink)

  //Functions
  def isCurrentPanelInUse = (currentPanel._profil != null)
  def unCheckCurrentProfilBox = currentPanel._profil._checkBox.setSelected(false)
  def setCurrentProfil(profil: Profil) = currentPanel._profil = profil
  def switchCurrentPanel() = {
    if (currentPanel == RightPanel)
      currentPanel = WahlPanel
    else
      currentPanel = RightPanel
  }

 
}

