package com.jasper;

import java.io.File;
import java.io.FileInputStream;
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

public class JasperReportExample {

	public static void main(String[] args) {

		try {

			List<Employee> employees = new ArrayList();
			Employee employee = new Employee();
			employee.setId(1);
			employee.setFirstName("May");
			employee.setLastName("Thin");
			employee.setAddress("Taungoo");
			employee.setSalary(1200000.00);

			Employee employee1 = new Employee();
			employee1.setId(2);
			employee1.setFirstName("Kha");
			employee1.setLastName("Kha");
			employee1.setAddress("Taungoo");
			employee1.setSalary(1200000.00);

			employees.add(employee);
			employees.add(employee1);

			JasperReportExample example = new JasperReportExample();
			// Use an absolute path
			InputStream report = example.getClass().getResourceAsStream("/com/jasper/testing.jrxml");

			// Use absolute path
			String filePath = "C:/Users/A100120/MoMoney/Development/Projects/Test/JasperReportTesting/src/main/java/com/jasper/testing.jrxml";

			// Debugging: Check if file exists
			File file = new File(filePath);
			if (!file.exists()) {
				System.out.println("File does not exist at: " + file.getAbsolutePath());
				return;
			}

			JasperReport jasperReport = JasperCompileManager.compileReport(filePath);
			
			//Convert list to JRBeanCollectionDataSource
			JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(employees);
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("CollectionBeanParam", beanCollectionDataSource);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
			// Export to PDF
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					"C:/Users/A100120/MoMoney/Development/Projects/Test/JasperReportTesting/src/main/java/com/jasper/testing.pdf");

			// Export to HTML
//			JasperExportManager.exportReportToHtmlFile(jasperPrint,
//					"C:/Users/A100120/MoMoney/Development/Projects/Test/JasperReportTesting/src/main/java/com/jasper/testing.html");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
