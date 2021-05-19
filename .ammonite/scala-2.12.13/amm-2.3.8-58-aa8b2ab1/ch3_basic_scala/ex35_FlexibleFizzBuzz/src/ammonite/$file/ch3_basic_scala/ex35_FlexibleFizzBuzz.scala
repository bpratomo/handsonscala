
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


object ex35_FlexibleFizzBuzz{
/*<script>*/def flexibleFizzBuzz(f: String => Unit, range: Int) = {
    def rec(counter:Int, f: String =>Unit): Unit = {
        val output = (counter %3, counter %5) match {
            case (0,0) => "FizzBuzz"
            case (0, _) => "Fizz"
            case (_, 0) => "Buzz"
            case (_, _) => counter.toString
        }
        f(output)
        if(counter == range) {}
        else rec(counter+1,f)
    }
    rec(0,f)
    
}/*</script>*/ /*<generated>*/
def $main() = { scala.Iterator[String]() }
  override def toString = "ex35_FlexibleFizzBuzz"
  /*</generated>*/
}
