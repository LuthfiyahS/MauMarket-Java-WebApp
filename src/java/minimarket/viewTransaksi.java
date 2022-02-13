/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimarket;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "viewTransaksi", urlPatterns = {"/viewTransaksi"})
public class viewTransaksi extends HttpServlet {

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
            out.println("<title>Servlet viewTransaksi</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet viewTransaksi at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs;
        int row;
        
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/MauMarketDB","pia", "pia");

            String sql;
            //sql = "SELECT id_pesanan, id_user, nama, nama_pelanggan, jenis_pembayaran, status, tgl_pesanan FROM tb_pesanan JOIN tb_user ON tb_pesanan.id_user = tb_user.id_user order by id_pesanan asc;";
            sql = "SELECT * from tb_pesanan order by id_pesanan asc";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            
            out.println("<style>\n" +
"          @import url(\"https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap\");\n" +
".wrapper { max-width: 1140px; padding-left: 1rem; padding-right: 1rem; margin-left: auto; margin-right: auto; }\n" +
"*, *:before,*:after { box-sizing: border-box; }\n" +
"a {text-decoration: none; color: #222; }\n" +
"html { -webkit-font-smoothing: antialiased; -moz-osx-font-smoothing: grayscale; }\n" +
"body { font-family: \"Roboto\", sans-serif; }\n" +
".sr-only {position: absolute; clip: rect(1px, 1px, 1px, 1px); padding: 0; border: 0; height: 1px;width: 1px;overflow: hidden;}\n" +
".button {-webkit-appearance: none; -moz-appearance: none;appearance: none;color: #fff;background-color: #2fa0f6;min-width: 120px;padding: 0.5rem 1rem;border-radius: 5px;text-align: center;}\n" +
".button svg {display: inline-block;vertical-align: middle;width: 24px;height: 24px;fill: #fff;}\n" +
".button span {display: none;}\n" +
"@media (min-width: 600px) {.button span {display: initial;}}\n" +
".button--icon {min-width: initial;padding: 0.5rem;}\n" +
"/* \n" +
"** The Header Media Queries **\n" +
"** Tweak as per your needs **\n" +
"*/\n" +
".brand {font-weight: bold;font-size: 20px; }\n" +
".site-header {position: relative;margin: -0.5rem;background-color: #F3EBF6;box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);}\n" +
".site-header__start {display: flex;align-items: center; }\n" +
".site-header__end {display: flex;align-items: center; }\n" +
".site-header__wrapper {display: flex;justify-content: space-between;align-items: center;padding-top: 1rem;padding-bottom: 1rem; }\n" +
"button{cursor: pointer;border-radius: 5em;color: #fff;background: linear-gradient(to right, #9C27B0, #E040FB);border: 0;padding-left: 40px;padding-right: 40px;padding-bottom: 10px;padding-top: 10px;font-family: 'Ubuntu', sans-serif;font-size: 13px;box-shadow: 0 0 20px 1px rgba(0, 0, 0, 0.04);}\n" +
"@media (min-width: 800px) {\n" +
"   .site-header__wrapper { padding-top: 0;padding-bottom: 0; } }\n" +
"@media (min-width: 800px) {\n" +
"  .nav__wrapper {display: flex; } }\n" +
"@media (max-width: 799px) {\n" +
"  .nav__wrapper {position: absolute;top: calc(100% + 35px);right: 0;left: 0; z-index: -1; background-color: #F3EBF6; visibility: hidden;opacity: 0;transform: translateY(-100%); transition: transform 0.3s ease-out, opacity 0.3s ease-out; }\n" +
"  .nav__wrapper.active {visibility: visible;opacity: 1;transform: translateY(0); } }\n" +
"  .nav__item:not(:last-child) {margin-right: 0.5rem; }\n" +
"  .nav__item a {display: block; padding: 1rem; border-left: 4px solid transparent; }\n" +
"@media (min-width: 800px) {\n" +
"  .nav__item a {text-align: center;border-left: 0;border-bottom: 4px solid transparent; } }\n" +
"  .nav__item svg {display: inline-block;vertical-align: middle;width: 28px;height: 28px;margin-right: 1rem; }\n" +
"@media (min-width: 800px) {\n" +
"  .nav__item svg {display: block; margin: 0 auto 0.5rem; } }\n" +
"  .nav__item.active a {border-left-color: #222; }\n" +
"@media (min-width: 800px) {\n" +
"  .nav__item.active a {border-bottom-color: #222; } }\n" +
"  .nav__toggle {display: none; }\n" +
"@media (max-width: 799px) {\n" +
"  .nav__toggle {display: block;position: absolute;right: 1rem;top: 1rem; } }\n" +
".inactive-item { opacity: 0; }\n" +
".main { background-color: #F3EBF6; width: 90%; height: auto;margin: 7em auto;  padding: 25px; border-radius: 1.5em; box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);}\n" +
"table {border-collapse: collapse;width: 100%;}\n" +
"th, td { text-align: left;padding: 8px;}\n" +
"tr:nth-child(even) {background-color: #f2f2f2;}\n" + 
"th{text-align: center;font-size:20px;font-style:bold;}</style>");
        
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
"              <li class=\"nav__item\">\n" +
"                <a href='homepage.html'>\n" +
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
"              <li class='nav__item'>\n" +
"                <a href='viewUser'>\n" +
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
"              <li class='nav__item'>\n" +
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
"              <li class='nav__item active'>\n" +
"                <a href='viewTransaksi'>\n" +
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
"    <div class='main'>");
        
        
        
        //MULAI DARI SINI JAWABNYA
            out.println("<h1 align='center'>Data Transaksi</h1>");
            out.println("<center><a href='addTransaksi'><button>Buat Transaksi</button></a></center><br>");
            out.println("<table border='1' align='center'");
            out.println("<tr>");
            out.println("<th>Kode Transaksi</th>");
            out.println("<th>Nama Pelayan</th>");
            out.println("<th>Nama Pelanggan</th>");
            out.println("<th>Jenis Pembayaran</th>");
            out.println("<th>Status Pembayaran</th>");
            out.println("<th>Action</th>");
            out.println("</tr>");
        while(rs.next()){
            out.println("<tr>");
            out.println("<td>" + rs.getString("id_pesanan") + "</td>");
            out.println("<td>" + rs.getString("id_user") + "</td>");
            out.println("<td>" + rs.getString("nama_pelanggan") + "</td>");
            out.println("<td>" + rs.getString("jenis_pembayaran") + "</td>");
            out.println("<td>" + rs.getString("status") + "</td>");
            out.println("<td style='text-align:center;'>" + "<a href='detailTransaksi?id_pesanan="+rs.getString("id_pesanan")+"'><i class='fas fa-file' title='Detail'></i> </a> |<a href='editTransaksi?id_pesanan="+rs.getString("id_pesanan")+"'><i class='fas fa-edit' title='Edit'></i> </a> | <a href='deletePesanan?id_pesanan="+rs.getString("id_pesanan")+"'><i class='fas fa-trash' title='Delete'></i></a></td>");
            out.println("</tr>");
        }
            out.println("</table>");
            out.println("</div>");
            out.println("<script src=\"https://kit.fontawesome.com/a076d05399.js\" crossorigin=\"anonymous\"></script>");
        } catch(Exception e){
            out.println("Error: " + e.getMessage());
        }
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
        processRequest(request, response);
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
