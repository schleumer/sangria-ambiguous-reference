package example.workaround

import sangria.schema.{ Field, InterfaceType, ObjectType, StringType, fields, interfaces }

class GraphQLTypes {
  import Classes._

  val TestInterfaceType: InterfaceType[Classes.TestContext, TestInterface] = InterfaceType(
    "TestInterface",
    "",
    fields[Classes.TestContext, TestInterface](
      Field("name", StringType, resolve = c => c.value.name),
    )
  )

  val TestInterfacee1Type = ObjectType(
    "TestInterfacee1",
    interfaces[Classes.TestContext, TestInterfacee1](TestInterfaceType),
    fields = fields[Classes.TestContext, TestInterfacee1](
      Field("local1", StringType, resolve = c => c.value.local1),
    )
  )

  val TestInterfacee2Type = ObjectType(
    "TestInterfacee2",
    interfaces[Classes.TestContext, TestInterfacee2](TestInterfaceType),
    fields = fields[Classes.TestContext, TestInterfacee2](
      Field("local2", StringType, resolve = c => c.value.local2),
    )
  )
}
