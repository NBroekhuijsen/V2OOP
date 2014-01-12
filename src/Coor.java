
public class Coor {

	
	private char x;
	private int y;
	
	/**
	 * Method Coor
	 * Constructor
	 * @param xin
	 * @param yin
	 */
	public Coor(char xin, int yin)
	{
		x = xin;
		y = yin;
		
	}

	/**
	 * method getX
	 * Getter for char x
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * method setX
	 * Setter for char x
	 * @param x
	 */
	public void setX(char x) {
		this.x = x;
	}
	
	/**method getY
	 * Getter for int y
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * method setY
	 * Setter for int y
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Coor [x=" + x + ", y=" + y + "]";
	}
	
	
	
	
	
}
