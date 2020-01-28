package example.working

import sangria.schema.{ Field, ObjectType, OptionType, PossibleObject, Schema, StringType, fields }
import scala.util.Random

object GraphQLSchema {
  val types = new GraphQLTypes

  val QueryType = ObjectType("Query", fields[Unit, Unit](
    Field(
      name = "test",
      description = None,
      fieldType = OptionType(types.TestInterfaceType),
      possibleTypes = List(
        types.TestInterfacee1Type,
        types.TestInterfacee2Type
      ),
      resolve = (ctx) => {
        Random.between(1, 2) match {
          case 1 => Classes.TestInterfacee1("okey1", "dokey1")
          case 2 => Classes.TestInterfacee2("okey2", "dokey2")
        }
      }
    )
  ))

  val root = Schema(QueryType)
}
