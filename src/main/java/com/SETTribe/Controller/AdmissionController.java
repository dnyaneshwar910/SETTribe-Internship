package com.SETTribe.Controller;

import com.SETTribe.Model.Admission;
import com.SETTribe.Service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admission")
public class AdmissionController {
    @Autowired
    private AdmissionService admissionService;

    @PostMapping("/submit")
    public String submitAdmission(@RequestBody Admission admission) {
        admissionService.submitAdmission(admission);
        return "Admission submitted successfully!";
    }

    @GetMapping("/all")
    public List<Admission> getAllAdmissions() {
        return admissionService.getAllAdmissions();
    }

    @GetMapping("/{id}")
    public Admission getAdmissionById(@PathVariable Long id) {
        return admissionService.getAdmissionById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAdmission(@PathVariable Long id) {
        admissionService.deleteAdmission(id);
        return "Admission record deleted!";
    }
}
