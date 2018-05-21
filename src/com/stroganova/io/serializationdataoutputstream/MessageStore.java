package com.stroganova.io.serializationdataoutputstream;

import java.util.Collection;

public interface MessageStore {

    void persist(Message message);

    void persist(Collection<Message> list);

    Message load();

    Collection<Message> loadAll();

}
