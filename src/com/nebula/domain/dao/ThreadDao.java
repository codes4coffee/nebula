package com.nebula.domain.dao;

import com.nebula.domain.Location;
import com.nebula.domain.Message;
import com.nebula.domain.RootMessage;
import com.nebula.domain.Thread;

public interface ThreadDao extends AutoCloseable {
    Thread[] getFeed(int maxThreads);

    Thread postThread(Location location, RootMessage openingPost);

    void postComment(Message comment, Thread thread);
}
