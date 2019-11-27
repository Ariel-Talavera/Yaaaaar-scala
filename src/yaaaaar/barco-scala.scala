package yaaaaar

import yaaaaar._

class Barco {

	var mision : Mision = _
	var capacidad : Int = _
	var tripulantes : List[Pirata] = List()
	
	def sosSaqueablePor(unPirata : Pirata) : Boolean = unPirata.pasadoDeGrog()

	def esVulnerableA(otroBarco : Barco) : Boolean = 
		this.cantidadTripulantes() <= otroBarco.cantidadTripulantes() / 2
	
	def cantidadTripulantes() : Int = tripulantes.size

	def puedeUnirse(unPirata : Pirata) : Boolean = this.hayLugar() && mision.esUtil(unPirata)
	
	def hayLugar() : Boolean = this.cantidadTripulantes() < capacidad
	
	def agregar(unTripulante : Pirata) : Unit = {
		if (this.puedeUnirse(unTripulante)) {
			tripulantes :+ unTripulante
		}
	}
	
	def esTemible() : Boolean = {
		mision.esRealizablePor(this)
	}
	
	def cambiarMision(unaMision : Mision) : Unit = {
		tripulantes = tripulantes.filter(!unaMision.esUtil(_))
		mision = unaMision
	}
	
	def anclarEn(unaCiudad : CiudadCostera) : Unit = {
		this.todosTomanGrog()
		this.perderMasEbrioEn(unaCiudad)
	}
	
	def todosTomanGrog() : Unit = tripulantes.foreach(_.tomarGrog())
		
	def todosPasadosDeGrog() : Boolean = tripulantes.forall(_.pasadoDeGrog())
	
	def pirataMasEbrio() : Pirata = {
	  tripulantes.filter(_.nivelEbriedad == tripulantes.map(_.nivelEbriedad).max).head
	}
	
	def perderMasEbrioEn(unaCiudad : CiudadCostera) : Unit = {
		tripulantes.filter(_ != this.pirataMasEbrio())
		unaCiudad.sumarHabitante()
	}
	
	def tieneSuficienteTripulacion() : Boolean = this.cantidadTripulantes() >= capacidad * 0.9
	
	def tiene(unItem : String) : Boolean = tripulantes.exists(_.tiene(unItem))
	
	def cantidadTripulantesPasadosDeGrog() : Int = {
	  this.tripulantesPasadosDeGrog().size
	}
	
	def cantidadItemsDistintosEntreTripulantesPasadosDeGrog() : Int = {
		this.tripulantesPasadosDeGrog().map(_.items).size
	}
	
	def tripulantesPasadosDeGrog() : List[Pirata] = return tripulantes.filter(_.pasadoDeGrog())

	def tripulantePasadoDeGrogConMasMonedas() : Pirata = {
	   this.tripulantesPasadosDeGrog().filter(_.cantidadMonedas == tripulantes.map(_.cantidadMonedas).max).head
	}

	def tripulanteMasInvitador() : Pirata = {
	  tripulantes.filter(cantidadInvitadosPor(_) == tripulantes.map(this.cantidadInvitadosPor(_)).max).head
	}
	
	def cantidadInvitadosPor(unTripulante : Pirata) : Int = {
	  tripulantes.filter(_.fuisteInvitadoPor(unTripulante)).size
	}
}