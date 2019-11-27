package yaaaaar

import yaaaaar._

class Pirata {
	
	var items : List[String] = List()
	var invitante : Pirata = _
	var nivelEbriedad : Int = _
	var cantidadMonedas : Int = 0
	
	def tiene(unItem : String) : Boolean = return items.contains(unItem)

	def cantidadItems() : Int = items.size

	def pasadoDeGrog() : Boolean = nivelEbriedad >= 90

	def tomarGrog() : Unit = {
		nivelEbriedad += 5
		gastarMoneda()
	}
	
	def gastarMoneda(): Unit = {
		validarGastarMonedas()
		cantidadMonedas = cantidadMonedas - 1
	}
	
	def validarGastarMonedas(): Unit = {
		if (cantidadMonedas == 0) {
		  //Excepción
		}
	}
	
	def podesSaquear(unaVictima : CiudadCostera) : Boolean = unaVictima.sosSaqueablePor(this)
	
	def cantidadInvitadosPara(unBarco : Barco) : Int = unBarco.cantidadInvitadosPor(this)
	
	def fuisteInvitadoPor(unTripulante : Pirata) : Boolean = invitante.equals(unTripulante)
}

class PirataEspiaDeLaCorona extends Pirata {
	override def pasadoDeGrog() : Boolean = false

	override def podesSaquear(unaVictima : CiudadCostera) : Boolean = super.podesSaquear(unaVictima)  && this.tiene("permiso de la corona")
}

// class TripulanteException extends Exception {}