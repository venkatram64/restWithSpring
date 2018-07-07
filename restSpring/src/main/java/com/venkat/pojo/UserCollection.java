package com.venkat.pojo;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserCollection {

    private Collection<User> users;
    
    public UserCollection() {
    }

    public UserCollection(Collection<User> users) {
        this.users = users;
    }

    @XmlElement(name="user")
    @XmlElementWrapper(name="users")
    public Collection<User> getUsers() {
        return users;
    }

}
