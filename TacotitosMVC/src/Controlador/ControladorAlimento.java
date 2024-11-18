package Controlador;

import Modelo.Alimento;
import Modelo.AlimentoDAO;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorAlimento {

    //instancias
    AlimentoDAO alimentodao;

    public ControladorAlimento() {
        alimentodao = new AlimentoDAO();

    }

    /**
    * Valida que los campos `nombre` y `precio` no estén vacíos. Si alguno de los campos
    * está vacío, muestra un mensaje de error y retorna `false`. Si ambos campos tienen valor,
    * retorna `true`.
    *
    * @param nombre El nombre del alimento a validar.
    * @param precio El precio del alimento a validar.
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
    * Intenta agregar un nuevo alimento a la base de datos. Valida que los campos no
    * estén vacíos, luego intenta convertir el precio a un valor numérico. Si el precio es válido
    * y el alimento no existe en la base de datos, lo agrega correctamente. Si hay algún error,
    * muestra el mensaje correspondiente.
    *
    * @param nombre El nombre del alimento a agregar.
    * @param precio El precio del alimento a agregar.
    * @return `true` si el alimento se agrega exitosamente, `false` si hubo un error o si el alimento ya existe.
    */
    public boolean agregarAlimento(String nombre, String precio) {
        Double precioss;
        try {
            if (validarDatos(nombre, precio) == true) {
                precioss = Double.parseDouble(precio);
                Alimento alimento = new Alimento(nombre, precioss);
                //System.out.println(alimento);
                if (alimentodao.agregar(alimento) == true) {
                    //System.out.println(alimento);
                    JOptionPane.showMessageDialog(null, "Alimento agregado exitosamente");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Ese alimento ya esta agregado", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }

            return false;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El campo precio debe ser numérico", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al agregar alimento: " + e);
            return false;
        }

    }

    /**
    * Llena una tabla (`JTable`) con la lista de alimentos obtenida de la base de datos.
    * Define las columnas de la tabla y agrega cada alimento en una nueva fila con los datos correspondientes.
    *
    * @param dtm El modelo de datos de la tabla (`DefaultTableModel`).
    * @param tblTabla La tabla (`JTable`) donde se mostrarán los alimentos.
    */
    public void llenarTablaConListaAlimentos(DefaultTableModel dtm, JTable tblTabla) {
        String[] titulos = new String[]{"Código", "Nombre - Alimento", "Precio $$$"}; //titulos de la tabla
        dtm.setColumnIdentifiers(titulos);
        tblTabla.setModel(dtm);
        List<Alimento> listaAlimentos = listarAlimentos();
        for (Alimento alimento : listaAlimentos) {
            dtm.addRow(new Object[]{alimento.getId(), alimento.getNombre(), alimento.getPrecio()});
        }

        tblTabla.setModel(dtm);
        tblTabla.setPreferredSize(new Dimension(350, dtm.getRowCount() * 16));
    }
    
    /**
    * Obtiene la lista de alimentos desde la base de datos utilizando el DAO correspondiente.
    *
    * @return Una lista de objetos `Alimento`.
    */
    public List listarAlimentos() {
        List<Alimento> alimentos = alimentodao.listar();
        return alimentos;
    }
    
    /**
    * Actualiza la información de un alimento en la base de datos. Valida que los campos
    * no estén vacíos y que el precio sea un valor numérico. Si el usuario confirma la acción,
    * realiza la actualización en la base de datos.
    *
    * @param id El identificador único del alimento a actualizar.
    * @param nombre El nuevo nombre del alimento.
    * @param precio El nuevo precio del alimento.
    * @return `true` si el alimento se actualiza correctamente, `false` si hay un error o si la actualización no se confirma.
    */
    public boolean actualizarAlimento(int id, String nombre, String precio) {
        double precioss;
        try {
            if (validarDatos(nombre, precio) == true) {
                int salida = JOptionPane.showConfirmDialog(null, "Esta seguro de guardar los cambios??", "Esta acción no se puede revertir..", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                if (salida == 0) {
                    precioss = Double.parseDouble(precio);
                    Alimento alimento = new Alimento(id, nombre, precioss); //uso el constructor actualizar que tiene como parametro el id
                    alimentodao.actualizar(alimento);
                    JOptionPane.showMessageDialog(null, "Alimento actualizado");
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
    * Borra un alimento de la base de datos. Pide una confirmación al usuario antes de proceder.
    * Si el usuario confirma, se elimina el alimento con el identificador dado. 
    * Si ocurre algún error durante el proceso, muestra un mensaje y retorna `false`.
    *
    * @param id El identificador único del alimento a borrar.
    * @return `true` si el alimento se borra correctamente, `false` si ocurre un error o no se confirma la acción.
    */
    public boolean borrarAlimento(int id) {
        try {
            int salida = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea borrar este alimento??", "Esta acción no se puede revertir..", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (salida == 0) {
                alimentodao.borrar(id);
                JOptionPane.showMessageDialog(null, "Alimento borrado");

            }
            //System.out.println("estoy por ir al return true");
            return true;

        } catch (HeadlessException e) {
            System.out.println("Error al borrar Alimento en la controladora: " + e);

        }

        return false;
    }

    /**
    * Obtiene el identificador del alimento más económico de la base de datos.
    * Recorre la lista de alimentos y encuentra el de menor precio, luego retorna su identificador.
    *
    * @return El identificador del alimento más barato.
    */
    public int obtenerIdAlimentoMasEconomico() {
        double comparadorAlimento = 1000000;
        int idalimento = 0;
        List<Alimento> listaAlimentos = alimentodao.listar();
        for (Alimento alimento : listaAlimentos) {
            if (alimento.getPrecio() < comparadorAlimento) {
                comparadorAlimento = alimento.getPrecio();
                idalimento = alimento.getId();
                //System.out.println("id alimento mas barato: " + idalimento);
            }
        }

        return idalimento;

    }

    /**
    * Obtiene la lista de alimentos con el precio más bajo, basándose en el identificador
    * del alimento más económico obtenido previamente.
    *
    * @return Una lista de objetos `Alimento` que contiene el alimento más económico.
    */
    public List listarAlimentoEconomico() {
        int idalimento = obtenerIdAlimentoMasEconomico();
        List<Alimento> alimentos = alimentodao.alimentoBarato(idalimento);
        return alimentos;
    }

    /**
    * Obtiene el identificador del alimento más caro de la base de datos.
    * Recorre la lista de alimentos y encuentra el de mayor precio, luego retorna su identificador.
    *
    * @return El identificador del alimento más caro.
    */
    public int obtenerIdAlimentoMasCaro() {
        double comparador = 0;
        List<Alimento> listaAlimentos = alimentodao.listar();
        int idalimento = 0;

        for (Alimento alimento : listaAlimentos) {
            if (alimento.getPrecio() > comparador) {
                comparador = alimento.getPrecio();
                idalimento = alimento.getId();

                //System.out.println("id tortilla mas caro: " + idalimento);
            }

        }

        return idalimento;

    }

    /**
    * Obtiene la lista de alimentos con el precio más alto, basándose en el identificador
    * del alimento más caro obtenido previamente.
    *
    * @return Una lista de objetos `Alimento` que contiene el alimento más caro.
    */
    public List listarAlimentosCaros() {
        int idalimento = obtenerIdAlimentoMasCaro();
        List<Alimento> alimentos = alimentodao.alimentoCaro(idalimento);
        return alimentos;
    }

    /**
    * Calcula el promedio de los precios de todos los alimentos en la base de datos.
    * Obtiene la lista de alimentos y calcula el promedio de sus precios.
    *
    * @return El promedio de los precios de los alimentos multiplicado por 5.
    */
    public double obtenerPromedioAlimentos() {
        List<Alimento> listaAlimentos = listarAlimentos();
        double numeroAlimentosCargados = listaAlimentos.size();
        double promedioAlimentos = 0;
        for (Alimento alimento : listaAlimentos) {
            promedioAlimentos = promedioAlimentos + alimento.getPrecio();

        }

        promedioAlimentos = promedioAlimentos / numeroAlimentosCargados;
        //System.out.println("promedio alimentos: " + (promedioAlimentos));

        return promedioAlimentos * 5;
    }

}
