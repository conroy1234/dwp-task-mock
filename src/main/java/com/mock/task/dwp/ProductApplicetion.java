package com.mock.task.dwp;

import com.mock.task.dwp.dto.Task;
import com.mock.task.dwp.dto.TaskTemplate;
import com.mock.task.dwp.repository.TaskRepository;
import com.mock.task.dwp.repository.TaskTemplateRepository;
import com.mock.task.dwp.service.TaskService;
import com.mock.task.dwp.service.TaskTemplateService;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductApplicetion implements CommandLineRunner {

	@Autowired
	private TaskTemplateRepository taskTemplateRepository;
	@Autowired
	private TaskRepository taskRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProductApplicetion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Task> tasks = List.of(
				Task.builder()
				.id(1).organisationUnitName("DWP_CARACARA").templateName("MAIN_TEMPLATE").completedBy(21092023).build(),
				Task.builder()
				.id(2).organisationUnitName("DWP_RAVEN").templateName("ALT_TEMPLATE").completedBy(20092023).build(),
				Task.builder()
				.id(3).organisationUnitName("DWP_Parrot").templateName("PARA_TEMPLATE").completedBy(19092023).build(),
				Task.builder()
				.id(4).organisationUnitName("DWP_DOGANt").templateName("DGN_TEMPLATE").completedBy(18092023).build(),
				Task.builder()
				.id(5).organisationUnitName("DWP_CARACARA").templateName("MAIN_TEMPLATE").completedBy(21092023).build()


		);

		tasks.stream().forEach(taskRepository::save);

		for(Task task: tasks){
			List<TaskTemplate> taskTemplates = List.of(
					TaskTemplate.builder()
							.id(task.getId())
							.organisationUnitName(task.getOrganisationUnitName())
							.templateName(task.getTemplateName())
							.executionUrl("someURL")
							.completedBy(task.getCompletedBy())
							.build()

			);

			taskTemplates.stream().forEach(template->{
				taskTemplateRepository.save(template);
			});
		}

	}

}
