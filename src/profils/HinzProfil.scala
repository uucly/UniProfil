package profils

import javax.swing.JLabel
import javax.swing.JCheckBoxMenuItem
import scala.io.Source
import panels.TModulPanel
import listener.ProfilListener
import scala.io.BufferedSource

object HinzProfil extends TProfil {

  _checkBox = new JCheckBoxMenuItem("Hinz Profil")
  _checkBox.addItemListener(new ProfilListener(this))
  name = "Hinz"

  _pflichtMap = Map(("Struktur- und Objektextraktion in 2D und 3D", 4), ("Bildsequenzanalyse", 2), ("Statistische Mustererkennung\nWissensbasierte Bildanalyse", 5))

  val input = getClass().getResourceAsStream("/Hinz_Wahl.txt")
  wahlModul = new BufferedSource(input).getLines.toList
}