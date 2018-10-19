package handlers;

import spark.Request;
import spark.Response;
import spark.Route;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import configs.Mail;

public class MailHandler{
  public static Route wellcome = (Request request, Response response) -> {
	  String rpta = "";
	  int status = 200;
	  try {
		  String name = request.queryParams("name");
      String email = request.queryParams("email");
      //template data to replace with string format
      Map<String, String> locals = new HashMap<String, String>();
      locals.put("nombre", name);
      // creating email
      //- layout, partial, language
      Mail mail = new Mail("blank", "demo", "en"); 
      // user name registred in application.conf/mailer/users/{name}
      mail.setMailer("demo");
      //- userName, destinationName, destiationEmail, ccoName, subjectName, language, localsPartial in application.conf/email
      mail.setEMail("demo", "C. Tevez", email, "pepe", "wellcome", "en", locals);
      //System.out.println(mail.getBody());
      // send
      mail.sendMail();
      rpta = "ok";
    } catch (Exception e) {
      e.printStackTrace();
      String[] cuerpoMensaje = {"There was an error in sending the email", e.toString()};
      JSONObject rptaMensaje = new JSONObject();
      rptaMensaje.put("tipo_mensaje", "error");
      rptaMensaje.put("mensaje", cuerpoMensaje);
      status = 500;
      rpta = rptaMensaje.toString();
    } finally {
      response.status(status);
    	return rpta;
    }
  };
}