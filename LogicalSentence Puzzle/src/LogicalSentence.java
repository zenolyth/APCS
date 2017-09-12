
public class LogicalSentence {
	
	private PropositionConstant propC;
	
	public static void main(String[] args) {
		
		PropositionConstant a = new PropositionConstant("a");
		PropositionConstant b = new PropositionConstant("b");
		LogicalSentence l1 = new LogicalSentence(a);
		LogicalSentence l2 = new LogicalSentence(b);
		LogicalSentence l3 = new Negation(l1);
		LogicalSentence l4 = new Negation(l3);
		LogicalSentence l5 = new Conjunction(l3, new Negation(l4));

		TruthAssignment ta1 = new TruthAssignment();
		ta1.put(b, true);
		ta1.put(a, false); 
		System.out.println(l5.evaluate(ta1));
		System.out.println(legal("a&"));
		System.out.println(findMatch("a(b)", 0));

		String[] pc = {"p"};
		truthTable(pc);
	}
	
	public boolean evaluate(TruthAssignment truthVal) {
		boolean retVal = truthVal.get();
		
		return retVal;
	}
	
	public LogicalSentence(PropositionConstant a) {
		propC = a;
	}
	
}
