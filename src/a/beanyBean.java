package a;

import java.util.ArrayList;
import java.util.List;

public class beanyBean {
	
	private List<String> bearResult;
	private List<String> ikeaResult;
	private List<String> mastersResult;
	private String search;
      
    public void setMastersResult(ArrayList<String> mastersResult) {  
        this.mastersResult = mastersResult;  
    }
    public List<String> getMastersResult() {  
        return mastersResult;
    }
    public void setBearResult(ArrayList<String> bearResult) {  
        this.bearResult = bearResult;  
    }
    public List<String> getBearResult() {  
        return bearResult;
    }
    public void setIkeaResult(ArrayList<String> ikeaResult) {  
        this.ikeaResult = ikeaResult;  
    }
    public List<String> getIkeaResult() {  
        return ikeaResult;
    }
    public String getSearch(){
    	return search;
    }
    public void setSearch(String search){
    	this.search = search;
    }
    
}  