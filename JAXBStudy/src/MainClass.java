import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.cmcltd.jaxbstudy.entity.Company;
import com.cmcltd.jaxbstudy.entity.Employee;
import com.cmcltd.jaxbstudy.entity.Manager;
import com.cmcltd.jaxbstudy.entity.Staff;

public class MainClass {

	public static void main(String[] args) {

		// Employee e = new Employee();
		// e.setId(3848);
		// e.setName("Kuldeep Kumar");
		// e.setWeight(98.8);
		// e.setInfo("Employee Info");
		// e.getWords().add("Cat");
		// e.getWords().add("Rat");
		// e.getWords().add("Mango");
		//
		// Address ad = new Address();
		// ad.setCity("New Delhi");
		// ad.setStreet(3);
		//
		// e.setHomeAddress(ad);
		//
		// Manager m = new Manager();
		// m.setId(37848);
		// m.setName("Suresh Kumar");
		// m.setWeight(108.8);
		// m.setInfo("Manager Info");
		// m.getWords().add("Vanilla");
		// m.getWords().add("Rat");
		//
		// ad = new Address();
		// ad.setCity("New Jersy");
		// ad.setStreet(6);
		//
		// m.setHomeAddress(ad);
		//
		// Staff st = new Staff();
		// st.setId(98848);
		// st.setName("Ramesh Kumar");
		// st.setWeight(78.8);
		// st.setInfo("Staff Info");
		// st.setWorkType("Cleaning");
		// st.getWords().add("Hello");
		// st.getWords().add("Apple");
		// st.getWords().add("Mango");
		//
		// Address ad2 = new Address();
		// ad2.setCity("New York");
		// ad2.setStreet(3);
		//
		// st.setHomeAddress(ad2);
		//
		// Company company = new Company();
		// company.getEmployees().add(st);
		// company.getEmployees().add(m);
		// company.getEmployees().add(e);
		//
		// try {
		// Class[] clasess = { Employee.class, Staff.class, Manager.class,
		// Company.class };
		// JAXBContext jaxbc = JAXBContext.newInstance(clasess);
		//
		// Marshaller marsh = jaxbc.createMarshaller();
		// marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// // marsh.marshal(st, new File("info1.xml"));
		// // marsh.marshal(m, new File("info2.xml"));
		//
		// marsh.marshal(company, new File("employeesInfo.xml"));
		//
		// System.out.println("Employee Object marshed ! ");
		//
		// } catch (JAXBException e1) {
		// System.out.println("JAXB Exception " + e1.getMessage());
		// e1.printStackTrace();
		// }

		try {
			Class[] clasess = { Employee.class, Staff.class, Manager.class,
					Company.class };
			JAXBContext jaxbc = JAXBContext.newInstance(clasess);

			Unmarshaller unmarsh = jaxbc.createUnmarshaller();
			Company obtainedComp = (Company) unmarsh.unmarshal(new File(
					"employeesInfo.xml"));

			List<Employee> obtainedEmp = obtainedComp.getEmployees();

			for (Employee emp : obtainedEmp) {

				System.out.println("---------------------------------");
				System.out.println("Obtained name : " + emp.getName());
				System.out.println("Obtained ID: " + emp.getId());
				System.out.println("Obtained Wt : " + emp.getWeight());

				if (emp instanceof Manager) {
					Manager m = (Manager) emp;
					System.out.println("Employee Type : MANAGER ");
					System.out.println("\t \t : Manager's Dept "
							+ m.getDepartment());
				} else if (emp instanceof Staff) {
					Staff st = (Staff) emp;
					System.out.println("Employee Type : STAFF ");
					System.out.println("\t \t : Staff's Work Type "
							+ st.getWorkType());
				}else{
					System.out.println("Employee Type : NORMAL EMPLOYEE ");
				}

			}

		} catch (JAXBException e1) {
			System.out.println("JAXB Exception " + e1.getMessage());
			e1.printStackTrace();
		}

	}
}
