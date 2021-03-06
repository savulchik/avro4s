package com.sksamuel.avro4s.cats

import cats.data.NonEmptyList
import com.sksamuel.avro4s.{AvroSchema, NamingStrategy, SchemaFor}
import org.apache.avro.Schema
import org.scalatest.{FunSuite, Matchers}

import scala.language.implicitConversions

case class Foo(list: NonEmptyList[String])

class CatsTest extends FunSuite with Matchers {

  implicit def nonEmptyListSchemaFor[T](schemaFor: SchemaFor[T]): SchemaFor[NonEmptyList[T]] = {
    new SchemaFor[NonEmptyList[T]] {
      override def schema(namingStrategy: NamingStrategy) = Schema.createArray(schemaFor.schema(namingStrategy))
    }
  }

  ignore("cats") {
    AvroSchema[Foo] shouldBe """"""
  }
}
