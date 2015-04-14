
import javax.swing.JLabel
import javax.swing.JRadioButton
import javax.swing.JCheckBoxMenuItem
import scala.collection.mutable.MutableList
import scala.io.Source

object HeckProfil extends Profil {

  _checkBox = new JCheckBoxMenuItem("Heck Profil")
  _checkBox.addItemListener(new ProfilListener(this))
  name = "Heck";

  var wahlModul = Source.fromFile("Heck_Wahl.txt").getLines.toList;

  
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

    val modulsToShow = loadWahlModule(wahlModul);
    loadWahlFile(modulsToShow, panel)
    panel.revalidate()
  }
  
}