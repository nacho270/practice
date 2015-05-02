package otros2.amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    static class Path {
        String start_;
        String end_;
        String name_;
        int distance_;

        public String getStart() { return start_; }
        public String getEnd() { return end_; }
        public String getName() { return name_; }
        public int getDistance() { return distance_; }

        public Path(String name, String start, String end, int distance) {
            start_ = start;
            end_ = end;
            name_ = name;
            distance_ = distance;
        }
    }

    static class Route {
        int distance_;
        List<Path> paths_;

        public int getDistance() { return distance_; }
        public List<Path> getPaths() { return paths_; }

        public Route(int distance, List<Path> paths) {
            distance_ = distance;
            paths_ = paths;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        List<Path> paths = new ArrayList<Path>();

        while ((s = in.readLine()) != null && s.length() != 0) {
            if (s.startsWith("#")) {
                continue;
            }
            String[] parts = s.split(",");            
            paths.add(new Path(parts[0], parts[1], parts[2], Integer.parseInt(parts[3])));
        }

        List<Route> routes = generateRoutes(paths);

        for (Route r : routes) {
            StringBuilder sb = new StringBuilder();
            sb.append(r.getDistance());
            sb.append(" - ");
            for (Path p : r.getPaths()) {
                sb.append(p.getName());
                sb.append(' ');
            }

            System.out.println(sb.toString());
        }
    }

    public static List<Route> generateRoutes(List<Path> paths) {
    	List<Route> routes = new ArrayList<Route>();
    	Map<String, List<String>> mapPaths = new HashMap<String, List<String>>();
    	for(Path p : paths){
			if(mapPaths.get(p.getStart())==null){
    			mapPaths.put(p.getStart(),new ArrayList<String>());
    		}
			mapPaths.get(p.getStart()).add(p.getEnd());
    	}
    	
//    	for(String s : mapPaths.keySet()){
//    		
//    	}
    	
    	Collections.sort(routes, new Comparator<Route>() {
			@Override
			public int compare(Route o1, Route o2) {
				int comp = new Integer(o1.getDistance()).compareTo(new Integer(02));
				return comp!=0?comp:o1.getPaths().get(0).getName().compareTo(o2.getPaths().get(0).getName());
			}
		});
    	return routes;
    }
}