import java.util.Objects;

public class Cliente {
    // Atributos encapsulados (private)
    private int id;
    private String codigo;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    // Constructor completo
    public Cliente(int id, String codigo, String nombre, String apellido, String email, String telefono) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    // Getters (accesores)
    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    // Representación textual del objeto
    @Override
    public String toString() {
        return "ID: " + id +
                "\nCódigo: " + codigo +
                "\nNombre: " + nombre +
                "\nApellido: " + apellido +
                "\nEmail: " + email +
                "\nTeléfono: " + telefono;
    }

    // Métodos para comparación de objetos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && Objects.equals(codigo, cliente.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo);
    }
}