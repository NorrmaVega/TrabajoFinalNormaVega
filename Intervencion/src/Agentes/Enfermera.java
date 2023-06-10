package Agentes;

import jade.lang.acl.ACLMessage;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.*;


public class Enfermera extends Agent {

	public void setup(){
		ACLMessage mensajecirujano2Enfe = this.blockingReceive();
		ACLMessage respuestaACirujano2Enfe;	
	 
	 if(mensajecirujano2Enfe != null){
			System.out.println("El mensaje Enviado por Cirujano2 es: " + mensajecirujano2Enfe.getContent());
			respuestaACirujano2Enfe = mensajecirujano2Enfe.createReply();
			respuestaACirujano2Enfe.setContent( "Se proporciona Instrumental");
			System.out.println("El mensaje enviado por Enfermera ");
			this.send(respuestaACirujano2Enfe);
		}else{
			System.out.println("Enfermera no recibio respuesta");
		}
	 
	 //Respuesta de Enfermera a cirujano Jefe
	 
		ACLMessage mensajeACirujanoJefe = this.blockingReceive();
		ACLMessage respuestanvaACirujanoJefe;	
	 
	 if(mensajeACirujanoJefe != null){
			System.out.println("El mensaje Enviado por Cirujano Jefe es: " + mensajeACirujanoJefe.getContent());
			respuestanvaACirujanoJefe = mensajeACirujanoJefe.createReply();
			respuestanvaACirujanoJefe.setContent( "Se traslada paciente a recuperacion");
			System.out.println("El mensaje enviado por Enfermera ");
			this.send(respuestanvaACirujanoJefe);
		}else{
			System.out.println("Enfermera Jefe no recibio respuesta");
		}
	 
	}
	
}
