package pck.day16.day16;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import pck.day16.day16.model.Address;
import pck.day16.day16.model.Employee;
import pck.day16.day16.model.Phone;

@SpringBootApplication
public class Day16Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Day16Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//slide 7
		JsonObjectBuilder empBuilder = Json.createObjectBuilder();
		empBuilder.add("firstName", "Will")
				.add("lastName", "Smith")
				.add("salary", 20000);

		JsonObjectBuilder addressBuilder = Json.createObjectBuilder();
		addressBuilder.add("line1", "Potong Pasir View")
				.add("line2", "8 Potong Pasir Ave 1")
				.add("postal", "358008");
		
		empBuilder.add("address", addressBuilder);

		JsonObjectBuilder phone1 = Json.createObjectBuilder();
		phone1.add("type", "mobile")
				.add("number", "97304666");
		JsonObjectBuilder phone2 = Json.createObjectBuilder();
		phone2.add("type", "mobile")
				.add("number", "96843547");

		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		arrayBuilder.add(phone1).add(phone2);
		empBuilder.add("phones", arrayBuilder);

		JsonObject employee = empBuilder.build();

		//to map JsonObject back to Employee entity
		Employee emp = new Employee();
		emp.setFirstName(employee.get("firstName").toString());
		emp.setLastName(employee.getString("lastName"));
		emp.setSalary(Long.parseLong(employee.get("salary").toString()));
		
		JsonObject addressObj = employee.getJsonObject("address");
		Address myAddress = new Address(addressObj.get("line1").toString(), 
			addressObj.get("line2").toString(), 
			addressObj.get("postal").toString());
		emp.setAddress(myAddress);

		JsonArray phones = employee.getJsonArray("phones");
		List<Phone> phoneList = new ArrayList<>();
		for (int x = 0; x < phones.size(); x++) {
			JsonObject obj = phones.getJsonObject(x);
			Phone phone = new Phone(obj.getString("type"), obj.getString("number"));
			phoneList.add(phone);
		}
		emp.setPhones(phoneList);
	}

}
