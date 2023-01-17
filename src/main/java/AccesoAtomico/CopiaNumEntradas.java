package AccesoAtomico;

import java.util.Collection;

import javafx.collections.ObservableList;

public class CopiaNumEntradas {
	private static CopiaNumEntradas cpn;
	public float ne;

	private CopiaNumEntradas() {
	}

	
	public CopiaNumEntradas(float ne) {
		super();
		this.ne = ne;
		
	}


	public float getNe() {
		return ne;
	}

	public void setNe(float ne) {
		this.ne = ne;
	}
	

	public static CopiaNumEntradas getInstance() {
		if(cpn==null) {
			cpn= new CopiaNumEntradas();
		}
		return cpn;
	}

}
