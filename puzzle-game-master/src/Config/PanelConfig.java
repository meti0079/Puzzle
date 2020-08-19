package Config;

public class PanelConfig extends SwingConfig{

	public PanelConfig(String name){
		super(name);
		initialize();
	}

	protected void initialize() {
		super.initialize();
	}

	@Override
	protected void setProperties() {
		this.properties = ConfigLoader.getInstance("default").getPanelProperties(name);
	}

}

