package com.jasper;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class SutdentJasperReport {

	public static void main(String[] args) {

		try {

			JasperReportExample example = new JasperReportExample();
			// Use an absolute path
			InputStream report = example.getClass().getResourceAsStream("/com/jasper/score_card.jrxml");

			// Use absolute path
			String filePath = "C:/Users/A100120/MoMoney/Development/Projects/Test/JasperReportTesting/src/main/java/com/jasper/score_card.jrxml";

			// Debugging: Check if file exists
			File file = new File(filePath);
			if (!file.exists()) {
				System.out.println("File does not exist at: " + file.getAbsolutePath());
				return;
			}

			JasperReport jasperReport = JasperCompileManager.compileReport(filePath);

			List<Student> students = new ArrayList<Student>();
			Student stu = new Student("May", "2017", "Thin", "2012-2017");

			students.add(stu);
			// Convert list to JRBeanCollectionDataSource
			JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(students);
			
			List<StudentScore> studentScores = new ArrayList<StudentScore>();
			studentScores.add(new StudentScore("MM", 100.0, 80.0));

			studentScores.add(new StudentScore("MM1", 100.0, 70.0));

			studentScores.add(new StudentScore("MM2", 100.0, 97.0));

			studentScores.add(new StudentScore("MM3", 100.0, 96.0));

			studentScores.add(new StudentScore("MM4", 100.0, 67.0));

			studentScores.add(new StudentScore("MM5", 100.0, 89.0));
			
			
			JRBeanCollectionDataSource tableJRBeanCollectionDataSource = new JRBeanCollectionDataSource(studentScores);
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("TABLE_DATA_SOURCE", tableJRBeanCollectionDataSource);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanCollectionDataSource);
			// Export to PDF
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					"C:/Users/A100120/MoMoney/Development/Projects/Test/JasperReportTesting/src/main/java/com/jasper/score_card.pdf");

			// Export to HTML
//			JasperExportManager.exportReportToHtmlFile(jasperPrint,
//					"C:/Users/A100120/MoMoney/Development/Projects/Test/JasperReportTesting/src/main/java/com/jasper/testing.html");
			
			System.out.println("Report generate successfully...");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
