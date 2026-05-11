public abstract class Animal {
    private String name;
    private int age;

    public Animal() {
    }

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public abstract String makeSound();

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Animal Info:");
        sb.append(name);
        sb.append(", Age: ").append(age);
        return sb.toString();
    }

}
