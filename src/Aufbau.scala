

import javax.swing.JCheckBoxMenuItem

object Aufbau {

  
  val schaetztheorie = new JCheckBoxMenuItem("Sch�tztheorie")
  schaetztheorie.addItemListener(new AufbauProfilListener(6))

  val datenanalyse = new JCheckBoxMenuItem("Sensorik und Datenanalyse")
  datenanalyse.addItemListener(new AufbauProfilListener(2))

  val mathe = new JCheckBoxMenuItem("Nummerische Mathematik")
  mathe.addItemListener(new AufbauProfilListener(6))

  val compVision = new JCheckBoxMenuItem("ComputerVision")
  compVision.addItemListener(new AufbauProfilListener(3))
  val senso = new JCheckBoxMenuItem("Geod�tische Sensorik")
  senso.addItemListener(new AufbauProfilListener(5))

  val weltRaum = new JCheckBoxMenuItem("Geod�tische Weltraumverfahren")
  weltRaum.addItemListener(new AufbauProfilListener(5))

  val geoinfo = new JCheckBoxMenuItem("Geoinformatik")
  geoinfo.addItemListener(new AufbauProfilListener(5))

}