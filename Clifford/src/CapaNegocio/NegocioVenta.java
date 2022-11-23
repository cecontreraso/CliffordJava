/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.DetalleVenta;
import CapaDTO.Venta;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cesar
 */
public class NegocioVenta {
    
    private ConexionMySQL conect1;
    
    public void configurarConexion () 
    {
        this.setConect1(new ConexionMySQL());
        this.getConect1().setNombreBaseDatos("jdbc:mysql://localhost/clifford");
        this.getConect1().setNombreTabla("venta");
        this.getConect1().setCadenaConexion("com.mysql.jdbc.Driver");
        this.getConect1().setUsuario("root");
        this.getConect1().setPass("");
}
    public void insertarVenta(Venta venta)
    {
        this.configurarConexion();
        this.getConect1().setCadenaSQL("INSERT INTO venta "
                                     +" (id_venta,fecha_venta,nombre_empresa,monto_pagar,"
               + "id_detalle_venta,rut_empleado,id_metodo_pago) VALUES ("+
                                      venta.getId_venta()+ ","+
                                      venta.getFecha_venta()+ ","+
                                      venta.getNombre_empresa()+ ","+
                                      venta.getMedio_pago()+ ","+
                                      venta.getId_detalleVenta()+ ","+
                                      venta.getRut_empleado()+ ","+
                                      venta.getMedio_pago() + ");");
       this.getConect1().setEsSelect(false);
       this.getConect1().conectar();
    }
    
    
    public void actualizarDetalleVenta(Venta venta)
    {
       this.configurarConexion();
       this.getConect1().setCadenaSQL("UPDATE venta "
                                     + " SET "
                                     + ", fecha_venta = " + venta.getFecha_venta()
                                     + ", nombre_empresa = " + venta.getNombre_empresa()
                                     + ", monto_pagar = " + venta.getTotal_venta()
                                     + ", id_detalle_venta = " + venta.getId_detalleVenta()
                                     + ", rut_empleado = " + venta.getRut_empleado()
                                     + ", id_metodo_pago = " + venta.getMedio_pago()
                                     + " WHERE id_venta = " + venta.getId_venta()+ ";");
       this.getConect1().setEsSelect(false);
       this.getConect1().conectar();
    }
    
    public void eliminarDetalleVenta(int id_venta)
    {
        this.configurarConexion();
        this.getConect1().setCadenaSQL("DELETE FROM venta "
                                       + " WHERE id_venta = "+id_venta );
    }
    
    
    public ArrayList<Venta> consultaVenta()
    {
       ArrayList<Venta> auxLisVenta = new ArrayList<>();
       this.configurarConexion();
       this.getConect1().setCadenaSQL("SELECT *  FROM venta;");
       this.getConect1().setEsSelect(true);
       this.getConect1().conectar();
       
       try
       {
           while(this.getConect1().getDbresultSet().next()) 
           {
              Venta auxVenta = new Venta();
              auxVenta.setId_venta(this.getConect1().getDbresultSet().getInt("id_venta"));
              auxVenta.setFecha_venta(this.getConect1().getDbresultSet().getDate("fecha_venta"));
              auxVenta.setNombre_empresa(this.getConect1().getDbresultSet().getString("nombre_empresa"));
              auxVenta.setTotal_venta(this.getConect1().getDbresultSet().getInt("monto_pagar"));
              auxVenta.setId_detalleVenta(this.getConect1().getDbresultSet().getInt("id_detalle_venta"));
              auxVenta.setRut_empleado(this.getConect1().getDbresultSet().getString("rut_empleado"));
              auxVenta.setMedio_pago(this.getConect1().getDbresultSet().getInt("metodo_pago"));
           
              auxLisVenta.add(auxVenta);
           
           }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null, "Error SQL ..." + ex.getMessage());
       }
       return auxLisVenta; 
    
    }

    public ConexionMySQL getConect1() {
        return conect1;
    }

    public void setConect1(ConexionMySQL conect1) {
        this.conect1 = conect1;
    }
    
    
    
    
    
    
    
}