package dotty.xml.interpolator

import scala.quoted._

type Scope = scala.xml.NamespaceBinding
implicit val top: Scope = scala.xml.TopScope

inline def (ctx: => StringContext) xml (args: => ((given Scope) => Any)*)(given scope: Scope) <: Any =
  ${ dotty.xml.interpolator.internal.Macro.impl('ctx, 'args, 'scope) }
