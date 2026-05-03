package HospitalManagementSystem;

/**
 * Capability for staff members who are allowed to prescribe medication.
 * Implemented by Doctor and Surgeon (but NOT by Nurse).
 */
public interface Prescribable {

    void prescribeMedication(Patient patient, String medication);

    String getPrescriptions();
}
