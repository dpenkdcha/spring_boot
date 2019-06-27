package com.example.sb.basicspringboot.Course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.sb.basicspringboot.Topic.Topic;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Course {

    @Id
    private String id;
    private String name;    
    private String desc;

    @ManyToOne
    private Topic topic;

    public Course() {
    }

    public Course(String id, String name, String desc, String topicId) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.topic = new Topic(topicId, "", "");
    }

    /**
     * @return String return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Topic getTopic() {
        return this.topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

}