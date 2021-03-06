package com.truecar.mleap.runtime.transformer

import com.truecar.mleap.runtime.LeapFrame
import com.truecar.mleap.runtime.attribute.AttributeSchema
import com.truecar.mleap.runtime.transformer.builder.{LeapFrameBuilder, TransformBuilder}
import com.truecar.mleap.runtime.types.StructType

import scala.util.Try


/**
  * Created by hwilkins on 10/22/15.
  */
case class TransformerSchema(input: StructType, output: StructType)

trait Transformer {
  def transform[L: LeapFrame](frame: L): Try[L] = build(LeapFrameBuilder(frame)).map(_.frame)
  def transformAttributeSchema(schema: AttributeSchema): AttributeSchema
  def build[TB: TransformBuilder](builder: TB): Try[TB]
}
