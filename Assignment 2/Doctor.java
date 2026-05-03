package HospitalManagementSystem;

import java.util.ArrayList;

/**
 * A doctor: has a specialty and years of experience, and is allowed
 * to prescribe medication (implements Prescribable).
 */
public class Doctor extends MedicalStaff implements Prescribable {

    private String specialty;
    private int    yearsOfExperience;
    private ArrayList<String> prescriptions;

    public Doctor(String staffId, String name, double salary,
                  String specialty, int yearsOfExperience) {
        super(staffId, name, salary);
        this.specialty         = specialty;
        this.yearsOfExperience = yearsOfExperience;
        this.prescriptions     = new ArrayList<>();
    }

    public String getSpecialty() {
        return specialty;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    @Override
    public String getDuties() {
        return "Diagnose patients, prescribe medication, and provide specialist care.";
    }

    @Override
    public void prescribeMedication(Patient patient, String medication) {
        prescriptions.add(medication + " for " + patient.getName()
                + " (ID: " + patient.getPatientId() + ")");
    }

    @Override
    public String getPrescriptions() {
        StringBuilder sb = new StringBuilder();
        sb.append("Prescriptions by Dr. ").append(getName()).append(":\n");
        if (prescriptions.isEmpty()) {
            sb.append("   (none)");
        } else {
            for (int i = 0; i < prescriptions.size(); i++) {
                sb.append("   ").append(i + 1).append(". ").append(prescriptions.get(i));
                if (i < prescriptions.size() - 1) {
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }
}
