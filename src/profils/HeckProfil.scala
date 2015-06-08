
package profils

import javax.swing.JLabel
import javax.swing.JCheckBoxMenuItem
import scala.io.Source
import panels.TModulPanel
import listener.ProfilListener
import scala.io.BufferedSource

object HeckProfil extends TProfil {

  _checkBox = new JCheckBoxMenuItem("Heck Profil")
  _checkBox.addItemListener(new ProfilListener(this))
  name = "Heck";

  val input = getClass().getResourceAsStream("/Heck_Wahl.txt")
  wahlModul = new BufferedSource(input).getLines.toList
  
  _pflichtMap = Map(("Rezente Geodynamik", 4), ("Seminar Erdsystembeobachtung", 1), ("SAR und InSAR-Fernerkundung", 3), ("Regionale Schwerefeldmodellierung", 3))
  
}