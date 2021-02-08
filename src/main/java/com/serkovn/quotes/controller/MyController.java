package com.serkovn.quotes.controller;


import com.serkovn.quotes.entity.Quote;
import com.serkovn.quotes.entity.User;
import com.serkovn.quotes.entity.UserVoiceQuote;
import com.serkovn.quotes.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class MyController {
    @Autowired
    private QuoteService quoteService;

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/flop")
    public String flop() {
        return "flop";
    }

    @GetMapping("/last")
    public String last() {
        return "last";
    }

    @GetMapping("/newQuote")
    public String newQuote(@RequestParam("UserId") Long userId, Model model) {
        User user = quoteService.getUser(userId);
        Quote quote = new Quote();
        model.addAttribute("quote",quote);
        model.addAttribute("user", user);
        return "newQuotes";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("QuoteId") Long quoteId, @RequestParam("UserId") Long userId, Model model) {
        User user = quoteService.getUser(userId);
        quoteService.deleteQuote(quoteId);
        quote(user, model);
        return "all-quotes";
    }

    @GetMapping("/update")
    public String update(@RequestParam("QuoteId") Long quoteId,@RequestParam("UserId") Long userId, Model model) {
        Quote quote = quoteService.getQuote(quoteId);
        User user = quoteService.getUser(userId);
        model.addAttribute("quote",quote);
        model.addAttribute("user", user);
        return "newQuotes";
    }

    @GetMapping("/saveNew")
    public String saveNew(@RequestParam("name") String string,@RequestParam("UserId") Long userId,@RequestParam("QuoteId") Long quoteId, Model model) {
        User user = quoteService.getUser(userId);
        Quote quote = new Quote();
        quote.setId(quoteId);
        quote.setName(string);
        quote.setCount(1);
        quote.setAuthor(user.getName());
        quoteService.saveQuote(quote);
        quote(user, model);
        return "all-quotes";
    }

    @GetMapping("/increment")
    public String increment(@RequestParam("QuoteId") Long quoteId,@RequestParam("UserId") Long userId, Model model) {
        User user = quoteService.getUser(userId);
/*        List<Quote> quotes = employeeService.getAllQuotes();
        Collections.sort(quotes, new Comparator<Quote>() {
            public int compare(Quote o1, Quote o2) {
                return o2.getCount() - o1.getCount();
            }
        });
        quotes = quotes.stream().limit(10).collect(Collectors.toList());
        int random = (int)(Math.random() * quotes.size());
        model.addAttribute("randomQuote", quotes.get(random));
        model.addAttribute("user", user);
        model.addAttribute("quotes", quotes);
        List<UserVoiceQuote> list = employeeService.getAllUserVoice();
        Collections.sort(list, new Comparator<UserVoiceQuote>() {
            public int compare(UserVoiceQuote o1, UserVoiceQuote o2) {
                return o1.getDate_time().compareTo(o2.getDate_time());
            }
        });
        List<Quote> quoteList = new ArrayList<>();
        for (UserVoiceQuote us: list) {
            if (us.getUser_id() == userId) {
                quoteList.add(employeeService.getQuote(us.getQuote_id()));
            }
        }
        quoteList = quoteList.stream().limit(5).collect(Collectors.toList());
        model.addAttribute("quotesLast", quoteList);*/
        List<UserVoiceQuote> list = quoteService.getAllUserVoice();
        Collections.sort(list, new Comparator<UserVoiceQuote>() {
            public int compare(UserVoiceQuote o1, UserVoiceQuote o2) {
                return o1.getDate_time().compareTo(o2.getDate_time());
            }
        });
        for (UserVoiceQuote u : list) {
            if (u.getUser_id() == userId && u.getQuote_id() == quoteId) {
                quote(user,model);
                return "all-quotes";
            }
        }
        Quote quote = quoteService.getQuote(quoteId);
        quote.setCount(quote.getCount() + 1);
        quoteService.saveQuote(quote);
        UserVoiceQuote userVoiceQuote = new UserVoiceQuote();
        userVoiceQuote.setQuote_id(quoteId);
        userVoiceQuote.setUser_id(userId);
        userVoiceQuote.setDate_time(new Date());
        quoteService.saveUserVoice(userVoiceQuote);
        quote(user, model);
        return "all-quotes";
    }

    @GetMapping("/decrement")
    public String decrement(@RequestParam("QuoteId") Long quoteId,@RequestParam("UserId") Long userId, Model model) {
        User user = quoteService.getUser(userId);
        List<UserVoiceQuote> list = quoteService.getAllUserVoice();
        Collections.sort(list, new Comparator<UserVoiceQuote>() {
            public int compare(UserVoiceQuote o1, UserVoiceQuote o2) {
                return o1.getDate_time().compareTo(o2.getDate_time());
            }
        });
        for (UserVoiceQuote u : list) {
            if (u.getUser_id() == userId && u.getQuote_id() == quoteId) {
                quote(user, model);
                return "all-quotes";
            }
        }
        Quote quote = quoteService.getQuote(quoteId);
        if (quote.getCount()>0) {
            quote.setCount(quote.getCount() - 1);
        }else {
            quote.setCount(0);
        }
        quoteService.saveQuote(quote);
        UserVoiceQuote userVoiceQuote = new UserVoiceQuote();
        userVoiceQuote.setQuote_id(quoteId);
        userVoiceQuote.setUser_id(userId);
        userVoiceQuote.setDate_time(new Date());
        quoteService.saveUserVoice(userVoiceQuote);
        quote(user, model);
        return "all-quotes";
    }

    @GetMapping("/")
    public String showAllEmployees(Model model) {
        List<Quote> quotes = quoteService.getAllQuotes();
        Collections.sort(quotes, new Comparator<Quote>() {
            public int compare(Quote o1, Quote o2) {
                return o2.getCount() - o1.getCount();
            }
        });
        quotes = quotes.stream().limit(10).collect(Collectors.toList());
        model.addAttribute("quotes", quotes);
        User user = new User();
        int random = (int)(Math.random() * quotes.size());
        model.addAttribute("randomQuote", quotes.get(random));
        model.addAttribute("user", user);
        return "hello";
    }

    @PostMapping("/userOpen")
    public String userOpen(@ModelAttribute("user") User user, Model model ) {
        List<User> users = quoteService.getAllUser();
        for (User u : users) {
            if (u.getName().equals(user.getName())) {
                if (!u.getPassword().equals(user.getPassword()))
                return "redirect:/";
                user = u;

            }
        }
        if (user.getId() == null) {
            quoteService.saveUser(user);
        }

        // Сортировка топ 10 и отбор 10 штук
        List<Quote> quotes = quoteService.getAllQuotes();
        Collections.sort(quotes, new Comparator<Quote>() {
            public int compare(Quote o1, Quote o2) {
                return o2.getCount() - o1.getCount();
            }
        });
        quotes = quotes.stream().limit(10).collect(Collectors.toList());


        //Сортировка и отбор 5 последних голосов
        List<UserVoiceQuote> list = quoteService.getAllUserVoice();
        Collections.sort(list, new Comparator<UserVoiceQuote>() {
            public int compare(UserVoiceQuote o1, UserVoiceQuote o2) {
                return o1.getDate_time().compareTo(o2.getDate_time());
            }
        });
               List<Quote> quoteList = new ArrayList<>();
        for (UserVoiceQuote us: list) {
            if (us.getUser_id() == user.getId()) {
                quoteList.add(quoteService.getQuote(us.getQuote_id()));
            }
        }
        quoteList = quoteList.stream().limit(5).collect(Collectors.toList());
        //рандомная цитата
        int random = (int)(Math.random() * quotes.size());
        // Добавление в модель
        model.addAttribute("randomQuote", quotes.get(random));
        model.addAttribute("user", user);
        model.addAttribute("quotes", quotes);
        model.addAttribute("quotesLast", quoteList);

        return "all-quotes";
    }

    public void quote(User user, Model model ) {
        // Сортировка топ 10 и отбор 10 штук
        List<Quote> quotes = quoteService.getAllQuotes();
        Collections.sort(quotes, new Comparator<Quote>() {
            public int compare(Quote o1, Quote o2) {
                return o2.getCount() - o1.getCount();
            }
        });
        quotes = quotes.stream().limit(10).collect(Collectors.toList());


        //Сортировка и отбор 5 последних голосов
        List<UserVoiceQuote> list = quoteService.getAllUserVoice();
        Collections.sort(list, new Comparator<UserVoiceQuote>() {
            public int compare(UserVoiceQuote o1, UserVoiceQuote o2) {
                return o2.getDate_time().compareTo(o1.getDate_time());
            }
        });
        List<Quote> quoteList = new ArrayList<>();
        for (UserVoiceQuote us: list) {
            if (us.getUser_id() == user.getId()) {
                quoteList.add(quoteService.getQuote(us.getQuote_id()));
            }
        }
        quoteList = quoteList.stream().limit(5).collect(Collectors.toList());
        //рандомная цитата
        int random = (int)(Math.random() * quotes.size());
        // Добавление в модель
        model.addAttribute("randomQuote", quotes.get(random));
        model.addAttribute("user", user);
        model.addAttribute("quotes", quotes);
        model.addAttribute("quotesLast", quoteList);
    }
}
