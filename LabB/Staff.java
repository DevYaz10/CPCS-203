public abstract class Staff {
    private String name;
    private String id;

    public Staff(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract String work();

    protected String roleInfo() {
        return "Role: " + this.getClass().getSimpleName();
    }

    public String getDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name);
        sb.append(", ID: ").append(id).append("\n");
        sb.append(roleInfo()).append("\n");
        sb.append("Work: ").append(work());

        return sb.toString();
    }
}
