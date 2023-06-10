package Agentes;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.*;

public class Cirujano2 extends Agent {

	ACLMessage mensaje;
	ACLMessage respuesta;
	
	ACLMessage mensajeaEnfermera;
	ACLMessage respuestaDeEnfermera;

	
	ACLMessage mensajenvoJefe;
	ACLMessage respuestaNvoJefe;

	public void setup(){
	

		
		 mensaje = new ACLMessage(ACLMessage.INFORM);
		 mensaje.addReceiver( new AID("CirujanoJefe",AID.ISLOCALNAME));
		 mensaje.setContent("Cirujano en jefe la cirugia puede comenzar");
		 this.send(mensaje);
		 System.out.println("Se envia solicitud a Cirujano Jefe");
		 respuesta=this.blockingReceive();
		 if(respuesta != null)
		 {
			 System.out.println("Mensaje recibido de Cirujano Jefe: " + respuesta.getContent());
		 }
		 
		//Mensaje para Cirujano en Jefe 2
			ACLMessage mensajeRecibidoCirujanoJefe = this.blockingReceive();
			ACLMessage respuestaACirujanoJefe;	
		 
		 if(mensajeRecibidoCirujanoJefe != null){
				System.out.println("El mensaje Enviado por Cirujano Jefe es: " + mensajeRecibidoCirujanoJefe.getContent());
				respuestaACirujanoJefe = mensajeRecibidoCirujanoJefe.createReply();
				respuestaACirujanoJefe.setContent( "De acuerdo se Inicia Cirugia");
				System.out.println("El mensaje enviado por Cirujano2 ");
				this.send(respuestaACirujanoJefe);
			}else{
				System.out.println("Cirujano2 no recibio respuesta");
			}
		 
		 
		 //Mensaje para Enfermera
		 
		 mensajeaEnfermera = new ACLMessage(ACLMessage.INFORM);
		 mensajeaEnfermera.addReceiver( new AID("Enfermera",AID.ISLOCALNAME));
		 mensajeaEnfermera.setContent("Favor se Proveer de instrumental");
		 this.send(mensajeaEnfermera);
		 System.out.println("Se envia solicitud a Enfermera");
		 respuestaDeEnfermera=this.blockingReceive();
		 if(respuestaDeEnfermera != null)
		 {
			 System.out.println("Mensaje recibido de Enfermera: " + respuestaDeEnfermera.getContent());
		 }
		 
		 //Mesaje Nuevo para cirujano jefe
		 
		 
		 mensajenvoJefe = new ACLMessage(ACLMessage.INFORM);
		 mensajenvoJefe.addReceiver( new AID("CirujanoJefe",AID.ISLOCALNAME));
		 mensajenvoJefe.setContent("La cirugia a concluido");
		 this.send(mensajenvoJefe);
		 System.out.println("Se envia solicitud a Cirujano Jefe");
		 respuestaNvoJefe=this.blockingReceive();
		 if(respuestaNvoJefe != null)
		 {
			 System.out.println("Mensaje recibido de Cirujano Jefe: " + respuestaNvoJefe.getContent());
		 }
	 }
	
}
