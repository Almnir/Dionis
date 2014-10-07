package dionis.beans;

public class TunnelUDPPortsBean extends ModelObject {
	protected int sender;
	protected int receiver;

	public TunnelUDPPortsBean() {
	}

	public int getSender() {
		return sender;
	}

	public void setSender(int sender) {
		firePropertyChange("sender", this.sender, this.sender = sender);
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		firePropertyChange("receiver", this.receiver, this.receiver = receiver);
	}
}
