package example.workaround

import io.circe.generic.semiauto.{ deriveDecoder, deriveEncoder }
import io.circe.{ Decoder, Encoder, Json }

object Classes {
  class TestContext {
    val value = "ok"
  }

  trait TestInterface {
    val name: String
  }

  case class TestInterfacee1(name: String, local1: String) extends TestInterface

  implicit val TestInterfacee1Encoder: Encoder[TestInterfacee1] = deriveEncoder[TestInterfacee1]
  implicit val TestInterfacee1Decoder: Decoder[TestInterfacee1] = deriveDecoder[TestInterfacee1]

  case class TestInterfacee2(name: String, local2: String) extends TestInterface

  implicit val TestInterfacee2Encoder: Encoder[TestInterfacee2] = deriveEncoder[TestInterfacee2]
  implicit val TestInterfacee2Decoder: Decoder[TestInterfacee2] = deriveDecoder[TestInterfacee2]

  case class Request(
    query: String,
    operationName: Option[String],
    variables: Option[Json]
  )

  implicit val RequestEncoder: Encoder[Request] = deriveEncoder[Request]
  implicit val RequestDecoder: Decoder[Request] = deriveDecoder[Request]
}
