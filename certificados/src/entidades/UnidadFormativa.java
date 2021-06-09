
package entidades;

/**
 *
 * @author borda
 */
public class UnidadFormativa {
    
    // Atributos de la clase
    
    private String codigo;
    private String descripcion;
    private int horas;
    
    // Constructores (un constructor vacío y otro con todos los atributos)

    public UnidadFormativa() {
    }

    public UnidadFormativa(String codigo, String descripcion, int horas) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.horas = horas;
    }
    
    // Metodos Get

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getHoras() {
        return horas;
    }
    
    // Metodos Set

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
     
}
