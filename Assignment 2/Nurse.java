package HospitalManagementSystem;

/**
 * A nurse: assists medical staff and cares for patients.
 * Nurses do NOT implement Prescribable or Operable, reflecting the
 * real-world rule that they cannot prescribe medication or perform surgery.
 */
public class Nurse extends MedicalStaff {

    private String shift;
    private String department;

    public Nurse(String staffId, String name, double salary,
                 String shift, String department) {
        super(staffId, name, salary);
        this.shift      = shift;
        this.department = department;
    }

    public String getShift() {
        return shift;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String getDuties() {
        return "Provide patient care, assist medical staff, and monitor patient conditions.";
    }
}
