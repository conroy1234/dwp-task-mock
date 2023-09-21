package com.mock.task.dwp.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties("dwp-task-mock")
public class CreateTaskTemplate {
    private String organisationalUnitName;
    private String taskTemplateName;

}
