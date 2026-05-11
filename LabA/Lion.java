
public class Lion extends Animal {
    private String maneSize;

    public Lion(String maneSize) {
        this.maneSize = maneSize;
    }

    public Lion(String maneSize, int age, String name) {
        super(age, name);
        this.maneSize = maneSize;
    }
    
    
    public String getManeSize() {
        return maneSize;
    }


    @Override
    public String makeSound() {
        return "Roari";
    };

    @Override
    public String getInfo() {

        StringBuilder sb = new StringBuilder(super.getInfo());

        sb.append(", Mane Size: ").append(getManeSize() + "\n");
        sb.append("Sound: ").append(makeSound());

        return sb.toString();
    }    


    
}
