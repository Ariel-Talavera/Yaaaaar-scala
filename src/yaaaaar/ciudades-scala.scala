package yaaaaar

import yaaaaar._

class CiudadCostera {

	var cantidadHabitantes : Int = 0

	def sosSaqueablePor(unPirata : Pirata) : Boolean = unPirata.nivelEbriedad >= 50
	
	def esVulnerableA(otroBarco : Barco) : Boolean = otroBarco.cantidadTripulantes() >= cantidadHabitantes * 0.4 || otroBarco.todosPasadosDeGrog()
	
	def sumarHabitante() : Unit = cantidadHabitantes = cantidadHabitantes + 1
	
}