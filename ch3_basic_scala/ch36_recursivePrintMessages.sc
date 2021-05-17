class Msg(val id: Int, val parent: Option[Int], val txt: String)

val testMessages = Array(
  new Msg(0, None, "Hello"),
  new Msg(1, Some(0), "World"),
  new Msg(2, None, "I am Cow"),
  new Msg(3, Some(2), "Hear me moo"),
  new Msg(4, Some(2), "Here I stand"),
  new Msg(5, Some(2), "I am Cow"),
  new Msg(6, Some(5), "Here me moo, moo")
)
def printMessages(messages: Array[Msg]) = {
  def rec(message: Msg, indent: Int): Unit = {
    println(" " * indent + s"#${message.id} ${message.txt}")
    val children = messages.filter(_.parent == Some(message.id))
    if (children.length == 0) {} else
      for (child <- children) rec(child, indent + 3)
  }
  val parentless = messages.filter(_.parent == None)
  for (parent <- parentless) rec(parent, 0)
}
printMessages(testMessages)
