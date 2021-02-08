package com.serkovn.quotes.dao;


import com.serkovn.quotes.entity.Quote;
import com.serkovn.quotes.entity.User;
import com.serkovn.quotes.entity.UserVoiceQuote;

import java.util.List;

public interface QuoteDAO {
    public List<Quote> getAllQuotes();

    public void saveQuote(Quote quote);

    public Quote getQuote(Long id);

    public void deleteQuote(Long id);

    public List<User> getAllUsers();

    public void saveUser(User user);

    public List<UserVoiceQuote> getAllUserVoice();

    public void saveUserVoice(UserVoiceQuote userVoiceQuote);

    public User getUser(Long id);
}
