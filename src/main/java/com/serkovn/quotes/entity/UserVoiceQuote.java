package com.serkovn.quotes.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "users_quotes")
public class UserVoiceQuote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "quote_id")
    private Long quote_id;
    @Column(name = "user_id")
    private Long user_id;
    @Column(name = "date_time")
    private Date date_time;

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public UserVoiceQuote() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuote_id() {
        return quote_id;
    }

    public void setQuote_id(Long quote_id) {
        this.quote_id = quote_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}

