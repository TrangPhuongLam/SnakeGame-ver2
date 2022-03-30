package volumeState;

import interfaceSnakeGame.VolumeState;
import panel.PanelNavigationGameFrame;

public class OnVolume implements VolumeState{
	private static OnVolume instance = new OnVolume();
	
	private OnVolume() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean doAction(PanelNavigationGameFrame panelNavigationGameFrame) {
		// TODO Auto-generated method stub
		panelNavigationGameFrame.setVolumeState(this);
		return true;
	}

	public static OnVolume getInstance() {
		return instance;
	}
	
	

}
