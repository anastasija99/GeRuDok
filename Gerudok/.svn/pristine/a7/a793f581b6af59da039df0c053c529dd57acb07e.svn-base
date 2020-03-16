package model;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;

import add.IListener;
import enums.ActionSelect;
import model.elements.SlotDevice;



public class PageSlotSelection implements Transferable, ClipboardOwner{
	
	public static DataFlavor slotFlavor;
	private DataFlavor[] supportedFlavors= {slotFlavor};
	private ArrayList<SlotDevice> pageSlots=new ArrayList<SlotDevice>();
	public Document doc;
	 private ArrayList<IListener> listeners;
	
	
	public PageSlotSelection(ArrayList<SlotDevice> slots) {
		pageSlots = slots;
		try {
			slotFlavor = new DataFlavor(Class.forName("java.util.ArrayList"), "Slots");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	  public ArrayList<SlotDevice> getSelectedElements() {
			return pageSlots;
		}
	    
	   public void addSelectedElementToTheList(SlotDevice element) {
		   pageSlots.add(element);
		   notifyObservers(element, ActionSelect.SELECTION);
	   }
	   
	   public void removeFromSelectionList(SlotDevice element) {
		   pageSlots.remove(element);
		   notifyObservers(element, ActionSelect.SELECTION);
	   }
	   public void removeAllElementsFromList() {
		   pageSlots.clear();
		   notifyObservers("Remove", ActionSelect.SELECTION);
	   }

    
    public boolean isElementSelected(SlotDevice element) {
    	return pageSlots.contains(element);
    }
	
	
	public void selectElements(Rectangle2D rec,ArrayList<SlotDevice> elements){
		for(SlotDevice pageDevice : elements) {
				if(rec.intersects(pageDevice.getPoint().getX(), pageDevice.getPoint().getY(),
						pageDevice.getDimension().getWidth(), pageDevice.getDimension().getHeight())){
					if(!isElementSelected(pageDevice))
						pageSlots.add(pageDevice);
				}
			}
		}
	
	public void notifyObservers(Object event, ActionSelect a) {
 		if(event == null || this.listeners == null || this.listeners.isEmpty())
 			return;

 		for(IListener listener : listeners){
 			listener.update(event, a);
 		}
 		
 	}
	

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		
		return supportedFlavors;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		// TODO Auto-generated method stub
		return slotFlavor.equals(flavor);
	}

	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		
		if(flavor.equals(slotFlavor)) {
			return pageSlots;
		}else {
			throw new UnsupportedFlavorException(slotFlavor);
		}
	}

	public DataFlavor[] getSupportedFlavors() {
		return supportedFlavors;
	}

	public void setSupportedFlavors(DataFlavor[] supportedFlavors) {
		this.supportedFlavors = supportedFlavors;
	}

}
