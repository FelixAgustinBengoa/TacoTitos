package Controlador;

import Modelo.Salsa;
import Modelo.SalsaDAO;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorSalsa {

    //instancias
    SalsaDAO salsadao;

    /**
     * Constructor de la controladora Tortilla
     */
    public ControladorSalsa() {
        salsadao = new SalsaDAO();

    }

    /**
    * Valida que los campos `nombre` y `precio` no estén vacíos. Si alguno de los campos
    * está vacío, muestra un mensaje de error y retorna `false`. Si ambos campos tienen valor,
    * retorna `true`.
    *
    * @param nombre El nombre de la salsa a validar.
    * @param precio El precio de la salsa a validar.
    * @return `true` si los campos no están vacíos, de lo contrario `false`.
    */
    private boolean validarDatos(String nombre, String precio) {
        if ("".equals(nombre) || "".equals(precio)) { //valor del campo nombre o precio esta vacio?
            //System.out.println("comparando nombre y precio vacios");
            JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    /**
    * Agrega una nueva salsa a la base de datos. Valida que los campos no estén vacíos y
    * que el precio sea numérico antes de intentar agregar la salsa. Si la salsa ya existe,
    * muestra un mensaje de error. Si la operación es exitosa, muestra un mensaje de éxito.
    *
    * @param nombre El nombre de la salsa a agregar.
    * @param precio El precio de la salsa a agregar.
    * @return `true` si la salsa se agrega correctamente, `false` en caso de error.
    */
    public boolean agregarSalsa(String nombre, String precio) {
        Double precioss;
        try {
            if (validarDatos(nombre, precio) == true) {
                precioss = Double.parseDouble(precio);
                Salsa salsa = new Salsa(nombre, precioss);
                //System.out.println(salsa);
                if (salsadao.agregar(salsa) == true) {
                    //System.out.println(salsa);
                    JOptionPane.showMessageDialog(null, "Salsa agregada exitosamente");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Esa salsa ya esta agregada", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }

            return false;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El campo precio debe ser numérico", "Error", JOptionPane.ERROR_MESSAGE);
            //System.out.println("Error al agregar la salsa: " + e);
            return false;
        }

    }

    /**
    * Llena una tabla con la lista de salsas. Los datos de cada salsa (ID, nombre, precio) 
    * se agregan como filas en el modelo de la tabla.
    *
    * @param dtm El modelo de la tabla que se actualizará con los datos.
    * @param tblTabla La tabla donde se mostrarán los datos.
    */
    public void llenarTablaConListaSalsas(DefaultTableModel dtm, JTable tblTabla) {
        String[] titulos = new String[]{"Código", "Nombre - Salsa", "Precio $$$"}; //titulos de la tabla
        dtm.setColumnIdentifiers(titulos);
        tblTabla.setModel(dtm);
        List<Salsa> listaSalsas = listarSalsas();
        for (Salsa salsa : listaSalsas) {
            dtm.addRow(new Object[]{salsa.getId(), salsa.getNombre(), salsa.getPrecio()});
        }

        tblTabla.setModel(dtm);
        tblTabla.setPreferredSize(new Dimension(350, dtm.getRowCount() * 16));
    }

    /**
    * Obtiene la lista de todas las salsas almacenadas en la base de datos.
    *
    * @return Una lista de objetos `Salsa` que representa todas las salsas disponibles.
    */
    public List listarSalsas() {
        List<Salsa> salsas = salsadao.listar();
        return salsas;
    }

    /**
    * Actualiza los datos de una salsa existente en la base de datos. Solicita una confirmación
    * antes de guardar los cambios y valida que los campos no estén vacíos y que el precio sea numérico.
    * Si la operación es exitosa, muestra un mensaje de éxito.
    *
    * @param id El identificador de la salsa a actualizar.
    * @param nombre El nuevo nombre de la salsa.
    * @param precio El nuevo precio de la salsa.
    * @return `true` si la salsa se actualiza correctamente, `false` si ocurre un error o si la acción no se confirma.
    */
    public boolean actualizarSalsa(int id, String nombre, String precio) {
        double precioss;
        try {
            if (validarDatos(nombre, precio) == true) {
                int salida = JOptionPane.showConfirmDialog(null, "Esta seguro de guardar los cambios??", "Esta acción no se puede revertir..", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                if (salida == 0) {
                    precioss = Double.parseDouble(precio);
                    Salsa salsa = new Salsa(id, nombre, precioss); //uso el constructor actualizar que tiene como parametro el id
                    salsadao.actualizar(salsa);
                    JOptionPane.showMessageDialog(null, "Salsa actualizada");
                    return true;

                }
                return false;
            }
            return false;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El campo precio debe ser numérico", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
    * Borra una salsa de la base de datos después de solicitar una confirmación del usuario.
    * Si el usuario confirma la acción, la salsa se elimina y se muestra un mensaje de éxito.
    *
    * @param id El identificador de la salsa a borrar.
    * @return `true` si la salsa se borra correctamente, `false` en caso de error.
    */
    public boolean borrarSalsa(int id) {
        try {
            int salida = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea borrar esta salsa??", "Esta acción no se puede revertir..", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (salida == 0) {
                salsadao.borrar(id);
                JOptionPane.showMessageDialog(null, "Salsa borrada");

            }
            //System.out.println("estoy por ir al return true");
            return true;

        } catch (HeadlessException e) {
            System.out.println("Error al borrar Salsa en la controladora: " + e);

        }

        return false;
    }

    /**
    * Obtiene el identificador de la salsa más cara de la base de datos. Recorre la lista de salsas
    * y encuentra la que tiene el mayor precio, luego retorna su identificador.
    *
    * @return El identificador de la salsa más cara.
    */
    public int obtenerIdSalsaMasCara() {
        double comparador = 0;
        List<Salsa> listaSalsas = salsadao.listar();
        int idsalsa = 0;

        for (Salsa salsa : listaSalsas) {
            if (salsa.getPrecio() > comparador) {
                comparador = salsa.getPrecio();
                idsalsa = salsa.getId();

                //System.out.println("id tortilla mas barata: " + idsalsa);
            }

        }

        return idsalsa;

    }

    /**
    * Obtiene la lista de las salsas más caras de la base de datos. Basándose en el identificador
    * de la salsa más cara, retorna una lista con dicha salsa.
    *
    * @return Una lista de objetos `Salsa` que contiene la salsa más cara.
    */
    public List listarSalsasCaras() {
        int idsalsa = obtenerIdSalsaMasCara();
        List<Salsa> salsas = salsadao.salsaCara(idsalsa);
        return salsas;
    }

    
    /**
    * Calcula el promedio de los precios de todas las salsas almacenadas en la base de datos.
    * Suma el precio de cada salsa y luego lo divide por la cantidad total de salsas en la base de datos.
    *
    * @return El promedio de los precios de las salsas.
    */
    public double obtenerPromedioSalsas() {
        List<Salsa> listaSalsas = salsadao.listar();
        double numeroSalsasCargadas = listaSalsas.size();
        double promedioSalsas = 0;
        for (Salsa salsa : listaSalsas) {
            promedioSalsas = promedioSalsas + salsa.getPrecio();

        }

        promedioSalsas = promedioSalsas / numeroSalsasCargadas;
        //System.out.println("promedio salsas: " + (promedioSalsas));

        return promedioSalsas;
    }
}
