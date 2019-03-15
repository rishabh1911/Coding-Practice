package nut.and.bolt.problem;

public class NutBoltPair {
	
	private Nut nut;
	
	private Bolt bolt;

	public NutBoltPair(Nut nut, Bolt bolt) {
		super();
		this.nut = nut;
		this.bolt = bolt;
	}

	public Nut getNut() {
		return nut;
	}

	public void setNut(Nut nut) {
		this.nut = nut;
	}

	public Bolt getBolt() {
		return bolt;
	}

	public void setBolt(Bolt bolt) {
		this.bolt = bolt;
	}

}
