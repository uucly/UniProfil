package profils

import javax.swing.JLabel
import javax.swing.JCheckBoxMenuItem
import scala.io.Source
import panels.TModulPanel
import listener.ProfilListener
import scala.io.BufferedSource

object HennesProfil extends TProfil {

  _checkBox = new JCheckBoxMenuItem("Hennes Profil")
  _checkBox.addItemListener(new ProfilListener(this))
  name = "Hennes"

  _pflichtMap = Map(("Dimensionelle Vermessungsverfahren", 8), ("Ausgewählte Kapitel zu GNSS", 2))

  val input = getClass().getResourceAsStream("/Hennes_Wahl.txt")
  wahlModul = new BufferedSource(input).getLines.toList
}