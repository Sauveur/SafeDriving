package com.safedriving.servlet;

import java.io.IOException;

import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.safedriving.dao.jpa.JpaAdresseDao;
import com.safedriving.entity.Adresse;

/**
 * Servlet implementation class MyTestServlet
 */
public class MyTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyTestServlet() {
//    	Adresse adresseTest = new Adresse();
//    	adresseTest.setVoie("69 rue des fesses");
//    	adresseTest.setVille("Moncul");
//    	adresseTest.setCodePostal(69000);
//        JpaAdresseDao adresseDao = new JpaAdresseDao(Persistence.createEntityManagerFactory("SafeDriving-PU"));
//        adresseDao.ajouter(adresseTest);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
