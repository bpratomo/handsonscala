
package ammonite
package $file.ch3_basic_scala
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


object ex37_contextManagers{
/*<script>*/import java.nio.file.Files
import java.nio.file.Path
import java.io.BufferedWriter
import java.nio.file.Paths
import java.io.BufferedReader

def withFileWriter(fileName: String)(instruction: BufferedWriter => Unit) = {
  val writer =
    Files.newBufferedWriter(Paths.get(fileName))
  try instruction(writer)
  finally writer.close()

}
/*<amm>*/val res_6 = /*</amm>*/withFileWriter("File.txt") { writer =>
  writer.write("Hello\n"); writer.write("World!")
}

def withFileReader[T](fileName: String)(instruction: BufferedReader => T) = {
  val reader =
    Files.newBufferedReader(Paths.get(fileName))
  try instruction(reader)
  finally reader.close()

}
val result = withFileReader("File.txt") { reader =>
  reader.readLine() + "\n" + reader.readLine()
}
/*<amm>*/val res_9 = /*</amm>*/assert(result == "Hello\nWorld!")
/*</script>*/ /*<generated>*/
def $main() = { scala.Iterator[String]() }
  override def toString = "ex37_contextManagers"
  /*</generated>*/
}
