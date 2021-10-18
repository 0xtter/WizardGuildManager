/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager;

/**
 *
 * @author ybert
 */
public class Employee extends Member{
    private Job job;

    public Employee(Job job, String name, Boolean gender, Integer age, Personality personality, Integer memberTag) {
        super(name, gender, age, personality, memberTag);
        this.job = job;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
    
}