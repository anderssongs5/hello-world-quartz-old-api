package quartz.examples.trigger.simple;

import java.util.Calendar;
import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import quartz.examples.trigger.HelloWorldJob;

public class SimpleTriggerHW {

    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = new JobDetail();
        jobDetail.setName("jobDetailExample");
        jobDetail.setJobClass(HelloWorldJob.class);

        SimpleTrigger simpleTrigger = new SimpleTrigger();
        simpleTrigger.setStartTime(new Date(Calendar.getInstance().getTimeInMillis() + 1000));
        // simpleTrigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        simpleTrigger.setRepeatCount(20);
        // simpleTrigger.setRepeatInterval(3000);
        simpleTrigger.setRepeatInterval(1000);
        simpleTrigger.setName("simpleTriggerExample");

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, simpleTrigger);
    }
}
