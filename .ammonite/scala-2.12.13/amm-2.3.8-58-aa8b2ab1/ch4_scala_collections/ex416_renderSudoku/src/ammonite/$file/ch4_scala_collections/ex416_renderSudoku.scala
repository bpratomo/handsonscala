
package ammonite
package $file.ch4_scala_collections
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


object ex416_renderSudoku{
/*<script>*/val correctArray = Array(
  Array(3, 1, 6, 5, 7, 8, 4, 9, 2),
  Array(5, 2, 9, 1, 3, 4, 7, 6, 8),
  Array(4, 8, 7, 6, 2, 9, 5, 3, 1),
  Array(2, 6, 3, 0, 1, 0, 0, 8, 0),
  Array(9, 7, 4, 8, 6, 3, 0, 0, 5),
  Array(8, 5, 1, 0, 9, 0, 6, 0, 0),
  Array(1, 3, 0, 0, 0, 0, 2, 5, 0),
  Array(0, 0, 0, 0, 0, 0, 0, 7, 4),
  Array(0, 0, 5, 2, 0, 6, 3, 0, 0)
)

def renderSudoku(grid: Array[Array[Int]]): String = {
  var output = ""
  Range(0, 9).foreach { s =>
    if (s % 3 == 0) output = output + "-" * 12 + "\n"
    val splitRow = grid(s)
      .grouped(3)
      .toArray
      .map(_.mkString("")) //inner aggregation
      .mkString("|") //putting the bar between squares
    output = output +
      "|" + splitRow + "|\n"

  }

  output
}

def correctRenderSudoku(grid: Array[Array[Int]]) = {
  val rowSeparator = "\n+-------+-------+-------+\n"
  grid
    .map(row =>
      row
        .map(i => if(i == 0) " " else i.toString)
        .grouped(3)
        .map(_.mkString(" "))
        .mkString("| ", " | ", " |")
    )
    .grouped(3)
    .map(_.mkString("\n"))
    .mkString(rowSeparator, rowSeparator, rowSeparator)
}
/*<amm>*/val res_3 = /*</amm>*/println(correctRenderSudoku(correctArray))/*</script>*/ /*<generated>*/
def $main() = { scala.Iterator[String]() }
  override def toString = "ex416_renderSudoku"
  /*</generated>*/
}
