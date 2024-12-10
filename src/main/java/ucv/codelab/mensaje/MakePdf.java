package ucv.codelab.mensaje;

import java.io.ByteArrayOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;

import ucv.codelab.cache.Client;
import ucv.codelab.cache.SubOrder;
import ucv.codelab.gui.Utils;

public class MakePdf implements Utils {

    @SuppressWarnings("ConvertToTryWithResources")
    public static ByteArrayOutputStream make(Client client) {
        // Generar el pdf solo en memoria
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter pdfWriter = new PdfWriter(baos);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        //float maxWidht = document.getPdfDocument().getDefaultPageSize().getWidth() - document.getLeftMargin() - document.getRightMargin();
        // Cabecera
        document.add(cabecera(client));
        document.add(clientData(client));

        // Carga la lista de productos
        Table productList = productList(client);
        document.add(new Paragraph().add(productList));

        // Carga el apartado del total
        document.add(total(client));

        document.close();
        pdfDocument.close();

        return baos;
    }

    private static Table cabecera(Client client) {
        // Formato para la fecha
        String pattern = "dd/MM/yy hh:mm aa";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(client.getCurrentOrder().getDate());

        // Formato del numero de boleta
        String boleta = "#";
        for (int i = 100000; i > client.getCurrentOrder().getID(); i /= 10) {
            boleta += "0";
        }
        boleta += client.getCurrentOrder().getID();

        // Agregar datos de la tienda    
        Paragraph datos = new Paragraph("""
            Tienda Artel
            Av Alfredo Mendiola 6232
            Los Olivos - Lima - Lima
            """
                + date);

        // Agregar información de la boleta
        Paragraph titulo = new Paragraph("BOLETA DE VENTA ELECTRONICA");
        titulo.setTextAlignment(TextAlignment.CENTER);
        titulo.setBackgroundColor(new DeviceRgb(BOTON));

        Paragraph comprobante = new Paragraph("RUC: 20745506568\n" + boleta);
        comprobante.setTextAlignment(TextAlignment.CENTER);

        // Crea la tabla con ambos datos
        float[] anchoColumnas = {270f, 130f};
        Table cabecera = new Table(anchoColumnas);
        cabecera.setWidth(523);

        Cell izquierda = new Cell().add(datos).setTextAlignment(TextAlignment.LEFT);
        izquierda.setBorder(null);
        cabecera.addCell(izquierda);

        Cell derecha = new Cell().add(titulo).add(comprobante).setTextAlignment(TextAlignment.RIGHT);
        cabecera.addCell(derecha);

        return cabecera;
    }

    private static Table clientData(Client client) {
        Paragraph nombre = new Paragraph("Cliente: " + client.NAME);

        Paragraph documento = new Paragraph("DNI: " + client.DNI);

        // Crea la tabla con ambos datos
        float[] anchoColumnas = {275f, 125f};
        Table clientData = new Table(anchoColumnas);
        clientData.setWidth(523);

        Cell izquierda = new Cell().add(nombre);
        izquierda.setBorder(null);
        clientData.addCell(izquierda);

        Cell derecha = new Cell().add(documento);
        derecha.setBorder(null);
        clientData.addCell(derecha);

        return clientData;
    }

    private static Table productList(Client client) {
        // Se escribe la tabla
        float[] anchoColumnas = {45f, 306f, 45f, 70f, 55f};
        Table tablaProductos = new Table(anchoColumnas);
        tablaProductos.setWidth(523);
        tablaProductos.addHeaderCell("Codigo").setTextAlignment(TextAlignment.CENTER);
        tablaProductos.addHeaderCell("Producto").setTextAlignment(TextAlignment.CENTER);
        tablaProductos.addHeaderCell("Cantidad").setTextAlignment(TextAlignment.CENTER);
        tablaProductos.addHeaderCell("Valor Unitario").setTextAlignment(TextAlignment.CENTER);
        tablaProductos.addHeaderCell("Importe de Venta").setTextAlignment(TextAlignment.CENTER);

        DecimalFormat df = new DecimalFormat("0.00");

        for (SubOrder subOrder : client.getCurrentOrder().getItems()) {
            float precioTotal = subOrder.getProduct().PRICE * subOrder.getQuantity();

            tablaProductos.addCell(subOrder.getProduct().ID + "");
            tablaProductos.addCell(subOrder.getProduct().NAME);
            tablaProductos.addCell(subOrder.getQuantity() + "");
            tablaProductos.addCell(df.format(subOrder.getProduct().PRICE));
            tablaProductos.addCell(df.format(precioTotal));
        }
        return tablaProductos;
    }

    private static Table total(Client client) {
        // Carga los datos        
        DecimalFormat df = new DecimalFormat("0.00");

        float subTotal = 0.82f * client.getCurrentOrder().getTotal();
        float igv = client.getCurrentOrder().getTotal() - subTotal;

        // Se escribe la tabla
        float[] anchoColumnas = {70f, 55f};
        Table total = new Table(anchoColumnas);
        total.setWidth(125);

        total.addCell("Sub Total:");
        total.addCell(df.format(subTotal));

        total.addCell("IGV (18%):");
        total.addCell(df.format(igv));

        total.addCell("Total:");
        total.addCell(df.format(client.getCurrentOrder().getTotal()));

        total.setHorizontalAlignment(HorizontalAlignment.RIGHT);

        Color color = new DeviceRgb(125, 214, 223);
        total.getCell(0, 0).setBackgroundColor(color);
        total.getCell(1, 0).setBackgroundColor(color);
        total.getCell(2, 0).setBackgroundColor(color);

        return total;
    }
}
