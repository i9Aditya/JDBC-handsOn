package org.example;

public class Employee {
    private int id;
    private String name;
    private double salary;

    Employee(int id,String n, double salary){
        this.id = id;
        this.name = n;
        this.salary = salary;
    }

    void printEmp(){
        System.out.print(this.getId() + " ");
        System.out.print(this.getName() + " ");
        System.out.println(this.getSalary());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
