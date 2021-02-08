package com.serkovn.quotes.service;


import com.serkovn.quotes.entity.Quote;
import com.serkovn.quotes.entity.User;
import com.serkovn.quotes.entity.UserVoiceQuote;

import java.util.List;

public interface EmployeeService {
    public List<Quote> getAllQuotes();
    public List<User> getAllUser();
    public List<UserVoiceQuote> getAllUserVoice();
    public void saveQuote(Quote quote);
    public void saveUser(User user);
    public void saveUserVoice(UserVoiceQuote userVoiceQuote);
    public Quote getQuote(Long id);
    public User getUser(Long id);
    public void deleteQuote(Long id);
}
