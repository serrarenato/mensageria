package br.com.mensageria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import br.com.mensageria.model.Employee;

@SpringBootApplication
@EnableBinding(Sink.class)
public class EmployeeRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRegistrationApplication.class, args);
	}
	@StreamListener(target = Sink.INPUT)
	public void processRegisterEmployees(Employee employee) {
		System.out.println("Employees Registered by Client " + employee);
	}
}
