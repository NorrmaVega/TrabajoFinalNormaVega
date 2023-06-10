package Agentes;

import jade.lang.acl.ACLMessage;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.*;

public class Anestesiologo extends Agent {

	

	 public void setup(){
		 
		 
		 ACLMessage mensajeRecidoAnestesiologo = this.blockingReceive();
			ACLMessage respuestaAnestesia;
	
			if(mensajeRecidoAnestesiologo !=null){
				System.out.println("El mensaje Enviado por Cirujano en Jefe es: " + mensajeRecidoAnestesiologo.getContent());
				respuestaAnestesia = mensajeRecidoAnestesiologo.createReply();
				respuestaAnestesia.setContent( "Paciente Sedado");
				System.out.println("El mensaje enviado por el Anestesiologo es: ");
				this.send(respuestaAnestesia);
			}else{
				System.out.println("Anestesiologo  no recibio respuesta");
			}
			
		 
	 }
}
