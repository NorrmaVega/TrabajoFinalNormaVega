package Agentes;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.*;



public class CirujanoJefe extends Agent {

	ACLMessage mensajeanestesiologo;
	ACLMessage respuestaAnestesiologo;
	
	ACLMessage mensajeCirujanoaCirujano2;
	ACLMessage respuestaCirujano2;
	
	ACLMessage mensajeEnfermeraRecuperacion;
	ACLMessage respuestaEnfermeraRecu;
	
	public void setup(){
		
		ACLMessage mensajeRecibido = this.blockingReceive();
		ACLMessage respuesta1;
		
		//ACLMessage mensajeanestesiologo;
		//ACLMessage respuestaAnestesiologo;

		
		if(mensajeRecibido != null){
			System.out.println("El mensaje Enviado por Cirujano2 es: " + mensajeRecibido.getContent());
			respuesta1 = mensajeRecibido.createReply();
			respuesta1.setContent( "Enterado");
			System.out.println("El mensaje enviado por Cirujano Jefe");
			this.send(respuesta1);
		}else{
			System.out.println("Cirujano Jefe no recibio respuesta");
		}
		
		//Mensaje para Anestesiologo
		
		
		mensajeanestesiologo = new ACLMessage(ACLMessage.INFORM);
		mensajeanestesiologo.addReceiver( new AID("Anestesiologo",AID.ISLOCALNAME));
		mensajeanestesiologo.setContent("Favor de revisar Anestesia");
		 this.send(mensajeanestesiologo);
		 System.out.println("Se envia solicitud a Anestesiologo");
		 respuestaAnestesiologo=this.blockingReceive();
		 if(respuestaAnestesiologo!=null)
		 {
			 System.out.println("Mensaje recibido de Anestesiologo: " + respuestaAnestesiologo.getContent());
		 }
		 
		 //Mensaje Cirujano 2 de inicio de cirugia
			
		 mensajeCirujanoaCirujano2 = new ACLMessage(ACLMessage.INFORM);
		 mensajeCirujanoaCirujano2.addReceiver( new AID("Cirujano2",AID.ISLOCALNAME));
		 mensajeCirujanoaCirujano2.setContent("Iniciar Cirugia");
			 this.send(mensajeCirujanoaCirujano2);
			 System.out.println("Se envia solicitud a Cirujano 2");
			 respuestaCirujano2=this.blockingReceive();
			 if(respuestaCirujano2 != null)
			 {
				 System.out.println("Mensaje recibido de Cirujano 2: " + respuestaCirujano2.getContent());
			 }
			 
		 //Respuesta de finalizacion de cirugia
			 
				ACLMessage mensajeNvoCirujano2 = this.blockingReceive();
				ACLMessage respuestaNuevaACirujano2;	
			 
			 if(mensajeNvoCirujano2 != null){
					System.out.println("El mensaje Enviado por Cirujano2 es: " + mensajeNvoCirujano2.getContent());
					respuestaNuevaACirujano2 = mensajeNvoCirujano2.createReply();
					respuestaNuevaACirujano2.setContent( "Enterado procedemos a llevar al paciente a recuperacion");
					System.out.println("El mensaje enviado por Cirujano Jefe ");
					this.send(respuestaNuevaACirujano2);
				}else{
					System.out.println("Cirujano Jefe no recibio respuesta");
				}
			 
			 
			 //Mensaje a enfermera para pasar paciente a recuperacion
			 mensajeEnfermeraRecuperacion = new ACLMessage(ACLMessage.INFORM);
			 mensajeEnfermeraRecuperacion.addReceiver( new AID("Enfermera",AID.ISLOCALNAME));
			 mensajeEnfermeraRecuperacion.setContent("Enfermera llevar al paciente a recuperacion");
				 this.send(mensajeEnfermeraRecuperacion);
				 System.out.println("Se envia solicitud a Enfermera");
				 respuestaEnfermeraRecu=this.blockingReceive();
				 if(respuestaEnfermeraRecu != null)
				 {
					 System.out.println("Mensaje recibido de Enfermera: " + respuestaEnfermeraRecu.getContent());
				 }

	}
}
