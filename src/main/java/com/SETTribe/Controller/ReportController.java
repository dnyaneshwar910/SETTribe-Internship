package com.SETTribe.Controller;

import com.SETTribe.Model.Admission;
import com.SETTribe.Service.AdmissionService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private AdmissionService admissionService;

    @GetMapping("/export")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=admissions.xlsx");

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Admissions");

        Row headerRow = sheet.createRow(0);
        String[] columns = {"ID", "Full Name", "Mobile Number", "Email", "Date of Birth", "Age", "State", "District", "Religion", "Caste"};
        for (int i = 0; i < columns.length; i++) {
            headerRow.createCell(i).setCellValue(columns[i]);
        }

        List<Admission> admissions = admissionService.getAllAdmissions();
        int rowNum = 1;
        for (Admission admission : admissions) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(admission.getAdmissionId());
            row.createCell(1).setCellValue(admission.getFullName());
            row.createCell(2).setCellValue(admission.getMobileNumber());
            row.createCell(3).setCellValue(admission.getEmail());
            row.createCell(4).setCellValue(admission.getDateOfBirth().toString());
            row.createCell(5).setCellValue(admission.getAge());
            row.createCell(6).setCellValue(admission.getState());
            row.createCell(7).setCellValue(admission.getDistrict());
            row.createCell(8).setCellValue(admission.getReligion());
            row.createCell(9).setCellValue(admission.getCaste());
        }

        workbook.write(response.getOutputStream());
        workbook.close();
    }
}
