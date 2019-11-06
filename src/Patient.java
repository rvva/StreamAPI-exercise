public class Patient {

    private int number;
    private int group;
    private char gender;
    private int age;
    private int cholesterol;
    private int LDL;
    private int HDL;
    private int lipids;

    public Patient(String data) {
        // ^ sekwancja w jednej lini
        // (\\d+\\t){2} liczba a następnie tabulacja <2razy>
        // [mwMW] znak m,w,M lub W
        // (\\d+\\t){2} liczba a następnie tabulacja <5razy>

        if (!data.matches("^(\\d+\\t){2}[mwMW](\\t\\d+){5}$"))
            throw new IllegalArgumentException("Wrong data!!");

        String[] dataArray = data.split("\\t");
        setNumber(Integer.parseInt(dataArray[0]));
        setGroup(Integer.parseInt(dataArray[1]));
        setGender(dataArray[2].charAt(0));
        setAge(Integer.parseInt(dataArray[3]));
        setCholesterol(Integer.parseInt(dataArray[4]));
        setLDL(Integer.parseInt(dataArray[5]));
        setHDL(Integer.parseInt(dataArray[6]));
        setLipids(Integer.parseInt(dataArray[7]));
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(int cholesterol) {
        this.cholesterol = cholesterol;
    }

    public int getLDL() {
        return LDL;
    }

    public void setLDL(int LDL) {
        this.LDL = LDL;
    }

    public int getHDL() {
        return HDL;
    }

    public void setHDL(int HDL) {
        this.HDL = HDL;
    }

    public int getLipids() {
        return lipids;
    }

    public void setLipids(int lipids) {
        this.lipids = lipids;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "number=" + number +
                ", group=" + group +
                ", gender=" + gender +
                ", age=" + age +
                ", cholesterol=" + cholesterol +
                ", LDL=" + LDL +
                ", HDL=" + HDL +
                ", lipids=" + lipids +
                '}';
    }
}
