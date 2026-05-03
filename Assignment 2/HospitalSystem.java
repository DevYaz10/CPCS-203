package HospitalManagementSystem;

import java.util.ArrayList;

/**
 * Controller class for the Hospital Management System.
 * Holds the three master lists (staff, patients, records) and exposes
 * all operations invoked by Main.java. Every public method returns a
 * String which Main.java writes directly to output.txt.
 */
public class HospitalSystem {

    private static final String EQUALS_LINE =
            "===============================================================";
    private static final String DASH_LINE =
            "-------------------------------------------------------------";

    private ArrayList<MedicalStaff>   staff;
    private ArrayList<Patient>        patients;
    private ArrayList<MedicalRecord>  records;

    public HospitalSystem() {
        this.staff    = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.records  = new ArrayList<>();
    }

    // ---------------------------------------------------------------
    //  Helpers
    // ---------------------------------------------------------------

    private MedicalStaff findStaffById(String staffId) {
        for (MedicalStaff s : staff) {
            if (s.getStaffId().equals(staffId)) {
                return s;
            }
        }
        return null;
    }

    private Patient findPatientById(String patientId) {
        for (Patient p : patients) {
            if (p.getPatientId().equals(patientId)) {
                return p;
            }
        }
        return null;
    }

    private MedicalRecord findRecord(String staffId, String patientId) {
        for (MedicalRecord r : records) {
            if (r.getStaff().getStaffId().equals(staffId)
                    && r.getPatient().getPatientId().equals(patientId)) {
                return r;
            }
        }
        return null;
    }

    // ---------------------------------------------------------------
    //  Registration
    // ---------------------------------------------------------------

    public String addDoctor(String staffId, String name, double salary,
                            String specialty, int yearsOfExperience) {
        Doctor d = new Doctor(staffId, name, salary, specialty, yearsOfExperience);
        staff.add(d);
        return "Doctor " + name + " added successfully.";
    }

    public String addNurse(String staffId, String name, double salary,
                           String shift, String department) {
        Nurse n = new Nurse(staffId, name, salary, shift, department);
        staff.add(n);
        return "Nurse " + name + " added successfully.";
    }

    public String addSurgeon(String staffId, String name, double salary,
                             String surgeryType, int operatingRoom) {
        Surgeon s = new Surgeon(staffId, name, salary, surgeryType, operatingRoom);
        staff.add(s);
        return "Surgeon " + name + " added successfully.";
    }

    public String addPatient(String patientId, String name, int age, String diagnosis) {
        Patient p = new Patient(patientId, name, age, diagnosis);
        patients.add(p);
        return "Patient " + name + " added successfully.";
    }

    // ---------------------------------------------------------------
    //  Operational commands
    // ---------------------------------------------------------------

    public String assignStaff(String staffId, String patientId, String treatment) {
        MedicalStaff s = findStaffById(staffId);
        if (s == null) {
            return "Error: Staff with ID " + staffId + " not found.";
        }
        Patient p = findPatientById(patientId);
        if (p == null) {
            return "Error: Patient with ID " + patientId + " not found.";
        }
        MedicalRecord record = new MedicalRecord(s, p, treatment, "Active");
        records.add(record);
        return "Staff " + staffId + " assigned to patient " + p.getName() + " successfully.";
    }

    public String prescribe(String staffId, String patientId, String medication) {
        MedicalStaff s = findStaffById(staffId);
        if (s == null) {
            return "Error: Staff with ID " + staffId + " not found.";
        }
        Patient p = findPatientById(patientId);
        if (p == null) {
            return "Error: Patient with ID " + patientId + " not found.";
        }
        if (!(s instanceof Prescribable)) {
            return "Error: Staff member " + s.getName()
                    + " is not authorized to prescribe medication.";
        }
        ((Prescribable) s).prescribeMedication(p, medication);
        return s.getClass().getSimpleName() + " " + s.getName()
                + " prescribed " + medication + " to " + p.getName() + " successfully.";
    }

    public String scheduleOperation(String staffId, String patientId, String date) {
        MedicalStaff s = findStaffById(staffId);
        if (s == null) {
            return "Error: Staff with ID " + staffId + " not found.";
        }
        Patient p = findPatientById(patientId);
        if (p == null) {
            return "Error: Patient with ID " + patientId + " not found.";
        }
        if (!(s instanceof Operable)) {
            return "Error: Staff member " + s.getName()
                    + " is not authorized to schedule operations.";
        }
        MedicalRecord record = findRecord(staffId, patientId);
        if (record == null) {
            return "Error: No medical record found for staff " + staffId
                    + " and patient " + patientId + ".";
        }
        ((Operable) s).scheduleOperation(p, date);
        record.setStatus("Scheduled");
        return "Operation scheduled for " + p.getName()
                + " by Surgeon " + s.getName() + " on " + date + ".";
    }

    public String completeOperation(String staffId, String patientId) {
        MedicalStaff s = findStaffById(staffId);
        if (s == null) {
            return "Error: Staff with ID " + staffId + " not found.";
        }
        Patient p = findPatientById(patientId);
        if (p == null) {
            return "Error: Patient with ID " + patientId + " not found.";
        }
        if (!(s instanceof Operable)) {
            return "Error: Staff member " + s.getName()
                    + " is not authorized to complete operations.";
        }
        MedicalRecord record = findRecord(staffId, patientId);
        if (record == null) {
            return "Error: No medical record found for staff " + staffId
                    + " and patient " + patientId + ".";
        }
        ((Operable) s).completeOperation(p);
        record.setStatus("Completed");
        return "Operation for " + p.getName()
                + " by Surgeon " + s.getName() + " completed successfully.";
    }

    // ---------------------------------------------------------------
    //  Display commands
    // ---------------------------------------------------------------

    public String printAllStaff() {
        StringBuilder sb = new StringBuilder();
        sb.append(EQUALS_LINE).append("\n");
        sb.append(String.format("%-10s %-20s %-10s %-14s ", "ID", "Name", "Type", "Salary")).append("\n");
        sb.append(EQUALS_LINE).append("\n");
        for (MedicalStaff s : staff) {
            String type     = s.getClass().getSimpleName();
            String salaryFm = String.format("$%-13.2f", s.getSalary());
            sb.append(String.format("%-10s %-20s %-10s %-14s ",
                    s.getStaffId(), s.getName(), type, salaryFm)).append("\n");
            if (s instanceof Doctor) {
                Doctor d = (Doctor) s;
                sb.append("   Specialty: ").append(d.getSpecialty())
                        .append(" | Experience: ").append(d.getYearsOfExperience())
                        .append(" years").append("\n");
            } else if (s instanceof Nurse) {
                Nurse n = (Nurse) s;
                sb.append("   Shift: ").append(n.getShift())
                        .append(" | Department: ").append(n.getDepartment()).append("\n");
            } else if (s instanceof Surgeon) {
                Surgeon sg = (Surgeon) s;
                sb.append("   Surgery Type: ").append(sg.getSurgeryType())
                        .append(" | Operating Room: ").append(sg.getOperatingRoom()).append("\n");
            }
        }
        sb.append(EQUALS_LINE).append("\n");
        return sb.toString();
    }

    public String printAllPatients() {
        StringBuilder sb = new StringBuilder();
        sb.append(EQUALS_LINE).append("\n");
        sb.append(String.format("%-10s %-20s %-10s %-14s ", "ID", "Name", "Age", "Diagnosis")).append("\n");
        sb.append(EQUALS_LINE).append("\n");
        for (Patient p : patients) {
            sb.append(String.format("%-10s %-20s %-10s %-14s ",
                    p.getPatientId(), p.getName(),
                    String.valueOf(p.getAge()), p.getDiagnosis())).append("\n");
        }
        sb.append(EQUALS_LINE).append("\n");
        return sb.toString();
    }

    public String printPatientRecords(String patientId) {
        Patient p = findPatientById(patientId);
        if (p == null) {
            return "Error: Patient with ID " + patientId + " not found.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("--------- Medical Records for Patient: ").append(p.getName())
                .append(" (ID: ").append(p.getPatientId()).append(") ---------").append("\n");
        for (MedicalRecord r : records) {
            if (!r.getPatient().getPatientId().equals(patientId)) {
                continue;
            }
            MedicalStaff s = r.getStaff();
            sb.append(DASH_LINE).append("\n");
            sb.append(String.format("%-14s: %s", "Staff",
                    s.getName() + " (ID: " + s.getStaffId() + ")")).append("\n");
            sb.append(String.format("%-14s: %s", "Staff Type",
                    s.getClass().getSimpleName())).append("\n");
            sb.append(String.format("%-14s: %s", "Treatment", r.getTreatment())).append("\n");
            sb.append(String.format("%-14s: %s", "Status", r.getStatus())).append("\n");
            if (s instanceof Doctor) {
                Doctor d = (Doctor) s;
                sb.append(String.format("%-14s: %s", "Specialty", d.getSpecialty())).append("\n");
                sb.append(String.format("%-14s: %d years", "Experience", d.getYearsOfExperience())).append("\n");
            } else if (s instanceof Nurse) {
                Nurse n = (Nurse) s;
                sb.append(String.format("%-14s: %s", "Shift", n.getShift())).append("\n");
                sb.append(String.format("%-14s: %s", "Department", n.getDepartment())).append("\n");
            } else if (s instanceof Surgeon) {
                Surgeon sg = (Surgeon) s;
                sb.append(String.format("%-14s: %s", "Surgery Type", sg.getSurgeryType())).append("\n");
                sb.append(String.format("%-14s: %d", "Operating Room", sg.getOperatingRoom())).append("\n");
            }
            sb.append(String.format("%-14s: %s", "Duties", s.getDuties())).append("\n");
            sb.append(DASH_LINE).append("\n");
        }
        return sb.toString();
    }
}
