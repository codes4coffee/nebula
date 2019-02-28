package com.nebula.domain.dao;

import com.nebula.domain.Message;
import com.nebula.domain.Thread;

public interface ThreadDao extends AutoCloseable {
    Thread[] getFeed(int maxThreads);

    void postThread(Thread thread);

    void postComment(Thread thread, Message comment);
}
