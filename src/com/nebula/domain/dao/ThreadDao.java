package com.nebula.domain.dao;

import com.nebula.domain.*;
import com.nebula.domain.Thread;

public interface ThreadDao extends AutoCloseable {
    Thread[] getFeed(int maxThreads);

    Thread postThread(Customer customer, Location location, RootMessage openingPost);

    void postComment(Message comment, Thread thread);
}
