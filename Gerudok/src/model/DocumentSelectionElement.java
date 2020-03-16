package model;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class DocumentSelectionElement implements Transferable, ClipboardOwner {
	public static DataFlavor elementFlavour;
	private DataFlavor[] supportedFlavours = { elementFlavour };
	public Document doc = null;

	public DocumentSelectionElement(Document doc) {
		this.doc = doc;
		try {
			elementFlavour = new DataFlavor(Class.forName("Model.WorkspaceJtree.Document"), "Document");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void lostOwnership(Clipboard arg0, Transferable arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		if (flavor.equals(elementFlavour))
			return doc;
		else
			throw new UnsupportedFlavorException(elementFlavour);
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return supportedFlavours;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		// TODO Auto-generated method stub
		return (flavor.equals(elementFlavour));
	}
}