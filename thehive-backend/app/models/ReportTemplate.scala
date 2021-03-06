package models

import javax.inject.{ Inject, Singleton }

import play.api.libs.json.JsObject

import org.elastic4play.models.{ AttributeDef, AttributeFormat ⇒ F, EntityDef, ModelDef }

trait ReportTemplateAttributes { _: AttributeDef ⇒
  val content = attribute("content", F.textFmt, "Content of the template")
  val reportType = attribute("reportType", F.stringFmt, "Type of the report (short or long)")
  val analyzerId = multiAttribute("analyzerId", F.stringFmt, "Id of analyzers")
}

@Singleton
class ReportTemplateModel @Inject() extends ModelDef[ReportTemplateModel, ReportTemplate]("reportTemplate") with ReportTemplateAttributes
class ReportTemplate(model: ReportTemplateModel, attributes: JsObject) extends EntityDef[ReportTemplateModel, ReportTemplate](model, attributes) with ReportTemplateAttributes
