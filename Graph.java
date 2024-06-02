import java.util.ArrayList;
import java.util.HashMap;

class Graph{
    public class Vertex 
		{
			HashMap<String, Integer> nbrs = new HashMap<>();
		}

		static HashMap<String, Vertex> vtces;

		public Graph() 
		{
			vtces = new HashMap<>();
		}

		public int numVetex() 
		{
			return this.vtces.size();
		}

		public boolean containsVertex(String vname) 
		{
			return this.vtces.containsKey(vname);
		}

		public void addVertex(String vname) 
		{
			Vertex vtx = new Vertex();
			vtces.put(vname, vtx);
		}

		public void removeVertex(String vname) 
		{
			Vertex vtx = vtces.get(vname);
			ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

			for (String key : keys) 
			{
				Vertex nbrVtx = vtces.get(key);
				nbrVtx.nbrs.remove(vname);
			}

			vtces.remove(vname);
		}

		public int numEdges() 
		{
			ArrayList<String> keys = new ArrayList<>(vtces.keySet());
			int count = 0;

			for (String key : keys) 
			{
				Vertex vtx = vtces.get(key);
				count = count + vtx.nbrs.size();
			}

			return count / 2;
		}

		public boolean containsEdge(String vname1, String vname2) 
		{
			Vertex vtx1 = vtces.get(vname1);
			Vertex vtx2 = vtces.get(vname2);
			
			if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
				return false;
			}

			return true;
		}

		public void addEdge(String vname1, String vname2, int value) 
		{
			Vertex vtx1 = vtces.get(vname1); 
			Vertex vtx2 = vtces.get(vname2); 

			if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
				return;
			}

			vtx1.nbrs.put(vname2, value);
			vtx2.nbrs.put(vname1, value);
		}

		public void removeEdge(String vname1, String vname2) 
		{
			Vertex vtx1 = vtces.get(vname1);
			Vertex vtx2 = vtces.get(vname2);
			
			//check if the vertices given or the edge between these vertices exist or not
			if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
				return;
			}

			vtx1.nbrs.remove(vname2);
			vtx2.nbrs.remove(vname1);
		}
        public void display_Map() 
		{
			System.out.println("\t Bhubaneswar Map");
			System.out.println("\t------------------");
			System.out.println("----------------------------------------------------\n");
			ArrayList<String> keys = new ArrayList<>(vtces.keySet());

			for (String key : keys) 
			{
				String str = key + " =>\n";
				Vertex vtx = vtces.get(key);
				ArrayList<String> vtxnbrs = new ArrayList<>(vtx.nbrs.keySet());
				
				for (String nbr : vtxnbrs)
				{
					str = str + "\t" + nbr + "\t";
                    			if (nbr.length()<16)
                    			str = str + "\t";
                    			if (nbr.length()<8)
                    			str = str + "\t";
                    			str = str + vtx.nbrs.get(nbr) + "\n";
				}
				System.out.println(str);
			}
			System.out.println("\t------------------");
			System.out.println("---------------------------------------------------\n");

		}
}