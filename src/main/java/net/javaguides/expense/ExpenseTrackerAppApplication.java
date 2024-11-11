package net.javaguides.expense;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Expense Tracker Application",
				description = "Expense Tracker Rest Api Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Sagar Bansal",
						email = "skbnsl20@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Expense Tracker Rest Api Documentation for Developers",
				url = ""
		)
)
@SpringBootApplication
public class ExpenseTrackerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerAppApplication.class, args);
	}

}
