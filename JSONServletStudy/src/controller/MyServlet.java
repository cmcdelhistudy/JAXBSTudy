package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Address;
import model.Employee;
import model.Vehicle;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");

		Employee e = new Employee();
		e.setId(82723L);
		e.setMarried(false);
		e.setName("Mohit Kumar");
		e.setWeight(89.65);
		e.getWords().add("Apple");
		e.getWords().add("Ball");
		e.getWords().add("Cat");

		Address ad = new Address();
		ad.setCity("Amritsar");
		ad.setStreetNumber(8);

		e.setHomeAddress(ad);

		// >>>>>>> Santro Car
		Vehicle vh = new Vehicle();
		vh.setName("Santro");
		vh.setPrice(1000);
		vh.setSerialNumber(3478838L);
		vh.setType("Four Wheeler");

		// >>>>>>> Santro Car
		Vehicle bike = new Vehicle();
		bike.setName("Bajaj Pulsar");
		bike.setPrice(500);
		bike.setSerialNumber(8978838L);
		bike.setType("Two Wheeler");

		e.getVehicleList().add(bike);
		e.getVehicleList().add(vh);

		Gson gson = new Gson();

		out.println(gson.toJson(e));

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
