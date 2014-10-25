

import javax.swing.JCheckBoxMenuItem

object ErgaenzungsProfil {

  val geschGeod = new JCheckBoxMenuItem("Geschichte der Geod�sie")
  geschGeod.addItemListener(new ErgaenzungProfilListener(4))

  val kataster = new JCheckBoxMenuItem("Katasterrecht")
  kataster.addItemListener(new ErgaenzungProfilListener(1))

  val neuOrdnung = new JCheckBoxMenuItem("Neuordnung der l�ndlichen R�ume II")
  kataster.addItemListener(new ErgaenzungProfilListener(4))

  val immo = new JCheckBoxMenuItem("Immobilienwertermittlung II")
  immo.addItemListener(new ErgaenzungProfilListener(4))

  val boden = new JCheckBoxMenuItem("Bodenordnung II")
  boden.addItemListener(new ErgaenzungProfilListener(2))

  val karto = new JCheckBoxMenuItem("Kartographie II")
  karto.addItemListener(new ErgaenzungProfilListener(1))

  val umwelt = new JCheckBoxMenuItem("Umweltkommunikation")
  umwelt.addItemListener(new ErgaenzungProfilListener(2))

  val hydro = new JCheckBoxMenuItem("Hydrographische Vermessungen")
  hydro.addItemListener(new ErgaenzungProfilListener(1))

  val astro = new JCheckBoxMenuItem("Geod�tische Astronomie")
  astro.addItemListener(new ErgaenzungProfilListener(2))

  val strasse = new JCheckBoxMenuItem("Stra�enwesen f�r Geod�ten")
  strasse.addItemListener(new ErgaenzungProfilListener(2))

}
