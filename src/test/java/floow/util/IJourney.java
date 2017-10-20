package floow.util;

import org.openqa.selenium.By;

import floow.constants.CDetailedJourney;
import floow.constants.CHomeTab;
import floow.constants.CJourneyTab;
import floow.constants.CMapView;
import floow.constants.CModifyJourney;
import floow.constants.CModifyJourneyAlert;



public interface IJourney {
	By journeyTabBtn = By.id(CHomeTab.journeyTab);
	By rowElement=By.className(CJourneyTab.rowClass);
	By modifyJourneyBtn=By.id(CDetailedJourney.modifyBtn);
	By showMapBtn=By.id(CDetailedJourney.mapBtn);
	By boat=By.id(CModifyJourney.boatBtn);
	By bus=By.id(CModifyJourney.busBtn);
	By bike=By.id(CModifyJourney.bikeBtn);
	By passenger=By.id(CModifyJourney.passengerBtn);
	By walking=By.id(CModifyJourney.walkingBtn);
	By train=By.id(CModifyJourney.trainBtn);
	By plane=By.id(CModifyJourney.planeBtn);
	By car=By.id(CModifyJourney.carBtn);
	By alertOK=By.id(CModifyJourneyAlert.okBtn);
	By save=By.id(CModifyJourney.saveBtn);
	By satelliteView=By.id(CMapView.satelliteBtn);
	
	public boolean modifyJourney(int journeyNumber);
	public boolean changeMapView(int journeyNumber);
}
