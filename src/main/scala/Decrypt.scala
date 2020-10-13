import scala.io.StdIn

object Decrypt extends App {
  val toDecrypt: String = StdIn.readLine("Encrypted Text: ")
  val key: String = StdIn.readLine("Key: ")
  val toDecryptBytes: Array[Byte] = Cypher.hexStringToBytes(toDecrypt)

  val decrypted: String = Cypher.decrypt(toDecryptBytes, key)

  println("Result:")
  println(decrypted)

}


