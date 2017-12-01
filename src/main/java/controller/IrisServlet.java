package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.azure.IrisClassController;
import model.Iris;

@WebServlet("/iris")
public class IrisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IrisServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Iris iris = new Iris();
		try {
			iris.setSepalLength(Double.parseDouble(request.getParameter("sepalLength")));
			iris.setSepalWidth(Double.parseDouble(request.getParameter("sepalWidth")));
			iris.setPetalLength(Double.parseDouble(request.getParameter("petalLength")));
			iris.setPetalWidth(Double.parseDouble(request.getParameter("petalWidth")));

			IrisClassController icc = new IrisClassController();
			iris.setClasse(icc.getIrisClass(iris));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("iris", iris);
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		}
	}

}
