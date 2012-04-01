import java.io.IOException;
import java.util.HashMap;
import net.sf.jasperreports.engine.*;

public class MyReportViewer {
  public static void main(String[] args) throws JRException, IOException {
   
    JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\Fernando Santiago\\Documents\\NetBeansProjects\\NotaFiscal\\src\\java\\NotaFiscal.jrxml");
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,new HashMap(), new JREmptyDataSource());
    JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\Fernando Santiago\\Documents\\NetBeansProjects\\NotaFiscal\\src\\java\\sample.pdf");
  }
}