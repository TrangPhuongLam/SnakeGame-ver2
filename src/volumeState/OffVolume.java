package volumeState;

import interfaceSnakeGame.VolumeState;
import panel.PanelNavigationGameFrame;

public class OffVolume implements VolumeState{
	private static OffVolume instance = new OffVolume();
	
	private OffVolume() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean doAction(PanelNavigationGameFrame panelNavigationGameFrame) {
		// TODO Auto-generated method stub
		panelNavigationGameFrame.setVolumeState(this);
		return false;
	}

	public static OffVolume getInstance() {
		return instance;
	}
	
	

}
