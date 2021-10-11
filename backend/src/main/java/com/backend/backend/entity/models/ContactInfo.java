package com.backend.backend.entity.models;

public class ContactInfo {
    String name;
    String mail;
    String content;

    public ContactInfo() {
    }

    public ContactInfo(String name, String mail, String content) {
        this.name = name;
        this.mail = mail;
        this.content = content;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ContactInfo name(String name) {
        setName(name);
        return this;
    }

    public ContactInfo mail(String mail) {
        setMail(mail);
        return this;
    }

    public ContactInfo content(String content) {
        setContent(content);
        return this;
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", mail='" + getMail() + "'" + ", content='" + getContent() + "'"
                + "}";
    }

}
