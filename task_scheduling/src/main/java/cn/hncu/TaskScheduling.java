package cn.hncu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * Created by Enzo Cotter on 2019/5/11.
 */
@Component
public class TaskScheduling {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Scheduled(cron = "1 0 * * * ?")
    public void jmsForCrawl(){
        jmsMessagingTemplate.convertAndSend("crawl","aaa");
    }
}
