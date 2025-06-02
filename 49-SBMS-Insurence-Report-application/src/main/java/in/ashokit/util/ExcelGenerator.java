package in.ashokit.util;

import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenPlanRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator {
	
	@Autowired
	private CitizenPlanRepository planRepo;
	
	public boolean exportExcel(HttpServletResponse response) throws Exception {
	    List<CitizenPlan> records = planRepo.findAll();

	    XSSFWorkbook workbook = new XSSFWorkbook();
	    Sheet sheet = workbook.createSheet("plans-data");

	    Row headerRow = sheet.createRow(0);
	    headerRow.createCell(0).setCellValue("ID");
	    headerRow.createCell(1).setCellValue("Citizen Name");
	    headerRow.createCell(2).setCellValue("Plan Name");
	    headerRow.createCell(3).setCellValue("Plan Status");
	    headerRow.createCell(4).setCellValue("Plan Start Date");
	    headerRow.createCell(5).setCellValue("Plan End Date");
	    headerRow.createCell(6).setCellValue("Benefit Amount");

	    int dataRowIndex = 1;
	    for (CitizenPlan plan : records) {
	        Row row = sheet.createRow(dataRowIndex++);
	        row.createCell(0).setCellValue(plan.getCitizenId());
	        row.createCell(1).setCellValue(plan.getCitizenName());
	        row.createCell(2).setCellValue(plan.getPlanName());
	        row.createCell(3).setCellValue(plan.getPlanStatus());
	        row.createCell(4).setCellValue(plan.getPlanStartDate() != null ? plan.getPlanStartDate().toString() : "N/A");
	        row.createCell(5).setCellValue(plan.getPlanEndDate() != null ? plan.getPlanEndDate().toString() : "N/A");
	        row.createCell(6).setCellValue(plan.getBenefitAmt() != null ? plan.getBenefitAmt() : 0.0);
	    }

	    // Set content type for .xlsx
	    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	    response.setHeader("Content-Disposition", "attachment; filename=plans.xlsx");
	    
	    
	    ServletOutputStream outputStream = response.getOutputStream();
	    workbook.write(outputStream);
	    
	    workbook.write(response.getOutputStream());
	    
	    workbook.close();
	    
	    return true;
	}
}
