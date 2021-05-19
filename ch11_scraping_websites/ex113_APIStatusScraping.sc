import $ivy.`org.jsoup:jsoup:1.13.1`, org.jsoup._ 
import $ivy.`com.lihaoyi::upickle:1.3.8`
import collection.JavaConverters._
val url = "https://developer.mozilla.org/en-US/docs/Web/API"
val doc = Jsoup.connect(url).get()
val entries = doc.select("div.index li").asScala
var records = ujson.Arr()
for(entry <- entries){

    val link = url + entry.children.select("a").attr("href")
    val apiName = entry.children.select("a").text()
    val apiStatus = entry.children.select("svg").attr("class").split(" ").last
    records.arr.append(ujson.Obj("link" -> link, "apiName"-> apiName, "apiStatus" -> apiStatus))

}
os.write(os.pwd / "apistatus.json",ujson.write(records,indent=4))

// //div[@class="index"]//li
// //div[@class="index"]//li//*[name()='svg'] selector for the icons

// div.index  li  selector for the item 
// div.index li a selector for the link
// div.index li  svg selector for the svg 