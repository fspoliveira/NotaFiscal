/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.print;

import java.io.FileNotFoundException;
import java.util.HashMap;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Fernando Santiago
 */
public class PrintBoleto {

    public static void main(String[] args) throws FileNotFoundException, JRException {
        
        JasperReport jasperReport = null;
        String recordPath = "/report/data/boleto";
        String xmlFileName = "notasFiscais.xml";
        String path = "C:\\Users\\Fernando Santiago\\Documents\\NetBeansProjects\\NotaFiscal\\src\\java\\br\\com\\fiap\\jasper\\";
        String pathRoot = "C:\\Users\\Fernando Santiago\\Documents\\NetBeansProjects\\NotaFiscal\\src\\java\\";
        JasperPrint jasperPrint;

        String templateName = pathRoot + "Boleto.jrxml";

        String destinationFile = path + "Boleto.pdf";

        jasperReport = JasperCompileManager.compileReport(templateName);

        HashMap parameters = new HashMap();

        JRXmlDataSource jrxmlds = new JRXmlDataSource(path + xmlFileName, recordPath);

        jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrxmlds);

        JasperViewer.viewReport(jasperPrint);

        JasperExportManager.exportReportToPdfFile(jasperPrint, destinationFile);
    }
}
