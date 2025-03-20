package com.SETTribe.Service;

import com.SETTribe.Model.Admission;
import com.SETTribe.Repository.AdmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissionService {
    @Autowired
    private AdmissionRepository admissionRepository;

    public Admission submitAdmission(Admission admission) {
        admission.setFullName();  // Auto-generate Full Name
        return admissionRepository.save(admission);
    }

    public List<Admission> getAllAdmissions() {
        return admissionRepository.findAll();
    }

    public Admission getAdmissionById(Long id) {
        return admissionRepository.findById(id).orElse(null);
    }

    public void deleteAdmission(Long id) {
        admissionRepository.deleteById(id);
    }
}

