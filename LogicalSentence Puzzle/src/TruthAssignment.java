
public class TruthAssignment {
	
	private boolean truthVal;
	
	private PropositionConstant[] pc;
	private boolean[] tv;
	
	private int i = 0;

	public TruthAssignment() {
		
	}
	
	public void put(PropositionConstant propC, boolean truthVal) {
		this.truthVal = truthVal;
		
		i++;
		
		PropositionConstant[] pc = new PropositionConstant[i];
		boolean[] tv = new boolean[i];
		
		for (int j = 0; j < this.pc.length; j++) {
			pc[j] = this.pc[j];
			tv[j] = this.tv[j];
		}
		
		pc[i] = propC;
		tv[i] = truthVal;
		
		this.pc = pc;
		this.tv = tv;
	}
	
	public boolean get() {
		return truthVal;
	}
	
}
