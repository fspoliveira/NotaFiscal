package br.com.fiap.jasper;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernando Santiago
 */


import java.io.FileNotFoundException;
import java.util.HashMap;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.view.JasperViewer;


public class XMLDataSourceSample {
    
    public static void main(String[] args) throws FileNotFoundException, JRException {
        JasperReport jasperReport = null;
        String recordPath = "/report/data/notasfiscaisservico/nota";
        String xmlFileName = "notasFiscais.xml";
        String path = "C:\\Users\\Fernando Santiago\\Documents\\NetBeansProjects\\NotaFiscal\\src\\java\\br\\com\\fiap\\jasper\\";
        JasperPrint jasperPrint;
    
        //Provide path for your JRXML template.
        String templateName = path + "NotaFiscal.jrxml";

        //Provide path for your final pdf file.
        String destinationFile = path + "NotaFiscal.pdf";

        //Compiling the template.
        jasperReport = JasperCompileManager.compileReport(templateName);

        //Sending a parameter with the logged in user name as value
        HashMap parameters = new HashMap();
        //Creating the datasource
        JRXmlDataSource jrxmlds = new JRXmlDataSource(path+xmlFileName, recordPath);

        // Filling the report template with data
        jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,jrxmlds);

        JasperViewer.viewReport(jasperPrint);

        //Exporting it to an PDF
        JasperExportManager.exportReportToPdfFile(jasperPrint, destinationFile);
        
      

    }   
    
}
