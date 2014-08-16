package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class ElevationServlet
 */
@WebServlet("/ElevationServlet")
public class ElevationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String latString = request.getParameter("lat");
		String longString = request.getParameter("long");

		URL url = new URL(
				"http://maps.googleapis.com/maps/api/elevation/json?locations="
						+ latString + "," + longString);

		InputStream in = url.openStream();
		InputStreamReader insr = new InputStreamReader(in);

		String data = "";

		int i = 0;
		;

		while ((i = insr.read()) != -1) {
			data = data + (char) i;
		}

		JsonParser parser = new JsonParser();
		JsonObject json = (JsonObject) parser.parse(data);

		// response.getWriter().println(json.toString());

		JsonArray resArr = (JsonArray) json.get("results");

		JsonObject internalObject = (JsonObject) resArr.get(0);
		String elevation = (String) internalObject.get("elevation")
				.getAsString();

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<body bgcolor='yellow'>");
		out.println("<h1>You are at height " + elevation + " ! </h1>");

		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
