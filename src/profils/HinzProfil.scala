package profils

import javax.swing.JLabel
import javax.swing.JCheckBoxMenuItem
import scala.io.Source
import panels.TModulPanel
import listener.ProfilListener

object HinzProfil extends Profil {

  _checkBox = new JCheckBoxMenuItem("Hinz Profil")
  _checkBox.addItemListener(new ProfilListener(this))
  name = "Hinz"

  _pflichtMap = Map(("Struktur- und Objektextraktion in 2D und 3D", 4), ("Bildsequenzanalyse", 2), ("Statistische Mustererkennung\nWissensbasierte Bildanalyse", 5))

  var wahlModul = Source.fromFile("Hinz_Wahl.txt").getLines.toList;
  
  def load(panel: TModulPanel) = {

    choosenPanel = panel
    panel.removeAll()

    panel.add(new JLabel("-----------------------------------------------------------------"))
    panel.add(new JLabel("                              Pflicht"))
    panel.add(new JLabel("-----------------------------------------------------------------"))

    addProfil(_pflichtMap, panel)

    panel.add(new JLabel("-----------------------------------------------------------------"))
    panel.add(new JLabel("                              Wahl"))
    panel.add(new JLabel("-----------------------------------------------------------------"))

    val modulsToShow = loadWahlModule(wahlModul);
    loadWahlFile(modulsToShow, panel)
    panel.revalidate()
  }
}