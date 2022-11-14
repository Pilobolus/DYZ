package hw01;

public class LightBulb {

	private String name;
	private int lightTime;
	
	public LightBulb() {
	}
	public LightBulb(String name, int lightTime) {
		this.name = name;
		this.lightTime = lightTime;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLightTime() {
		return lightTime;
	}
	public void setLightTime(int lightTime) {
		this.lightTime = lightTime;
	}
	
	
	@Override
	public String toString() {
		return "LightBulb [name=" + name + ", lightTime=" + lightTime + "]";
	}
	
}
