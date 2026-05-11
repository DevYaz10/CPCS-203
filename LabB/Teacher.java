public class Teacher extends Staff{
    private String subject;

    public Teacher(String subject, String id, String name) {
        super(id, name);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String work() {
        return "Teaching students in class";
    }    

    @Override
    protected String roleInfo() {
        return super.roleInfo() + ", Subject: " + getSubject();
    }
    
    
}
