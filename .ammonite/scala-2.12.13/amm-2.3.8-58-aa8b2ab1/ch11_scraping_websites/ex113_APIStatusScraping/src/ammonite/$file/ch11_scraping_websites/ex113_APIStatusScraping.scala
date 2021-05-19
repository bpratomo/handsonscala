
package ammonite
package $file.ch11_scraping_websites
import _root_.ammonite.interp.api.InterpBridge.{
  value => interp
}
import _root_.ammonite.interp.api.InterpBridge.value.{
  exit
}
import _root_.ammonite.interp.api.IvyConstructor.{
  ArtifactIdExt,
  GroupIdExt
}
import _root_.ammonite.compiler.CompilerExtensions.{
  CompilerInterpAPIExtensions,
  CompilerReplAPIExtensions
}
import _root_.ammonite.runtime.tools.{
  browse,
  grep,
  time,
  tail
}
import _root_.ammonite.compiler.tools.{
  desugar,
  source
}
import _root_.mainargs.{
  arg,
  main
}
import _root_.ammonite.repl.tools.Util.{
  PathRead
}


object ex113_APIStatusScraping{
/*<script>*/import $ivy.$                       , org.jsoup._ 
import $ivy.$                           
import collection.JavaConverters._
val url = "https://developer.mozilla.org/en-US/docs/Web/API"
val doc = Jsoup.connect(url).get()
val entries = doc.select("div.index li").asScala
var records = ujson.Arr()
/*<amm>*/val res_7 = /*</amm>*/for(entry <- entries){

    val link = url + entry.children.select("a").attr("href")
    val apiName = entry.children.select("a").text()
    val apiStatus = entry.children.select("svg").attr("class").split(" ").last
    records.arr.append(ujson.Obj("link" -> link, "apiName"-> apiName, "apiStatus" -> apiStatus))

}
/*<amm>*/val res_8 = /*</amm>*/os.write(os.pwd / "apistatus.json",ujson.write(records,indent=4))

// //div[@class="index"]//li
// //div[@class="index"]//li//*[name()='svg'] selector for the icons

// div.index  li  selector for the item 
// div.index li a selector for the link
// div.index li  svg selector for the svg /*</script>*/ /*<generated>*/
def $main() = { scala.Iterator[String]() }
  override def toString = "ex113_APIStatusScraping"
  /*</generated>*/
}
