/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.jasper;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

/**
 *
 * @author Fernando Santiago
 */
public class ExemploGeracaoRelatorio {
    
    private static final String XML = "<?xml version=\"1.0\" encoding=\"iso-8859-1\" ?><report><data><file><caminhoLogo>C:\\repositorio\\imagem\\logofiap.gif</caminhoLogo><numeroControle>23457894468309723008</numeroControle><nomeCurso>Desenvolvimento de Soluções Corporativas Java</nomeCurso><nomeDisciplina>Frameworks Utilitários</nomeDisciplina><resumoDisciplina>Nesta disciplina serão apresentados os frameworks utilitários mais difundidos no mercado.</resumoDisciplina><dataGeracao>01/04/2010 20:01</dataGeracao><alunos><aluno><matricula>A2311</matricula><nome>Manoel Ferreira Souza</nome><funcao>Programador Java</funcao><nomeEmpresa>FIAP</nomeEmpresa></aluno><aluno><matricula>A1022</matricula><nome>Eduardo Dias</nome><funcao>Arquiteto .NET</funcao><nomeEmpresa>Petrobras</nomeEmpresa></aluno></alunos></file></data></report>";

	private static final String CAMINHOJASPER = "C:\\repositorio\\jasper0.6.4\\listaDeAlunos.jasper";

	private static final String ARQUIVODESTINOPDF = "C:\\repositorio\\relatorio\\relatorio.pdf";

	private static final String ARQUIVODESTINOEXCEL = "C:\\repositorio\\relatorio\\relatorio.xls";

	private static final String ARQUIVODESTINOHTML = "C:\\repositorio\\relatorio\\relatorio.html";

	private static final String CAMINHOXPATH = "/report/data/file/alunos/aluno";

	public static void main(String[] args) throws Exception {
		File file = new File("c:\\repositorio\\relatorio");
		file.mkdir();

		gerarRelatorioPDF();
		gerarRelatorioExcel();
		gerarRelatorioHtml();
	}

	public static void gerarRelatorioPDF() {

		ByteArrayInputStream bais = new ByteArrayInputStream(XML.getBytes());
		JRExporter exporter = null;
		try {
			
			Map map = new HashMap();
			map.put("dataatual", new Date());
			
			JRXmlDataSource jrxmlds = new JRXmlDataSource(bais, CAMINHOXPATH);
			JasperPrint print = JasperFillManager.fillReport(CAMINHOJASPER,
					map, jrxmlds);

			exporter = new JRPdfExporter();

			exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
					ARQUIVODESTINOPDF);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.exportReport();
			System.out.println("Relatório PDF gerado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void gerarRelatorioExcel() {

		ByteArrayInputStream bais = new ByteArrayInputStream(XML.getBytes());
		JRExporter exporter = null;
		try {

			JRXmlDataSource jrxmlds = new JRXmlDataSource(bais, CAMINHOXPATH);
			JasperPrint print = JasperFillManager.fillReport(CAMINHOJASPER,
					new HashMap(), jrxmlds);

			exporter = new JRXlsExporter();
			exporter.setParameter(
					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
					Boolean.TRUE);

			exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
					ARQUIVODESTINOEXCEL);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.exportReport();
			System.out.println("Relatório EXCEL gerado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void gerarRelatorioHtml() {

		ByteArrayInputStream bais = new ByteArrayInputStream(XML.getBytes());
		JRExporter exporter = null;
		try {

			JRXmlDataSource jrxmlds = new JRXmlDataSource(bais, CAMINHOXPATH);
			JasperPrint print = JasperFillManager.fillReport(CAMINHOJASPER,
					new HashMap(), jrxmlds);

			exporter = new JRHtmlExporter();

			exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
					ARQUIVODESTINOHTML);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.exportReport();
			System.out.println("Relatório HTML gerado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
    
}
