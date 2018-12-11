/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Ariel
 */
public class ConsultaPaciente {

    private Long idConsulta;
    private Long id_paciente;
    private Long id_usuario;
    private String data;

    public ConsultaPaciente(Long idConsulta, Long id_paciente, Long id_usuario, String data) {
        this.idConsulta = idConsulta;
        this.id_paciente = id_paciente;
        this.id_usuario = id_usuario;
        this.data = data;
    }

  
    public ConsultaPaciente() {
    }

    public Long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

   

    public Long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
