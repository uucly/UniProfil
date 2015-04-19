
package profils

import javax.swing.JLabel
import javax.swing.JCheckBoxMenuItem
import scala.io.Source
import panels.TModulPanel
import listener.ProfilListener

object HeckProfil extends TProfil {

  _checkBox = new JCheckBoxMenuItem("Heck Profil")
  _checkBox.addItemListener(new ProfilListener(this))
  name = "Heck";

  wahlModul = Source.fromFile("Heck_Wahl.txt").getLines.toList;

  
  _pflichtMap = Map(("Rezente Geodynamik", 4), ("Seminar Erdsystembeobachtung", 1), ("SAR und InSAR-Fernerkundung", 3), ("Regionale Schwerefeldmodellierung", 3))

  /*def load(panel: TModulPanel) = {

    choosenPanel = panel

    panel.removeAll()

    panel.add(new JLabel("-----------------------------------------------------------------"))
    panel.add(new JLabel("                              Pflicht"))
    panel.add(new JLabel("-----------------------------------------------------------------"))

    addProfil(_pflichtMap, panel)

    panel.add(new JLabel("-----------------------------------------------------------------"))
    panel.add(new JLabel("                              Wahl"))
    panel.add(new JLabel("-----------------------------------------------------------------"))

    val modulsToShow = loadWahlModule();
    loadWahlFile(modulsToShow, panel)
    panel.revalidate()
  }*/
  
}