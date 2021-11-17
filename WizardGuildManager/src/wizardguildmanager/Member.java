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
public class Member {
    private String name;
    private Boolean gender;
    private Integer age;
    private Personality personality;
    private Integer memberTag;

    /**
     * constructor
     * @param name
     * @param gender
     * @param age
     * @param personality
     * @param memberTag
     */
    public Member(String name, Boolean gender, Integer age, Personality personality, Integer memberTag) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.personality = personality;
        this.memberTag = memberTag;
    }

    /**
     * set the name of the member
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set the gender of the member
     * @param gender
     */
    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    /**
     * set the age of the member
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * set the personality of the member
     * @param personality
     */
    public void setPersonality(Personality personality) {
        this.personality = personality;
    }

    /**
     * set the member tag of the member
     * @param memberTag
     */
    public void setMemberTag(Integer memberTag) {
        this.memberTag = memberTag;
    }

    /**
     *
     * @return the name of the member
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return the gender of the member
     */
    public Boolean getGender() {
        return gender;
    }

    /**
     *
     * @return the age of the member
     */
    public Integer getAge() {
        return age;
    }

    /**
     *
     * @return the personality of the member
     */
    public Personality getPersonality() {
        return personality;
    }

    /**
     *
     * @return the tag of the member
     */
    public Integer getMemberTag() {
        return memberTag;
    }
    
    /**
     * the member present himself
     */
    public void talk() {
        System.out.println("Salut je suis " + this.name + " et j'ai "+ this.age + " ans !");
    }
}
