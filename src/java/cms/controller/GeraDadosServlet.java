/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms.controller;

import cms.ado.ProdutoADO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import org.json.simple.JSONObject;
import org.json.simple.JsonArray;

/**
 *
 * @author tatuapu
 */
public class GeraDadosServlet extends HttpServlet {

    private ProdutoADO prodA;

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
            
            prodA = new ProdutoADO();
            String acao = request.getParameter("acao");
            
            if(acao!=null){
                if(acao.equalsIgnoreCase("salvaUp")){
                    Integer idProduto = Integer.parseInt(request.getParameter("idProduto"));
                    String coluna = request.getParameter("col");
                    String valor = request.getParameter("valor");
                    Produto p = new Produto();
                    p.setIdProduto(idProduto);
                    if(coluna.contains("colNm")){
                        coluna = "produtoNm";
                        p.setProdutoNm(valor);
                    }else if(coluna.contains("colDesc")){
                        coluna = "produtoDesc";
                        
                        p.setProdutoDesc(coluna);
                    }                      
                    
                    try {
                        prodA.atualizar(p);
                    } catch (Exception ex) {
                        Logger.getLogger(GeraDadosServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }else{
            
                
                //carregando os produtos
                List<Produto> listaProduto;
                try {
                    listaProduto = prodA.listaTodos();
                    JSONObject pai = new JSONObject();
                    JsonArray filhos = new JsonArray();
                    JSONObject dados;
                    for(Produto p:listaProduto){
                        dados = new JSONObject();
                        dados.put("idProduto",p.getIdProduto());
                        dados.put("produtoNm", p.getProdutoNm());
                        dados.put("produtoDesc", p.getProdutoDesc());
                        filhos.add(dados);
                    }
                    pai.put("data", filhos);
                    out.print(pai);

                } catch (Exception ex) {
                    out.print("ERRO no Servlet");
                }
            }
            
            
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
