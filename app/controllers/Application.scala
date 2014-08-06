package controllers

import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import views.html.ReportData

object Application extends Controller {

  def index = Action {
    Ok(views.html.report(reportForm))
  }

  val reportForm = Form(
    mapping(
      "name" -> nonEmptyText
    )(ReportData.apply)(ReportData.unapply)
  )

  def reportPost() = Action { implicit request =>
    val reportForm = controllers.Application.reportForm
    //#reportForm-handling-failure
    reportForm.bindFromRequest.fold(
      formWithErrors => {
        // binding failure, you retrieve the form containing errors:
        BadRequest(views.html.report(formWithErrors))
      },
      reportData => {
        /* binding success, you get the actual value. */
        Ok.sendFile(
          content = new java.io.File("/tmp/report.pdf"),
          inline = true,
          fileName = _ => "report.pdf"
        )
      }
    )
  }




}

