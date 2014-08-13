import java.io.File;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.cmcltd.jaxbstudy.entity.Address;
import com.cmcltd.jaxbstudy.entity.Bird;
import com.cmcltd.jaxbstudy.entity.Employee;

public class MainClass {

	public static void main(String[] args) {

		Employee e = new Employee();
		e.setId(3848);
		e.setName("Ramesh Kumar");
		e.setWeight(78.8);
		e.setInfo("Employee Info");
		e.getWords().add("Hello");
		e.getWords().add("Apple");
		e.getWords().add("Mango");

		Address ad = new Address();
		ad.setCity("New York");
		ad.setStreet(3);

		e.setHomeAddress(ad);

		try {
			Class[] clasess = { Employee.class };
			JAXBContext jaxbc = JAXBContext.newInstance(clasess);

			Marshaller marsh = jaxbc.createMarshaller();
			marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marsh.marshal(e, new File("info.xml"));

			System.out.println("Employee Object marshed ! ");

		} catch (JAXBException e1) {
			System.out.println("JAXB Exception " + e1.getMessage());
			e1.printStackTrace();
		}

		// try {
		// Class[] clasess = { Employee.class };
		// JAXBContext jaxbc = JAXBContext.newInstance(clasess);
		//
		// Unmarshaller unmarsh = jaxbc.createUnmarshaller();
		// Employee emp = (Employee) unmarsh.unmarshal(new File("info.xml"));
		//
		// System.out.println("Obtained name : " + emp.getName());
		// System.out.println("Obtained ID: " + emp.getId());
		// System.out.println("Obtained Wt : " + emp.getWeight());
		//
		// } catch (JAXBException e1) {
		// System.out.println("JAXB Exception " + e1.getMessage());
		// e1.printStackTrace();
		// }

	}
}
