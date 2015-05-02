package otros2.amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionOperation {
    static class Part {
        public String getName() { return "X"; }
    }

    static class Operation {
        private String name_;
        public Operation(final String name) { name_ = name; }
        public String getName() { return name_; }
        public void operate(Part p) {
            System.out.println("Operation " + name_ + " on part " + p.getName());
        }
        
        @Override
        public String toString() {
        	return name_;
        }
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name_ == null) ? 0 : name_.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Operation other = (Operation) obj;
			if (name_ == null) {
				if (other.name_ != null)
					return false;
			} else if (!name_.equals(other.name_))
				return false;
			return true;
		}
        
    }

    static class StepManager {
    	private Map<String, Operation> operationNameMap = new HashMap<String, Operation>();
    	private Map<Operation, Set<Operation>> operationMap = new HashMap<SolutionOperation.Operation, Set<Operation>>();
    	
        public void addOperation(final Operation operation, final String[] prerequisites) {
        	operationNameMap.put(operation.getName(), operation);
        	if(!operationMap.containsKey(operation)) operationMap.put(operation, new HashSet<Operation>());
        	List<Operation> dependencies = new ArrayList<Operation>();
        	for(String s:prerequisites){
        		Operation o = new Operation(s);
        		dependencies.add(o);
        	}
        	operationMap.get(operation).addAll(dependencies);
        	for(Operation op : dependencies){
        		operationNameMap.put(op.getName(),op);
        		if(!operationMap.containsKey(op)){
        			operationMap.put(op, new HashSet<Operation>());
        		}
        	}
        }
        public void performOperation(String operationName, Part p) {
        	Operation op = operationNameMap.get(operationName);
        	Set<Operation> dependencies = operationMap.get(op);
        	if(dependencies==null||dependencies.isEmpty()){
        		op.operate(p);
        	}else{
        		for(Operation oper : dependencies){
        			performOperation(oper.getName(), p);
        		}
        		op.operate(p);
        	}
        }
    }

    public static void main(String[] args) throws Exception {
        StepManager manager = new StepManager();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        /*Sample input:
         	1,2,3,4
         	2,5,6
         	final,1
         
			Result:
			Operation 6 on part X
			Operation 5 on part X
			Operation 2 on part X
			Operation 4 on part X
			Operation 3 on part X
			Operation 1 on part X
			Operation final on part X
         */
        String s;
        while ((s = in.readLine()) != null && s.length() != 0) {
            if (s.startsWith("#")) {
                continue;
            }
            String[] parts = s.split(",");
            manager.addOperation(new Operation(parts[0]),  Arrays.copyOfRange(parts, 1, parts.length));
        }

        manager.performOperation("final", new Part());
    }
}