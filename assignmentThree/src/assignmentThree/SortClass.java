package assignmentThree;

import java.util.ArrayList;

public abstract class SortClass {
	
	public ArrayList<ItemClass> bubbleSortByPriority(ArrayList<ItemClass>  itemList){

		int itemListLen = itemList.size();
 
	        for (int i = 0; i < itemListLen-1; i++)
	            for (int j = 0; j < itemListLen-i-1; j++)
	                
	                if(itemList.get(j).getPriority() < itemList.get(j+1).getPriority()) {
	                	 // swap temp and itemList[i]
	                	ArrayList<ItemClass> temp = new ArrayList<ItemClass>();
	                	temp.add(itemList.get(j));
	                    itemList.set(j, itemList.get(j+1));
	                    itemList.set(j+1, temp.get(0));
	                }
	        		/*if (itemList[j].getPriority() < itemList[j+1].getPriority()){
	                    // swap temp and itemList[i]
	                	ItemClass temp = itemList[j];
	                    itemList[j] = itemList[j+1];
	                    itemList[j+1] = temp;
	                }*/
		return itemList;
	}
	public void merge(ArrayList<ItemClass> itemList, int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        //Create temp arrays
        ArrayList<ItemClass> L = new ArrayList<ItemClass>();
        ArrayList<ItemClass> R = new ArrayList<ItemClass>();
       // ItemClass L[] = new ItemClass [n1]; 
       // ItemClass R[] = new ItemClass [n2]; 
  
        //Copy data to temp arrays
        for (int i=0; i<n1; ++i) {
            L.set(i, itemList.get(l+i));
        }
        
        for (int j=0; j<n2; ++j) {
        	R.set(j, itemList.get(m + 1+ j));
            //R[j] = itemList.get(m + 1+ j); 
        }
  
  
        //Merge the temp arrays
        
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            /*if (L[i].getPriority() <= R[j].getPriority()) 
            { 
                itemList[k] = L[i]; 
                i++; 
            } */
            if (L.get(i).getPriority() <= R.get(j).getPriority()) 
            { 
                itemList.set(i, L.get(i));
                i++; 
            } 
            else
            { 
                itemList.set(k, R.get(j));
                j++; 
            } 
            k++;
        } 
  
        //Copy remaining elements of L[] if any
        while (i < n1) 
        { 
        	itemList.set(k, L.get(i));
            i++; 
            k++; 
        } 
  
        //Copy remaining elements of R[] if any
        while (j < n2) 
        { 

            itemList.set(k, R.get(j));
            j++; 
            k++; 
        } 
    } 
	public ArrayList<ItemClass> mergeSortByPriority(ArrayList<ItemClass> itemList, int l, int r) 
	    { 
	        if (l < r) 
	        { 
	            // Find the middle point 
	            int m = (l+r)/2; 
	  
	            // Sort first and second halves 
	            mergeSortByPriority(itemList, l, m); 
	            mergeSortByPriority(itemList , m+1, r); 
	  
	            // Merge the sorted halves 
	            merge(itemList, l, m, r); 
	        }
			return itemList; 
	    } 
}
