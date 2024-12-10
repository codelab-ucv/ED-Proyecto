package ucv.codelab.mensaje;

import java.io.ByteArrayOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.swing.JOptionPane;

import ucv.codelab.cache.Client;

public class SendEmail {

    public static boolean send(Client client) {
        try {
            // TODO Se debe añadir el correo como usuario y la contraseña de aplicacion
            final String username = "";
            final String password = "";

            // Propiedades de la sesion de email
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");

            // Crea la sesion
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            // Crea el mensaje
            Message message = new MimeMessage(session);

            // Establece el correo emisor y destinatario
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(client.email));

            // Crea el asunto
            String asunto = "Boleta de compra #";
            for (int i = 100000; i > client.getCurrentOrder().getID(); i /= 10) {
                asunto += "0";
            }
            asunto += client.getCurrentOrder().getID();
            message.setSubject(asunto);

            // Crea el cuerpo
            Multipart multipart = new MimeMultipart();

            // Parte del texto
            MimeBodyPart texto = new MimeBodyPart();
            texto.setContent(
                    "<html>"
                            + "<body>"
                            + "<p>Estimado " + client.NAME + ",</p>"
                            + "<p>Adjuntamos el comprobante de la compra realizada en la Tienda Artel.</p>"
                            + "<p>Gracias por su preferencia.</p>"
                            + "</body>"
                            + "</html>",
                    "text/html; charset=UTF-8");

            // Parte del adjunto
            MimeBodyPart documentos = new MimeBodyPart();
            ByteArrayOutputStream pdf = MakePdf.make(client);
            DataSource source = new ByteArrayDataSource(pdf.toByteArray(), "application/pdf");
            documentos.setDataHandler(new DataHandler(source));
            documentos.setFileName(asunto + ".pdf");

            // Añade ambas partes al cuerpo del correo
            multipart.addBodyPart(texto);
            multipart.addBodyPart(documentos);

            // Añade el contenido al correo
            message.setContent(multipart);

            // Envia el mensaje
            Transport.send(message);

            // Envio correcto
            JOptionPane.showMessageDialog(null, "Comprobante enviado al correo " + client.email + " con éxito",
                    "Confirmacion de envio", JOptionPane.PLAIN_MESSAGE);
            return true;
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "Error en el envio del mensaje al correo.\nVerificar que el email \""
                    + client.email + "\" sea válido", "Fallo al enviar comprobante", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
