

import javax.swing.JCheckBoxMenuItem

object KeyQualification {
  val key = new JCheckBoxMenuItem("Schl�sselqualifikationen")
  key.addItemListener(new KeyListener(4))
}