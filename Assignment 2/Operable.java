package HospitalManagementSystem;

/**
 * Capability for staff members who are allowed to perform surgical operations.
 * Implemented only by Surgeon.
 */
public interface Operable {

    void scheduleOperation(Patient patient, String date);

    void completeOperation(Patient patient);
}
