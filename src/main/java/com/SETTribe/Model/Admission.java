package com.SETTribe.Model;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "admissions")
public class Admission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admissionId;

    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    private String fullName;
    private String motherName;
    private String gender;
    private String address;
    private String taluka;
    private String district;
    private String pinCode;
    private String state;
    private String mobileNumber;
    private String email;
    private String aadhaarNumber;
    private LocalDate dateOfBirth;
    private int age;
    private String religion;
    private String casteCategory;
    private String caste;
    private String casteCertificatePath;
    private String marksheetPath;
    private String photoPath;
    private String signaturePath;
    private boolean physicallyHandicapped;

    // Auto-calculate age
    public void setDateOfBirth(LocalDate dob) {
        this.dateOfBirth = dob;
        this.age = Period.between(dob, LocalDate.now()).getYears();
    }

    // Getters and Setters
    public Long getAdmissionId() { return admissionId; }
    public void setAdmissionId(Long admissionId) { this.admissionId = admissionId; }

    public String getFullName() { return fullName; }
    public void setFullName() {
        this.fullName = firstName + " " + middleName + " " + lastName;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; setFullName(); }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; setFullName(); }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; setFullName(); }

    public String getMotherName() { return motherName; }
    public void setMotherName(String motherName) { this.motherName = motherName; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getTaluka() { return taluka; }
    public void setTaluka(String taluka) { this.taluka = taluka; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getPinCode() { return pinCode; }
    public void setPinCode(String pinCode) { this.pinCode = pinCode; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAadhaarNumber() { return aadhaarNumber; }
    public void setAadhaarNumber(String aadhaarNumber) { this.aadhaarNumber = aadhaarNumber; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public int getAge() { return age; }

    public String getReligion() { return religion; }
    public void setReligion(String religion) { this.religion = religion; }

    public String getCasteCategory() { return casteCategory; }
    public void setCasteCategory(String casteCategory) { this.casteCategory = casteCategory; }

    public String getCaste() { return caste; }
    public void setCaste(String caste) { this.caste = caste; }

    public String getCasteCertificatePath() { return casteCertificatePath; }
    public void setCasteCertificatePath(String casteCertificatePath) { this.casteCertificatePath = casteCertificatePath; }

    public String getMarksheetPath() { return marksheetPath; }
    public void setMarksheetPath(String marksheetPath) { this.marksheetPath = marksheetPath; }

    public String getPhotoPath() { return photoPath; }
    public void setPhotoPath(String photoPath) { this.photoPath = photoPath; }

    public String getSignaturePath() { return signaturePath; }
    public void setSignaturePath(String signaturePath) { this.signaturePath = signaturePath; }

    public boolean isPhysicallyHandicapped() { return physicallyHandicapped; }
    public void setPhysicallyHandicapped(boolean physicallyHandicapped) { this.physicallyHandicapped = physicallyHandicapped; }
}