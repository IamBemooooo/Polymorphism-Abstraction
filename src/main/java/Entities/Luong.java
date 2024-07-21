package Entities;

public class Luong {
    private int idGV;
    private String Name;
    private Double Salary;

    public Luong(String name, Double salary, int idGV) {
        Name = name;
        Salary = salary;
        this.idGV = idGV;
    }

    public Luong() {
    }

    public int getIdGV() {
        return idGV;
    }

    public void setIdGV(int idGV) {
        this.idGV = idGV;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    @Override
    public String toString() {
        return "idGV=" + idGV + ", Name='" + Name + ", Salary=" + Salary;
    }
}
