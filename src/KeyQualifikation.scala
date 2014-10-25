

import javax.swing.JCheckBoxMenuItem

object KeyQualification {
  val key = new JCheckBoxMenuItem("Schlüsselqualifikationen")
  key.addItemListener(new KeyListener(4))
}