package yaaaaar

import yaaaaar._

class Mision {
	def esRealizablePor(unBarco : Barco) : Boolean = unBarco.tieneSuficienteTripulacion()
	
	def esUtil(unPirata : Pirata) : Boolean
}

class BusquedaDelTesoro extends Mision {

	override def esUtil(unPirata : Pirata) : Boolean = this.tieneAlgunItemObligatorio(unPirata) && unPirata.cantidadMonedas <= 5

	def tieneAlgunItemObligatorio(unPirata : Pirata) : Boolean = {
	  unPirata.items.contains("brújula") || unPirata.items.contains("mapa") || unPirata.items.contains("grogXD") 
	}
	
	override def esRealizablePor(unBarco : Barco) : Boolean = 
		super.esRealizablePor(unBarco) && unBarco.tiene("llave de cofre")

}

class ConvertirseEnLeyenda extends Mision {

	var itemObligatorio : String = _

	override def esUtil(unPirata : Pirata) : Boolean = 
		unPirata.cantidadItems() >= 10 && unPirata.tiene(itemObligatorio)

}

class Saqueo extends Mision {

	var victima : CiudadCostera = _

	override def esUtil(unPirata : Pirata) : Boolean = 
	  unPirata.cantidadMonedas < monedasParaSaquear.limite && victima.sosSaqueablePor(unPirata)
	
	override def esRealizablePor(unBarco : Barco) : Boolean =
		 super.esRealizablePor(unBarco) && victima.esVulnerableA(unBarco)

}

object monedasParaSaquear {
	var limite : Int = 0
}