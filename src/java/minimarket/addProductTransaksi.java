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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class addProductTransaksi extends HttpServlet {
    Connection con;
    PreparedStatement pst;
    int row;
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
            out.println("<title>Servlet addProductTransaksi</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addProductTransaksi at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //String eid = request.getParameter("nama_mk");
        Statement stmt = null,stmt2 = null;
        ResultSet rs,rs2;
        int row;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/MauMarketDB","pia", "pia");
            String kd = request.getParameter("id_barang");

            
            String sql,no;
            sql ="select count(id_pesanan) from tb_pesanan";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            if(!rs.next()){
                no="ORD0001";
            }else{
                int urutanbaru=rs.getInt(1) + 1;
                String kode=String.valueOf(urutanbaru);
                int panjangkode=kode.length();
                for(int i=panjangkode; i <4;i++){
                    kode="0"+kode;
                }
                no="ORD"+kode;
            }
            
            String sql2;
            sql2 = "SELECT * FROM tb_detailpesanan where id_pesanan='"+no+"' and id_barang='"+kd+"' ";
            stmt2 = con.createStatement();
            rs2 = stmt2.executeQuery(sql2);
            if(!rs2.next()){
                pst = con.prepareStatement("insert INTO tb_detailpesanan values('"+no+"','"+kd+"',1)");
                row = pst.executeUpdate();
                out.println("<script language=javascript> window.alert('Data Ditambahkan!'); window.location='addTransaksi';</script>");
            }else{
                int jml=Integer.parseInt(rs2.getString("kuantitas"));
                jml=jml+1;
                pst = con.prepareStatement("update TB_DETAILPESANAN SET KUANTITAS=? where id_barang=?");
                pst.setInt(1, jml);
                pst.setString(2, kd); 
                pst.executeUpdate();
                out.println("<script language=javascript> window.alert('Jumlah barang yang akan dibeli menjadi "+jml+"'); window.location='addTransaksi';</script>");
            }
        }catch(Exception e){
            out.println("<script language=javascript> window.alert('Tidak Berhasil Dihapus!"+ e.getMessage()+"'); window.location='viewBarang';</script>");
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
