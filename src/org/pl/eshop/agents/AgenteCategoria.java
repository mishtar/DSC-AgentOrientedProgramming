package org.pl.eshop.agents;

import jade.core.Agent;

public class AgenteCategoria extends Agent {

    @Override
    protected void setup() {
        System.out.println("Bienvenido, el agente categoria esta listo.");
        addBehaviour(new AdminCategoriasAgregar());
    }
}
