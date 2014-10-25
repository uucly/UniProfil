import javax.swing.JLabel
import javax.swing.JRadioButton
import javax.swing.JCheckBoxMenuItem

object HennesProfil extends Profil {

  _checkBox = new JCheckBoxMenuItem("Hennes Profil")
  _checkBox.addItemListener(new ProfilListener(this))
  name = "Hennes"

  _pflichtMap = Map(("Dimensionelle Vermessungsverfahren", 8), ("Ausgewählte Kapitel zu GNSS", 2))

  def load(panel: TBlaPanel) = {

    choosenPanel = panel
    panel.removeAll()

    panel.add(new JLabel("-----------------------------------------------------------------"))
    panel.add(new JLabel("                              Pflicht"))
    panel.add(new JLabel("-----------------------------------------------------------------"))

    addProfil(_pflichtMap, panel)

    panel.add(new JLabel("-----------------------------------------------------------------"))
    panel.add(new JLabel("                              Wahl"))
    panel.add(new JLabel("-----------------------------------------------------------------"))

    loadWahlFile("Hennes_Wahl.txt", panel)
    panel.revalidate()
  }
}