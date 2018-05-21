package com.stroganova.io.serializationdataoutputstream;

import java.util.Collection;

public class SerializationMessageStore implements MessageStore{
    @Override
    public void persist(Message message) {

    }

    @Override
    public void persist(Collection<Message> list) {

    }

    @Override
    public Message load() {
        return null;
    }

    @Override
    public Collection<Message> loadAll() {
        return null;
    }
}
