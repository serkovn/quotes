package com.serkovn.quotes.service;



import com.serkovn.quotes.dao.EmployeeDAOImpl;
import com.serkovn.quotes.entity.Quote;
import com.serkovn.quotes.entity.User;
import com.serkovn.quotes.entity.UserVoiceQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAOImpl employeeDAO;


    @Override
    @Transactional
    public List<Quote> getAllQuotes() {
        return employeeDAO.getAllQuotes();
    }

    @Override
    @Transactional
    public List<User> getAllUser() {
        return employeeDAO.getAllUsers();
    }

    @Override
    @Transactional
    public List<UserVoiceQuote> getAllUserVoice() {
        return employeeDAO.getAllUserVoice();
    }

    @Override
    @Transactional
    public void saveQuote(Quote quote) {
        employeeDAO.saveQuote(quote);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        employeeDAO.saveUser(user);
    }

    @Override
    @Transactional
    public void saveUserVoice(UserVoiceQuote userVoiceQuote) {
        employeeDAO.saveUserVoice(userVoiceQuote);
    }

    @Override
    @Transactional
    public Quote getQuote(Long id) {
        return employeeDAO.getQuote(id);
    }

    @Override
    @Transactional
    public User getUser(Long id) {
        return employeeDAO.getUser(id);
    }

    @Override
    @Transactional
    public void deleteQuote(Long id) {
        employeeDAO.deleteQuote(id);
    }


}
