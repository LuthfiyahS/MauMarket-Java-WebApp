/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimarket;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class Quiz extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Quiz</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Quiz at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<style>\n" +
"          @import url(\"https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap\");\n" +
".wrapper {\n" +
"  max-width: 1140px;\n" +
"  padding-left: 1rem;\n" +
"  padding-right: 1rem;\n" +
"  margin-left: auto;\n" +
"  margin-right: auto;\n" +
"}\n" +
"\n" +
"*,\n" +
"*:before,\n" +
"*:after {\n" +
"  box-sizing: border-box;\n" +
"}\n" +
"\n" +
"a {\n" +
"  text-decoration: none;\n" +
"  color: #222;\n" +
"}\n" +
"\n" +
"html {\n" +
"  -webkit-font-smoothing: antialiased;\n" +
"  -moz-osx-font-smoothing: grayscale;\n" +
"}\n" +
"\n" +
"body {\n" +
"  font-family: \"Roboto\", sans-serif;\n" +
"}\n" +
"\n" +
".sr-only {\n" +
"  position: absolute;\n" +
"  clip: rect(1px, 1px, 1px, 1px);\n" +
"  padding: 0;\n" +
"  border: 0;\n" +
"  height: 1px;\n" +
"  width: 1px;\n" +
"  overflow: hidden;\n" +
"}\n" +
"\n" +
".button {\n" +
"  -webkit-appearance: none;\n" +
"     -moz-appearance: none;\n" +
"          appearance: none;\n" +
"  color: #fff;\n" +
"  background-color: #2fa0f6;\n" +
"  min-width: 120px;\n" +
"  padding: 0.5rem 1rem;\n" +
"  border-radius: 5px;\n" +
"  text-align: center;\n" +
"}\n" +
"\n" +
".button svg {\n" +
"  display: inline-block;\n" +
"  vertical-align: middle;\n" +
"  width: 24px;\n" +
"  height: 24px;\n" +
"  fill: #fff;\n" +
"}\n" +
"\n" +
".button span {\n" +
"  display: none;\n" +
"}\n" +
"\n" +
"@media (min-width: 600px) {\n" +
"  .button span {\n" +
"    display: initial;\n" +
"  }\n" +
"}\n" +
"\n" +
".button--icon {\n" +
"  min-width: initial;\n" +
"  padding: 0.5rem;\n" +
"}\n" +
"\n" +
"/* \n" +
"** The Header Media Queries **\n" +
"** Tweak as per your needs **\n" +
"*/\n" +
".brand {\n" +
"  font-weight: bold;\n" +
"  font-size: 20px; }\n" +
"\n" +
".site-header {\n" +
"  position: relative;\n" +
"      margin: -0.5rem;\n" +
"  background-color: #F3EBF6;\n" +
"        box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);}\n" +
"\n" +
".site-header__start {\n" +
"  display: flex;\n" +
"  align-items: center; }\n" +
"\n" +
".site-header__end {\n" +
"  display: flex;\n" +
"  align-items: center; }\n" +
"\n" +
".site-header__wrapper {\n" +
"  display: flex;\n" +
"  justify-content: space-between;\n" +
"  align-items: center;\n" +
"  padding-top: 1rem;\n" +
"  padding-bottom: 1rem; }\n" +
"button{\n" +
"    cursor: pointer;\n" +
"        border-radius: 5em;\n" +
"        color: #fff;\n" +
"        background: linear-gradient(to right, #9C27B0, #E040FB);\n" +
"        border: 0;\n" +
"        padding-left: 40px;\n" +
"        padding-right: 40px;\n" +
"        padding-bottom: 10px;\n" +
"        padding-top: 10px;\n" +
"        font-family: 'Ubuntu', sans-serif;\n" +
"        font-size: 13px;\n" +
"        box-shadow: 0 0 20px 1px rgba(0, 0, 0, 0.04);\n" +
"}\n" +
"  @media (min-width: 800px) {\n" +
"    .site-header__wrapper {\n" +
"      padding-top: 0;\n" +
"      padding-bottom: 0; } }\n" +
"@media (min-width: 800px) {\n" +
"  .nav__wrapper {\n" +
"    display: flex; } }\n" +
"\n" +
"@media (max-width: 799px) {\n" +
"  .nav__wrapper {\n" +
"    position: absolute;\n" +
"    top: calc(100% + 35px);\n" +
"    right: 0;\n" +
"    left: 0;\n" +
"    z-index: -1;\n" +
"    background-color: #F3EBF6;\n" +
"    visibility: hidden;\n" +
"    opacity: 0;\n" +
"    transform: translateY(-100%);\n" +
"    transition: transform 0.3s ease-out, opacity 0.3s ease-out; }\n" +
"    .nav__wrapper.active {\n" +
"      visibility: visible;\n" +
"      opacity: 1;\n" +
"      transform: translateY(0); } }\n" +
"\n" +
".nav__item:not(:last-child) {\n" +
"  margin-right: 0.5rem; }\n" +
"\n" +
".nav__item a {\n" +
"  display: block;\n" +
"  padding: 1rem;\n" +
"  border-left: 4px solid transparent; }\n" +
"  @media (min-width: 800px) {\n" +
"    .nav__item a {\n" +
"      text-align: center;\n" +
"      border-left: 0;\n" +
"      border-bottom: 4px solid transparent; } }\n" +
".nav__item svg {\n" +
"  display: inline-block;\n" +
"  vertical-align: middle;\n" +
"  width: 28px;\n" +
"  height: 28px;\n" +
"  margin-right: 1rem; }\n" +
"  @media (min-width: 800px) {\n" +
"    .nav__item svg {\n" +
"      display: block;\n" +
"      margin: 0 auto 0.5rem; } }\n" +
".nav__item.active a {\n" +
"  border-left-color: #222; }\n" +
"  @media (min-width: 800px) {\n" +
"    .nav__item.active a {\n" +
"      border-bottom-color: #222; } }\n" +
".nav__toggle {\n" +
"        \n" +
"  display: none; }\n" +
"  @media (max-width: 799px) {\n" +
"    .nav__toggle {\n" +
"      display: block;\n" +
"      position: absolute;\n" +
"      right: 1rem;\n" +
"      top: 1rem; } }\n" +
".search {\n" +
"  display: flex;\n" +
"  margin-left: 1rem; }\n" +
"\n" +
".search__toggle {\n" +
"  appearance: none;\n" +
"  order: 1;\n" +
"  font-size: 0;\n" +
"  width: 34px;\n" +
"  height: 34px;\n" +
"  background: url(\"../img/header-3/search.svg\") center right/22px no-repeat;\n" +
"  border: 0;\n" +
"  display: none; }\n" +
"  @media (min-width: 800px) {\n" +
"    .search__toggle {\n" +
"      border-left: 1px solid #979797;\n" +
"      padding-left: 10px; } }\n" +
"  @media (max-width: 799px) {\n" +
"    .search__toggle {\n" +
"      position: absolute;\n" +
"      right: 5.5rem;\n" +
"      top: 0.65rem;\n" +
"      background: url(\"../img/header-3/search.svg\") center/22px no-repeat; } }\n" +
".search__form {\n" +
"  display: block; }\n" +
"  .search__form.active {\n" +
"    display: block; }\n" +
"  @media (max-width: 799px) {\n" +
"    .search__form {\n" +
"      position: absolute;\n" +
"      left: 0;\n" +
"      right: 0;\n" +
"      top: 100%; }\n" +
"      .search__form input {\n" +
"        width: 100%; } }\n" +
"  .search__form input {\n" +
"    min-width: 200px;\n" +
"    appearance: none;\n" +
"    border: 0;\n" +
"    background-color: #fff;\n" +
"    border-radius: 0;\n" +
"    font-size: 16px;\n" +
"    padding: 0.5rem; }\n" +
"    @media (max-width: 799px) {\n" +
"      .search__form input {\n" +
"        border-bottom: 1px solid #979797; } }\n" +
".inactive-item {\n" +
"  opacity: 0; }\n" +
"\n" +
".main {\n" +
"        background-color: #F3EBF6;\n" +
"        width: 90%;\n" +
"        height: auto;\n" +
"        margin: 7em auto;\n" +
"        padding: 25px;\n" +
"        border-radius: 1.5em;\n" +
"        box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);\n" +
"    }\n" +
"    input radio{\n" +
"        background-color: #F3EBF6;\n" +
"    }\n" +
"      </style>");
        
        //HEAD
        out.println("<header class=\"site-header\">\n" +
"      <div class=\"wrapper site-header__wrapper\">\n" +
"        <div class=\"site-header__start\">\n" +
"          <a href=\"homepage.html\" class=\"brand\"><img alt=\"\" src=\"logomau.png\" height=\"75px\" width=\"auto\"/></a>\n" +
"        </div>\n" +
"        <div class=\"site-header__end\">\n" +
"          <nav class=\"nav\">\n" +
"            <button class=\"nav__toggle\" aria-expanded=\"false\" type=\"button\">\n" +
"              menu\n" +
"            </button>\n" +
"            <ul class=\"nav__wrapper\">\n" +
"              <li class=\"nav__item active\">\n" +
"                <a href=\"#\">\n" +
"                  <svg viewBox=\"0 0 24 24\" width=\"24px\" height=\"24px\" x=\"0\" y=\"0\" preserveAspectRatio=\"xMinYMin meet\"  class=\"nav-icon\" focusable=\"false\" xmlns=\"http://www.w3.org/2000/svg\" >\n" +
"                    <path\n" +
"                      d=\"M22,9.45,12.85,3.26A1.52,1.52,0,0,0,12,3a1.49,1.49,0,0,0-.84.26L2,9.45,3.06,11,4,10.37V20a1,1,0,0,0,1,1h5V16h4v5h5a1,1,0,0,0,1-1V10.37l.94.63Z\"\n" +
"                      class=\"active-item\"\n" +
"                      style=\"fill-opacity: 1\"\n" +
"                    ></path>\n" +
"                    <path\n" +
"                      d=\"M22,9.45L12.85,3.26a1.5,1.5,0,0,0-1.69,0L2,9.45,3.06,11,4,10.37V20a1,1,0,0,0,1,1h6V16h2v5h6a1,1,0,0,0,1-1V10.37L20.94,11ZM18,19H15V15a1,1,0,0,0-1-1H10a1,1,0,0,0-1,1v4H6V8.89l6-4,6,4V19Z\"\n" +
"                      class=\"inactive-item\"\n" +
"                      style=\"fill: currentColor\"\n" +
"                    ></path>\n" +
"                  </svg>\n" +
"                  <span>Home</span>\n" +
"                </a>\n" +
"              </li>\n" +
"              <li class=\"nav__item\">\n" +
"                <a href=\"#\">\n" +
"                  <svg\n" +
"                    viewBox=\"0 0 24 24\"\n" +
"                    width=\"24px\"\n" +
"                    height=\"24px\"\n" +
"                    x=\"0\"\n" +
"                    y=\"0\"\n" +
"                    preserveAspectRatio=\"xMinYMin meet\"\n" +
"                    class=\"nav-icon\"\n" +
"                    focusable=\"false\"\n" +
"                    xmlns=\"http://www.w3.org/2000/svg\"\n" +
"                  >\n" +
"                    <path\n" +
"                      d=\"M16,17.85V20a1,1,0,0,1-1,1H1a1,1,0,0,1-1-1V17.85a4,4,0,0,1,2.55-3.73l2.95-1.2V11.71l-0.73-1.3A6,6,0,0,1,4,7.47V6a4,4,0,0,1,4.39-4A4.12,4.12,0,0,1,12,6.21V7.47a6,6,0,0,1-.77,2.94l-0.73,1.3v1.21l2.95,1.2A4,4,0,0,1,16,17.85Zm4.75-3.65L19,13.53v-1a6,6,0,0,0,1-3.31V9a3,3,0,0,0-6,0V9.18a6,6,0,0,0,.61,2.58A3.61,3.61,0,0,0,16,13a3.62,3.62,0,0,1,2,3.24V21h4a1,1,0,0,0,1-1V17.47A3.5,3.5,0,0,0,20.75,14.2Z\"\n" +
"                      class=\"inactive-item\"\n" +
"                      style=\"fill-opacity: 1\"\n" +
"                    ></path>\n" +
"                    <path\n" +
"                      d=\"M20.74,14.2L19,13.54V12.86l0.25-.41A5,5,0,0,0,20,9.82V9a3,3,0,0,0-6,0V9.82a5,5,0,0,0,.75,2.63L15,12.86v0.68l-1,.37a4,4,0,0,0-.58-0.28l-2.45-1V10.83A8,8,0,0,0,12,7V6A4,4,0,0,0,4,6V7a8,8,0,0,0,1,3.86v1.84l-2.45,1A4,4,0,0,0,0,17.35V20a1,1,0,0,0,1,1H22a1,1,0,0,0,1-1V17.47A3.5,3.5,0,0,0,20.74,14.2ZM16,8.75a1,1,0,0,1,2,0v1.44a3,3,0,0,1-.38,1.46l-0.33.6a0.25,0.25,0,0,1-.22.13H16.93a0.25,0.25,0,0,1-.22-0.13l-0.33-.6A3,3,0,0,1,16,10.19V8.75ZM6,5.85a2,2,0,0,1,4,0V7.28a6,6,0,0,1-.71,2.83L9,10.72a1,1,0,0,1-.88.53H7.92A1,1,0,0,1,7,10.72l-0.33-.61A6,6,0,0,1,6,7.28V5.85ZM14,19H2V17.25a2,2,0,0,1,1.26-1.86L7,13.92v-1a3,3,0,0,0,1,.18H8a3,3,0,0,0,1-.18v1l3.72,1.42A2,2,0,0,1,14,17.21V19Zm7,0H16V17.35a4,4,0,0,0-.55-2l1.05-.4V14.07a2,2,0,0,0,.4.05h0.2a2,2,0,0,0,.4-0.05v0.88l2.53,1a1.5,1.5,0,0,1,1,1.4V19Z\"\n" +
"                      class=\"active-item\"\n" +
"                      style=\"fill: currentColor\"\n" +
"                    ></path>\n" +
"                  </svg>\n" +
"                  <span>My User</span>\n" +
"                </a>\n" +
"              </li>\n" +
"              <li class=\"nav__item\">\n" +
"                <a href=\"viewBarang\">\n" +
"                  <svg\n" +
"                    viewBox=\"0 0 24 24\"\n" +
"                    width=\"24px\"\n" +
"                    height=\"24px\"\n" +
"                    x=\"0\"\n" +
"                    y=\"0\"\n" +
"                    preserveAspectRatio=\"xMinYMin meet\"\n" +
"                    class=\"nav-icon\"\n" +
"                    focusable=\"false\"\n" +
"                    xmlns=\"http://www.w3.org/2000/svg\"\n" +
"                  >\n" +
"                    <path\n" +
"                      d=\"M2,13H22v6a1,1,0,0,1-1,1H3a1,1,0,0,1-1-1V13ZM22,8v4H2V8A1,1,0,0,1,3,7H7V6a3,3,0,0,1,3-3h4a3,3,0,0,1,3,3V7h4A1,1,0,0,1,22,8ZM15,6a1,1,0,0,0-1-1H10A1,1,0,0,0,9,6V7h6V6Z\"\n" +
"                      class=\"inactive-item\"\n" +
"                      style=\"fill-opacity: 1\"\n" +
"                    ></path>\n" +
"                    <path\n" +
"                      d=\"M21,7H17V6a3,3,0,0,0-3-3H10A3,3,0,0,0,7,6V7H3A1,1,0,0,0,2,8V19a1,1,0,0,0,1,1H21a1,1,0,0,0,1-1V8A1,1,0,0,0,21,7ZM9,6a1,1,0,0,1,1-1h4a1,1,0,0,1,1,1V7H9V6ZM20,18H4V13H20v5Zm0-6H4V9H20v3Z\"\n" +
"                      class=\"active-item\"\n" +
"                      style=\"fill: currentColor\"\n" +
"                    ></path>\n" +
"                  </svg>\n" +
"                  <span>Product</span>\n" +
"                </a>\n" +
"              </li>\n" +
"              <li class=\"nav__item\">\n" +
"                <a href=\"#\">\n" +
"                  <svg\n" +
"                    viewBox=\"0 0 24 24\"\n" +
"                    width=\"24px\"\n" +
"                    height=\"24px\"\n" +
"                    x=\"0\"\n" +
"                    y=\"0\"\n" +
"                    preserveAspectRatio=\"xMinYMin meet\"\n" +
"                    class=\"nav-icon\"\n" +
"                    focusable=\"false\"\n" +
"                    xmlns=\"http://www.w3.org/2000/svg\"\n" +
"                  >\n" +
"                    <path\n" +
"                      d=\"M21,8H8A1,1,0,0,0,7,9V19a1,1,0,0,0,1,1H18l4,3V9A1,1,0,0,0,21,8Zm-4,8H12V15h5Zm1-3H11V12h7ZM17,4V6H6A1,1,0,0,0,5,7v8H3a1,1,0,0,1-1-1V4A1,1,0,0,1,3,3H16A1,1,0,0,1,17,4Z\"\n" +
"                      class=\"inactive-item\"\n" +
"                      style=\"fill-opacity: 1\"\n" +
"                    ></path>\n" +
"                    <path\n" +
"                      d=\"M21,8H8A1,1,0,0,0,7,9V19a1,1,0,0,0,1,1H18l4,3V9A1,1,0,0,0,21,8ZM20,19.11L18.52,18H9V10H20v9.11ZM12,15h5v1H12V15ZM4,13H5v2H3a1,1,0,0,1-1-1V4A1,1,0,0,1,3,3H16a1,1,0,0,1,1,1V6H15V5H4v8Zm14,0H11V12h7v1Z\"\n" +
"                      class=\"active-item\"\n" +
"                      style=\"fill: currentColor\"\n" +
"                    ></path>\n" +
"                  </svg>\n" +
"                  <span>Transaksi</span>\n" +
"                </a>\n" +
"              </li>\n" +
"              \n" +
"            </ul>\n" +
"          </nav>\n" +
"        </div>\n" +
"      </div>\n" +
"    </header>\n" +
"    <!-- Header End -->\n" +
"    <div class=\"main\">");
        
        
        
        //MULAI DARI SINI JAWABNYA
        int cnt = 0;
        String a = "", b = "", c = "", d = "", e = "";
        
        a = request.getParameter("no1");
        b = request.getParameter("no2");
        c = request.getParameter("no3");
        d = request.getParameter("no4");
        e = request.getParameter("no5");
        out.println("<center>");
        out.println("<h1><br> Hasil Quiz Pelanggan MAU Market <br/></h1>");
        if(a.equals("c"))
        {
            out.println("Jawaban Soal No 1  <b>Benar</b> <br/>");
            cnt=cnt+20;
        }
        else
        {
            out.println("Jawaban Soal No 1  Salah!<br/>");
        }
        if(b.equals("c"))
        {
            out.println("Jawaban Soal No 2  <b>Benar </b><br/>");
            cnt=cnt+20;
        }
        else
        {                        
            out.println("Jawaban Soal No 2  Salah!<br/>");
        }
        if(c.equals("b"))
        {            
            out.println("Jawaban Soal No 3  <b>Benar</b><br/>");
            cnt=cnt+20;
        }
        else
        {
            out.println("Jawaban Soal No 3  Salah!<br/>");

        }
        if(d.equals("a"))
        {            
            out.println("Jawaban Soal No 4  <b>Benar</b><br/>");
            cnt=cnt+20;
        }
        else
        {
            out.println("Jawaban Soal No 4  Salah!<br/>");

        }
        if(e.equals("b"))
        {            
            out.println("Jawaban Soal No 5  <b>Benar </b><br/>");
            cnt=cnt+20;
        }
        else
        {
            out.println("Jawaban Soal No 5  Salah!<br/>");

        }
        
        out.println("<h3><br> Total Nilai Anda "+cnt+" <br/></h3>");
        out.println("</center>");
        out.println("<center><a href='homepage.html'><button>Kembali Kehalaman Utama</button></a></center><br>");
        out.println("</div>");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
