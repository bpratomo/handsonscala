
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


object ex415_partialValidSudoku{
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

val falseArray = Array(
 Array(3, 1, 6, 5, 7, 8, 4, 9, 3),
 Array(5, 2, 9, 1, 3, 4, 7, 6, 8),
 Array(4, 8, 7, 6, 2, 9, 5, 3, 1),
 Array(2, 6, 3, 0, 1, 0, 0, 8, 0),
 Array(9, 7, 4, 8, 6, 3, 0, 0, 5),
 Array(8, 5, 1, 0, 9, 0, 6, 0, 0),
 Array(1, 3, 0, 0, 0, 0, 2, 5, 0),
 Array(0, 0, 0, 0, 0, 0, 0, 7, 4),
 Array(0, 0, 5, 2, 0, 6, 3, 0, 0)
 )

//  Try playing with this first
def isValidSudoku(grid: Array[Array[Int]]): Boolean = {
  !Range(0, 9).exists { s =>
    val row = Range(0, 9).map(grid(s)(_)).filter(_>0)
    val col = Range(0, 9).map(grid(_)(s)).filter(_>0)
    val square = Range(0, 9).map { j =>
      val startingRow = (s / 3) * 3
      val rowIndex = startingRow + j % 3
      val startingCol = s % 3 * 3
      val colIndex = startingCol + j / 3
      grid(rowIndex)(colIndex)
    }.filter(_>0)
    row.distinct.length != row.length ||
    col.distinct.length != col.length ||
    square.distinct.length != square.length

  }
}
/*<amm>*/val res_3 = /*</amm>*/println(isValidSudoku(correctArray))
/*<amm>*/val res_4 = /*</amm>*/println(isValidSudoku((falseArray)))/*</script>*/ /*<generated>*/
def $main() = { scala.Iterator[String]() }
  override def toString = "ex415_partialValidSudoku"
  /*</generated>*/
}
