package HospitalManagementSystem;

/**
 * A medical record links a staff member to a patient with a treatment
 * description and a mutable status ("Active" / "Scheduled" / "Completed").
 */
public class MedicalRecord {

    private MedicalStaff staff;
    private Patient      patient;
    private String       treatment;
    private String       status;

    public MedicalRecord(MedicalStaff staff, Patient patient,
                         String treatment, String status) {
        this.staff     = staff;
        this.patient   = patient;
        this.treatment = treatment;
        this.status    = status;
    }

    public MedicalStaff getStaff() {
        return staff;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getTreatment() {
        return treatment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
