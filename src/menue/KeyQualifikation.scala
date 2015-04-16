

package menue

import javax.swing.JCheckBoxMenuItem
import listener.KeyListener

object KeyQualification {
  val key = new JCheckBoxMenuItem("Schlüsselqualifikationen")
  key.addItemListener(new KeyListener(4))
}