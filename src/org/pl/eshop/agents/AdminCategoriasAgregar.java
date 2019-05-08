package org.pl.eshop.agents;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import org.pl.eshop.dto.Categoria;
import org.pl.eshop.dto.CategoriaDAO;
import org.pl.eshop.dto.CategoriaDAOMySQL;

public class AdminCategoriasAgregar extends CyclicBehaviour {

    String result;
    CategoriaDAO cdao = new CategoriaDAOMySQL();

    @Override
    public void action() {
        ACLMessage msg = getAgent().receive();
        if (msg != null) {
            System.out.println("Iniciando proceso para adicionar una categoria.");
            result = msg.getContent();
            String[] datos = result.split(",");
            Categoria c = new Categoria();
            c.setNombre(datos[0]);
            c.setDescripcion(datos[1]);
            try {
                cdao.agregar(c);
            } catch (Exception e) {
                System.out.println("Hubo un error al acceder a la base de datos.");
            }
        } else {
            block();
        }
    }
}
