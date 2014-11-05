package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import dionis.xml.BooleanType;

public class ControlBean extends ModelObject implements PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected BooleanType log;
	protected BooleanType logUser;
	protected BooleanType logSend;
	protected BooleanType logTcp;
	protected BooleanType logSess;

	public ControlBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public BooleanType getLog() {
		return log;
	}

	public void setLog(BooleanType log) {
		firePropertyChange("log", this.log, this.log = log);
	}

	public BooleanType getLogUser() {
		return logUser;
	}

	public void setLogUser(BooleanType logUser) {
		firePropertyChange("logUser", this.logUser, this.logUser = logUser);
	}

	public BooleanType getLogSend() {
		return logSend;
	}

	public void setLogSend(BooleanType logSend) {
		firePropertyChange("logSend", this.logSend, this.logSend = logSend);
	}

	public BooleanType getLogTcp() {
		return logTcp;
	}

	public void setLogTcp(BooleanType logTcp) {
		firePropertyChange("logTcp", this.logTcp, this.logTcp = logTcp);
	}

	public BooleanType getLogSess() {
		return logSess;
	}

	public void setLogSess(BooleanType logSess) {
		firePropertyChange("logSess", this.logSess, this.logSess = logSess);
	}

}
