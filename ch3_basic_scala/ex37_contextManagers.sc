import java.nio.file.Files
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
withFileWriter("File.txt") { writer =>
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
assert(result == "Hello\nWorld!")
