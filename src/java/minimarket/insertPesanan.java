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
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class insertPesanan extends HttpServlet {

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
            out.println("<title>Servlet insertPesanan</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet insertPesanan at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
            Connection con = null;
            Statement stmt = null;
            String id_pesanan="",id_user="", ktg="Lunas", nama="",pem="";
            id_pesanan = request.getParameter("id_pesanan");
            id_user = request.getParameter("id_user");
            nama = request.getParameter("nama");
            
            pem = request.getParameter("pembayaran");
            Timestamp ts = Timestamp.from(ZonedDateTime.now().toInstant());
            try{
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                con = DriverManager.getConnection("jdbc:derby://localhost:1527/MauMarketDB","pia", "pia");
                stmt = con.createStatement();
                stmt.executeUpdate("INSERT INTO tb_pesanan(id_pesanan,id_user,nama_pelanggan,jenis_pembayaran,status,tgl_pesanan) values('"+id_pesanan+"','"+
                        id_user+"','"+nama+"','"+pem+"','"+ktg+"','"+ts+"')");
                out.println("<script language=javascript> window.alert('Insert Berhasil'); window.location='viewTransaksi';</script>");
            }catch(Exception e){
                //out.println("Error: " + e.getMessage());
                out.println("<script language=javascript> window.alert('Insert Gagal "+e.getMessage()+"); window.location='viewTransaksi';</script>");
            }
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
