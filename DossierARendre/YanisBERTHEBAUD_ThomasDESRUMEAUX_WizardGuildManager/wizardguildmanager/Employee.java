/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager;

import java.io.IOException;

/**
 *
 * @author ybert
 */
public class Employee extends Member implements MissionWriter {

    private Job job;

    /**
     * Constructor
     *
     * @param job
     * @param name
     * @param gender
     * @param age
     * @param personality
     * @param memberTag
     */
    public Employee(Job job, String name, Boolean gender, Integer age, Personality personality, Integer memberTag) {
        super(name, gender, age, personality, memberTag);
        this.job = job;
    }

    /**
     *
     * @return the job of the employee
     */
    public Job getJob() {
        return job;
    }

    /**
     * set the job of the employee
     *
     * @param job
     */
    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public void writeMissionManuscript(Mission mission) {
        try {
            MissionWriter.super.writeMissionManuscript(mission);
        } catch (IOException ex) {
            System.out.println("Il n'y a plus d'encre!");
        }
    }

    @Override
    public void talk() {
        System.out.println("Bonjour, je suis " + this.getName() + " je suis un(e) " + this.job.toString() + " de la guilde! ");
    }

}
