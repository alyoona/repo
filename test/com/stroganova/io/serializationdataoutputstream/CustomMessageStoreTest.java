package com.stroganova.io.serializationdataoutputstream;

import com.stroganova.reflection.methods.D;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class CustomMessageStoreTest {

    private Message message;
    private CustomMessageStore customMessageStore;

    @Before
    public void before() {
        message = new Message();
        message.setId(1);
        Date date = new Date();
        date.getTime();
        message.setDate(date);
        message.setContent("новое сообщ");
        customMessageStore = new CustomMessageStore();
    }

    @Test
    public void test() {

        customMessageStore.persist(message);

    }

}
