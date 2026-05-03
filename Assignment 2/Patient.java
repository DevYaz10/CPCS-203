package HospitalManagementSystem;

/**
 * A patient registered in the hospital.
 */
public class Patient {

    private String patientId;
    private String name;
    private int    age;
    private String diagnosis;

    public Patient(String patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name      = name;
        this.age       = age;
        this.diagnosis = diagnosis;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }
}
