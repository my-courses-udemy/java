
package domain;

import java.util.Date;

public class Cliente extends Persona {

    private int idClient;
    private static int contadorCliente;
    private Date fechaRegistro;
    private Boolean vip;

    public Cliente(Date fechaRegistro, boolean vip, String nombre, char genero, int edad, String direccion) {
        super(nombre, genero, edad, direccion);
        this.idClient = ++Cliente.contadorCliente;
        this.fechaRegistro =  fechaRegistro;
        this.vip = vip;
    }
    
    public Cliente(Date fechaRegistro, Boolean vip, String nombre) {
        super(nombre);
        this.idClient = ++Cliente.contadorCliente;
        this.vip = vip;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdClient() {
        return idClient;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Boolean getVip() {
        return vip;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{idClient=").append(idClient);
        sb.append(", fechaRegistro=").append(fechaRegistro);
        sb.append(", vip=").append(vip);
        sb.append(", ").append(super.toString());
        sb.append('}');
        return sb.toString();
    }    
    
}
