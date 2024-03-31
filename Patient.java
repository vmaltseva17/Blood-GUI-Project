public class Patient {
    private int idNumber;
    private int age;
    private BloodData bloodData;

    public Patient() {
        this.idNumber = 0;
        this.age = 0;
        this.bloodData = new BloodData();
    }

    public Patient(int idNumber, int age, BloodData bloodData) {
        this.idNumber = idNumber;
        this.age = age;
        this.bloodData = bloodData;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getAge() {
        return age;
    }
    
    public int setAge() {
        return this.age;
    }

    public void setBloodData(BloodData userBloodData) {
    }
}