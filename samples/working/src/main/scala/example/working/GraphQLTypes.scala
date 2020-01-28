package example.working

import sangria.schema.{ Field, InterfaceType, ObjectType, StringType, fields, interfaces }

class GraphQLTypes {
  import Classes._

  val TestInterfaceType: InterfaceType[Unit, TestInterface] = InterfaceType(
    "TestInterface",
    "",
    fields[Unit, TestInterface](
      Field("name", StringType, resolve = c => c.value.name),
    )
  )

  val TestInterfacee1Type = ObjectType(
    "TestInterfacee1",
    interfaces[Unit, TestInterfacee1](TestInterfaceType),
    fields = fields[Unit, TestInterfacee1](
      Field("local1", StringType, resolve = c => c.value.local1),
    )
  )

  val TestInterfacee2Type = ObjectType(
    "TestInterfacee2",
    interfaces[Unit, TestInterfacee2](TestInterfaceType),
    fields = fields[Unit, TestInterfacee2](
      Field("local2", StringType, resolve = c => c.value.local2),
    )
  )
}
