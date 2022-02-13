/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimarket;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
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
import javax.servlet.http.Part;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "insertBarang", urlPatterns = {"/insertBarang"})
public class insertBarang extends HttpServlet {

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
            out.println("<title>Servlet insertBarang</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet insertBarang at " + request.getContextPath() + "</h1>");
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
            Statement stmt = null,stmt2 = null;
            int  harga,stok;
            String kd_brg="", ktg="", nama="",merek="";
            kd_brg = request.getParameter("id_barang");
            nama = request.getParameter("nama");
            
            harga = Integer.parseInt(request.getParameter("harga"));
            stok = Integer.parseInt(request.getParameter("stok"));
        
            merek = request.getParameter("merek");
            ktg = request.getParameter("kategori");
            
            ResultSet rs;
            try{
                
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                con = DriverManager.getConnection("jdbc:derby://localhost:1527/MauMarketDB","pia", "pia");
                
                String sql, no;
                sql = "select count(id_barang) from tb_barang";
                stmt2 = con.createStatement();
                rs = stmt2.executeQuery(sql);
                if (!rs.next()) {
                    no = "BRG0001";
                } else {
                    int urutanbaru = rs.getInt(1) + 1;
                    String kode = String.valueOf(urutanbaru);
                    int panjangkode = kode.length();
                    for (int i = panjangkode; i < 4; i++) {
                        kode = "0" + kode;
                    }
                    no = "BRG" + kode;
                }
                stmt = con.createStatement();
                stmt.executeUpdate("INSERT INTO tb_barang(id_barang,nama_barang,harga,stok,merek,kategori) values('"+no+"','"+
                        nama+"',"+harga+","+stok+",'"+merek+"','"+ktg+"')");
                out.println("<script language=javascript> window.alert('Insert Berhasil'); window.location='viewBarang';</script>");
            }catch(Exception e){
                //out.println("Error: " + e.getMessage());
                out.println("<script language=javascript> window.alert('Insert Gagal'); window.location='viewBarang';</script>");
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
