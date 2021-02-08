package com.serkovn.quotes.dao;

import com.serkovn.quotes.entity.Quote;
import com.serkovn.quotes.entity.User;
import com.serkovn.quotes.entity.UserVoiceQuote;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuoteDAOImpl implements QuoteDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Quote> getAllQuotes() {
        Session session = sessionFactory.getCurrentSession();
        List<Quote> allQuotes = session.createQuery("from Quote", Quote.class).getResultList();
        return allQuotes;
    }


    @Override
    public void saveQuote(Quote quote) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(quote);
    }

    @Override
    public Quote getQuote(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Quote quote = session.get(Quote.class, id);
        return quote;
    }

    @Override
    public void deleteQuote(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Quote quote = session.get(Quote.class, id);
        session.delete(quote);
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("from User", User.class).getResultList();
        return users;
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public List<UserVoiceQuote> getAllUserVoice() {
        Session session = sessionFactory.getCurrentSession();
        List<UserVoiceQuote> users = session.createQuery("from UserVoiceQuote", UserVoiceQuote.class).getResultList();
        return users;
    }

    @Override
    public void saveUserVoice(UserVoiceQuote userVoiceQuote) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(userVoiceQuote);
    }

    @Override
    public User getUser(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        return user;
    }
}
