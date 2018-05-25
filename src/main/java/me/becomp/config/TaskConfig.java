package me.becomp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by sapun4ik on 18.03.2018.
 */
@Configuration
@EnableScheduling
@ComponentScan({ "me.becomp.task" })
public class TaskConfig {}

