(defrule Estado-Inicial
  =>
  (printout t "La cirugia puede comenzar" crlf)
  (assert (paciente quirofano) (enfermera quirofano) (anestesiologo quirofano)(cirujano quirofano) (cirujano2 quirofano))
)

(defrule comienzo-cirugia
  (paciente quirofano) (cirujano2 quirofano)
  =>
  (assert (cirujano quirofano))
  (printout t "Cirujano en jefe puede comenzar la intervencion" crlf)
)


(defrule confirmar-anestesia
  (cirujano2 quirofano) (cirujano quirofano)
  =>
  	(assert (anestesiologo quirofano))S
   
  (printout t "Favor de confirmar anestesia" crlf)
)


(defrule paciente-cedado
  (cirujano quirofano) (anestesiologo quirofano)
  =>
  	(assert (anestesiologo confirma))
   
  (printout t "El paciente esta sedado" crlf)
)


(defrule inicia-intervencion
  (anestesiologo confirma) (cirujano quirofano)
  =>
  	(assert (cirujano2 inicia))
   
  (printout t "Puede comenzar cirugia" crlf)
)


(defrule solicita-instrumentos
  (cirujano2 inicia) (enfermera quirofano)
  =>
  	(assert (enfermera instrumenta))
   
  (printout t "Favor de administrar instrumentos para cirugia" crlf)
)


(defrule enfermera-instrumenta
  (enfermera instrumenta) (cirujano2 quirofano)
  =>
  	(assert (enfermera provee-instrumentos))
   
  (printout t "Instrumentando cirugia" crlf)
)


(defrule cirujano2-opera
  (enfermera provee-instrumentos) (cirujano2 quirofano)
  =>
  	(assert (cirujano2 opera-paciente))
   
  (printout t "Se procede con cirugia" crlf)
)


(defrule cirujano2-termina
  (cirujano2 opera-paciente) (cirujano quirofano)
  =>
  	(assert (cirujano2 termina))
   
  (printout t "Cirujano en jefe la cirugia ha concluido" crlf)
)


(defrule cirugia-concluye
  (cirujano2 termina) (enfermera quirofano)
  =>
  	(assert (enfermera manda-recuperacion))
   
  (printout t "El paciente este llevado a recuperacion" crlf)
)
