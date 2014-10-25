
import javax.swing.JLabel
import javax.swing.JRadioButton
import javax.swing.JCheckBoxMenuItem

object HeckProfil extends Profil {

  _checkBox = new JCheckBoxMenuItem("Heck Profil")
  _checkBox.addItemListener(new ProfilListener(this))
  name = "Heck"

  _pflichtMap = Map(("Rezente Geodynamik", 4), ("Seminar Erdsystembeobachtung", 1), ("SAR und InSAR-Fernerkundung", 3), ("Regionale Schwerefeldmodellierung", 3))

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

    loadWahlFile("Heck_Wahl.txt", panel)
    panel.revalidate()
  }
}