package HospitalManagementSystem;

/**
 * Abstract base class for every hospital staff member.
 * Holds the attributes shared by all staff and declares the
 * abstract getDuties() contract that each subclass must fulfil.
 */
public abstract class MedicalStaff {

    private String staffId;
    private String name;
    private double salary;

    public MedicalStaff(String staffId, String name, double salary) {
        this.staffId = staffId;
        this.name    = name;
        this.salary  = salary;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public abstract String getDuties();
}
