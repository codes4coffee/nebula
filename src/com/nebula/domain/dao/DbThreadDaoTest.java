package com.nebula.domain.dao;

import com.nebula.domain.Location;
import com.nebula.domain.Message;
import com.nebula.domain.RootMessage;
import com.nebula.domain.Thread;

import java.util.Date;

public class DbThreadDaoTest {
    public static void main(String[] args) throws Exception {
        ThreadDao threadDao = new DbThreadDao();

        Thread thread1 = threadDao.postThread(
                new Location(),
                new RootMessage(
                        "thenewboston",
                        "apples noobs pwnage bacon goATS sausage bacon goats harrypotter",
                        "Bacon",
                        "food",
                        "https://avatars0.githubusercontent.com/u/8547538"));
        Thread thread2 = threadDao.postThread(
                new Location(),
                new RootMessage(
                        "thenewboston",
                        "What's up guys",
                        "Java EE Tutorial",
                        "education",
                        "https://avatars0.githubusercontent.com/u/8547538"));

        threadDao.postComment(new Message("Jon Skeet", "you realize you use apples alot?"), thread1);
        threadDao.postComment(new Message("goATS", "after watching his videos, he definitely loves bacon."), thread1);
        threadDao.postComment(new Message("SudoDubs", "i will try my best to make. impossible thing"), thread1);

        threadDao.postComment(new Message("AppleMan", "Anyone watching this on 2019"), thread2);
        threadDao.postComment(new Message("Lorizzle", "I HAVE LEARNED MORE IN THIS TUTORIAL  THAN MY PROF. IN SCHOOL IN COLLEGE"), thread2);
        threadDao.postComment(new Message("Rebecca", "Amazing, this is a million times better than my professors at a big university"), thread2);
        threadDao.postComment(new Message("AndyD", "Thanks, your are awesome very clear and concise."), thread2);

        threadDao.close();
    }

    private static void assertTrue(boolean condition) {
        if (!condition)
            throw new RuntimeException("Failed assert.");
    }
}
