package com.stroganova.io.serializationdataoutputstream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;

public class CustomMessageStore implements MessageStore{
    @Override
    public void persist(Message message) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("Message.txt"))) {
            out.writeInt(message.getId());
            out.writeLong(message.getDate());
            out.writeChars(message.getContent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
