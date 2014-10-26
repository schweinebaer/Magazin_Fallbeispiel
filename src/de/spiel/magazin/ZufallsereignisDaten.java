package de.spiel.magazin;

public class ZufallsereignisDaten {
	private String ausgabeText;
	private String befehl;
	private double wert1;
	private double wert2;
	
	public ZufallsereignisDaten(String ausgabeText, String befehl, double wert1, double wert2){
		this.ausgabeText = ausgabeText;
		this.befehl = befehl;
		this.wert1 = wert1;
		this.wert2 = wert2;
	}
	
	public Object[] getEreignis(){
		Object[] ereignis = new Object[4];
		
		ereignis[0] = ausgabeText;
		ereignis[1] = befehl;
		ereignis[2] = wert1;
		
		if(wert2 != 0.0){
			ereignis[3] = wert2;
		}
		
		return ereignis;
	}
}