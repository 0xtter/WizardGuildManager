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

    public Member(String name, Boolean gender, Integer age, Personality personality, Integer memberTag) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.personality = personality;
        this.memberTag = memberTag;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPersonality(Personality personality) {
        this.personality = personality;
    }

    public void setMemberTag(Integer memberTag) {
        this.memberTag = memberTag;
    }

    public String getName() {
        return name;
    }

    public Boolean getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public Personality getPersonality() {
        return personality;
    }

    public Integer getMemberTag() {
        return memberTag;
    }
    
    
    public void talk(String talking) {
        System.out.println(talking);
    }
    
    public void present(String present) {
        System.out.println(present);
    }
}
