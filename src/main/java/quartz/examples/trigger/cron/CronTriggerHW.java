package quartz.examples.trigger.cron;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import quartz.examples.trigger.HelloWorldJob;

public class CronTriggerHW {

    public static void main(String[] args) throws SchedulerException, ParseException {
        JobDetail jobDetail = new JobDetail();
        jobDetail.setName("jobDetailExample");
        jobDetail.setJobClass(HelloWorldJob.class);

        CronTrigger cronTrigger = new CronTrigger();
        cronTrigger.setName("cronTriggerExample");
        cronTrigger.setCronExpression("0/3 * * * * ?");
        cronTrigger.setStartTime(new Date(Calendar.getInstance().getTimeInMillis() + 5000));
        cronTrigger.setEndTime(new Date(Calendar.getInstance().getTimeInMillis() + 65000));

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }
}
