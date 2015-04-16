package wahlPflicht

import scala.collection.mutable.MutableList
import scala.io.Source
import wahlPflicht.WahlPflichtModul

object WahlPflichtManager {

  val wahlPflichtList = loadWahlFile("WahlPflichtModule.txt");
  
  
  
  def loadWahlFile(fileName: String) : MutableList[WahlPflichtModul] = {
    val list = new MutableList[WahlPflichtModul]();
    val fileLines = Source.fromFile(fileName).getLines
    fileLines.foreach(line => {
      val l = line.split(",")
      list += (new WahlPflichtModul(l(0),l(1).toDouble));
    })
    println(fileLines.map(line => {val l = line.split(",")
      new WahlPflichtModul(l(0),l(1).toDouble)
    }))
    return list;
  }
  
}