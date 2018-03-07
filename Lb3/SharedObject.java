
public class SharedObject {
	private Double globalMin;
	private Double globalMax;
	
	public SharedObject(Double globalMin,Double globalMax) {
		this.globalMin=globalMin;
		this.globalMax=globalMax;
	}

	public Double getGlobalMin() {
		return globalMin;
	}

	public void setGlobalMin(Double globalMin) {
		this.globalMin = globalMin;
	}

	public Double getGlobalMax() {
		return globalMax;
	}

	public void setGlobalMax(Double globalMax) {
		this.globalMax = globalMax;
	}
	
}
