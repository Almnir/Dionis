package dionis.beans;

import dionis.xml.BooleanType;
import dionis.xml.FilterLinkType;
import dionis.xml.FilterOperationType;

public class ExtBean extends ModelObject {
	protected BooleanType ip;
	protected short offset;
	protected FilterOperationType operation;
	protected String data;
	protected FilterLinkType link;

	public BooleanType getIp() {
		return ip;
	}

	public void setIp(BooleanType ip) {
		firePropertyChange("ip", this.ip, this.ip = ip);
	}

	public short getOffset() {
		return offset;
	}

	public void setOffset(short offset) {
		firePropertyChange("offset", this.offset, this.offset = offset);
	}

	public FilterOperationType getOperation() {
		return operation;
	}

	public void setOperation(FilterOperationType operation) {
		firePropertyChange("operation", this.operation,
				this.operation = operation);
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		firePropertyChange("data", this.data, this.data = data);
	}

	public FilterLinkType getLink() {
		return link;
	}

	public void setLink(FilterLinkType link) {
		firePropertyChange("link", this.link, this.link = link);
	}
}
