package Config;

public class FrameConfig  extends SwingConfig {
	private String closeOperation;
	private boolean resizable;

	public FrameConfig(String name){
		super(name);
		initialize();
	}
	protected void initialize() {
		super.initialize();
		closeOperation = properties.getProperty("CloseOperation");
		resizable = properties.readBoolean("Resizable");
	}
	public boolean isResizable() {
		return resizable;
	}

	public int getCloseOperation() {
		if(closeOperation==null) {
			return 3;
		}
		return Integer.parseInt(closeOperation);
	}


	@Override
	protected void setProperties() {
		this.properties = ConfigLoader.getInstance().getFrameProperties(name);
	}
}
