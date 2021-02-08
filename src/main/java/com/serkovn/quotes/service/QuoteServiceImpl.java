package com.serkovn.quotes.service;



import com.serkovn.quotes.dao.QuoteDAOImpl;
import com.serkovn.quotes.entity.Quote;
import com.serkovn.quotes.entity.User;
import com.serkovn.quotes.entity.UserVoiceQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteDAOImpl quoteDAO;


    @Override
    @Transactional
    public List<Quote> getAllQuotes() {
        return quoteDAO.getAllQuotes();
    }

    @Override
    @Transactional
    public List<User> getAllUser() {
        return quoteDAO.getAllUsers();
    }

    @Override
    @Transactional
    public List<UserVoiceQuote> getAllUserVoice() {
        return quoteDAO.getAllUserVoice();
    }

    @Override
    @Transactional
    public void saveQuote(Quote quote) {
        quoteDAO.saveQuote(quote);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        quoteDAO.saveUser(user);
    }

    @Override
    @Transactional
    public void saveUserVoice(UserVoiceQuote userVoiceQuote) {
        quoteDAO.saveUserVoice(userVoiceQuote);
    }

    @Override
    @Transactional
    public Quote getQuote(Long id) {
        return quoteDAO.getQuote(id);
    }

    @Override
    @Transactional
    public User getUser(Long id) {
        return quoteDAO.getUser(id);
    }

    @Override
    @Transactional
    public void deleteQuote(Long id) {
        quoteDAO.deleteQuote(id);
    }


}
