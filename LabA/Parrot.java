public class Parrot extends Animal {
    private boolean canTalk;

    public Parrot(boolean canTalk) {
        this.canTalk = canTalk;
    }

    public Parrot(boolean canTalk, int age, String name) {
        super(age, name);
        this.canTalk = canTalk;
    }

    public boolean isCanTalk() {
        return canTalk;
    }

    @Override
    public String makeSound() {
        return "Meow! I'm a talking parrot!";
    };

    @Override
    public String getInfo() {

        StringBuilder sb = new StringBuilder(super.getInfo());

        sb.append(", Can Talk: ").append(isCanTalk() + "\n");
        sb.append("Sound: ").append(makeSound());

        return sb.toString();
    }    


}
