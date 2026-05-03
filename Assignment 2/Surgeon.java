package HospitalManagementSystem;

import java.util.ArrayList;

/**
 * A surgeon: can both prescribe medication AND perform surgical operations.
 * This is the key demonstration that a single class may implement multiple
 * interfaces while still extending a single parent class.
 */
public class Surgeon extends MedicalStaff implements Prescribable, Operable {

    private String surgeryType;
    private int    operatingRoom;
    private ArrayList<String> prescriptions;
    private ArrayList<String> operations;

    public Surgeon(String staffId, String name, double salary,
                   String surgeryType, int operatingRoom) {
        super(staffId, name, salary);
        this.surgeryType   = surgeryType;
        this.operatingRoom = operatingRoom;
        this.prescriptions = new ArrayList<>();
        this.operations    = new ArrayList<>();
    }

    public String getSurgeryType() {
        return surgeryType;
    }

    public int getOperatingRoom() {
        return operatingRoom;
    }

    @Override
    public String getDuties() {
        return "Perform surgical operations, prescribe medication, and manage surgical cases.";
    }

    @Override
    public void prescribeMedication(Patient patient, String medication) {
        prescriptions.add(medication + " for " + patient.getName()
                + " (ID: " + patient.getPatientId() + ")");
    }

    @Override
    public String getPrescriptions() {
        StringBuilder sb = new StringBuilder();
        sb.append("Prescriptions by Surgeon ").append(getName()).append(":\n");
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

    @Override
    public void scheduleOperation(Patient patient, String date) {
        operations.add("Scheduled for " + patient.getName()
                + " (ID: " + patient.getPatientId() + ") on " + date);
    }

    @Override
    public void completeOperation(Patient patient) {
        operations.add("Completed for " + patient.getName()
                + " (ID: " + patient.getPatientId() + ")");
    }
}
