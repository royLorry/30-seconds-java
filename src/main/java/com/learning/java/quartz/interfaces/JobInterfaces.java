package com.learning.java.quartz.interfaces;

import com.learning.java.quartz.domain.entity.TaskDefine;
import com.learning.java.quartz.domain.execute.SayHelloJobLogic;
import com.learning.java.quartz.domain.service.QuartzJobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by EalenXie on 2019/7/10 16:01.
 */
@RestController
@Api(value = "用户模块API")
public class JobInterfaces {


    @Resource
    private QuartzJobService quartzJobService;


    //假如 这个定时任务的 名字叫做HelloWorld, 组名GroupOne
    private final JobKey jobKey = JobKey.jobKey("HelloWorld", "GroupOne");


    /**
     * 启动 hello world
     */
    @GetMapping("/startHelloWorldJob")
    @ApiOperation("Start")
    public String startHelloWorldJob() throws SchedulerException {

        Map<Integer,Integer> jobDataMap = new HashMap<>();
        jobDataMap.put(1, 1);

        //创建一个定时任务
        TaskDefine task = TaskDefine.builder()
                .jobKey(jobKey)
                .cronExpression("0/2 * * * * ? ")   //定时任务 的cron表达式
                .jobClass(SayHelloJobLogic.class)   //定时任务 的具体执行逻辑
                .description("这是一个测试的 任务")    //定时任务 的描述
                .jobDataMap(jobDataMap)
                .build();

        quartzJobService.scheduleJob(task);
        return "startHelloWorldJob success";
    }

    /**
     * 暂停 hello world
     */
    @GetMapping("/pauseHelloWorldJob")
    @ApiOperation("pause")
    public String pauseHelloWorldJob() throws SchedulerException {
        quartzJobService.pauseJob(jobKey);
        return "pauseHelloWorldJob success";
    }


    /**
     * 恢复 hello world
     */
    @GetMapping("/resumeHelloWorldJob")
    @ApiOperation("resume")
    public String resumeHelloWorldJob() throws SchedulerException {
        quartzJobService.resumeJob(jobKey);
        return "resumeHelloWorldJob success";
    }

    /**
     * 删除 hello world
     */
    @GetMapping("/deleteHelloWorldJob")
    @ApiOperation("delete")
    public String deleteHelloWorldJob() throws SchedulerException {
        quartzJobService.deleteJob(jobKey);
        return "deleteHelloWorldJob success";
    }

    /**
     * 修改 hello world 的cron表达式
     */
    @GetMapping("/modifyHelloWorldJobCron")
    @ApiOperation("modify")
    public String modifyHelloWorldJobCron() {

        //这是即将要修改cron的定时任务
        TaskDefine modifyCronTask = TaskDefine.builder()
                .jobKey(jobKey)
                .cronExpression("0/5 * * * * ? ")   //定时任务 的cron表达式
                .jobClass(SayHelloJobLogic.class)   //定时任务 的具体执行逻辑
                .description("这是一个测试的 任务")    //定时任务 的描述
                .build();
        if (quartzJobService.modifyJobCron(modifyCronTask))
            return "modifyHelloWorldJobCron success";
        else return "modifyHelloWorldJobCron fail";
    }


}
