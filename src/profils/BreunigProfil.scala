
package profils

import javax.swing.JCheckBoxMenuItem
import javax.swing.JLabel
import scala.io.Source
import panels.TModulPanel
import listener.ProfilListener
import java.io.InputStreamReader
import java.io.BufferedReader
import scala.io.BufferedSource

object BreunigProfil extends TProfil {

  _checkBox = new JCheckBoxMenuItem("Breunig Profil")
  _checkBox.addItemListener(new ProfilListener(this))
  name = "Breunig"
  _pflichtMap = Map(("GeoDB", 4), ("3D/4D GIS", 4), ("Projekt Geoinformatik", 4))

  val input = getClass().getResourceAsStream("/Breunig_Wahl.txt")
  wahlModul = new BufferedSource(input).getLines.toList
}