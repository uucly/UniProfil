package profils

import javax.swing.JLabel
import javax.swing.JCheckBoxMenuItem
import scala.io.Source
import panels.TModulPanel
import listener.ProfilListener

object HennesProfil extends TProfil {

  _checkBox = new JCheckBoxMenuItem("Hennes Profil")
  _checkBox.addItemListener(new ProfilListener(this))
  name = "Hennes"

  _pflichtMap = Map(("Dimensionelle Vermessungsverfahren", 8), ("Ausgewählte Kapitel zu GNSS", 2))

  wahlModul = Source.fromFile("Hennes_Wahl.txt").getLines.toList;

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