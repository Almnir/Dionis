package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import dionis.xml.BooleanType;
import dionis.xml.InterfaceDFType;
import dionis.xml.InterfaceParametrType;
import dionis.xml.InterfaceParametrsMediaType;
import dionis.xml.InterfaceParametrsModeType;
import dionis.xml.Script;

public class InterfaceParametrsBean extends ModelObject implements
		PropertyChangeListener {

	private static final long serialVersionUID = 0;
	protected BooleanType seq;
	protected BooleanType chksum;
	protected TOSBean tos;
	protected InterfaceDFType df;
	protected Short board;
	protected Short frame;
	protected Integer buf;
	protected Integer delay;
	protected Integer interval;
	protected Integer wait;
	protected InterfaceParametrType type;
	protected String ports;
	protected Script script;
	protected Integer send;
	protected Integer recv;
	protected InterfaceParametrsMediaType media;
	protected InterfaceParametrsModeType mode;
	protected AuthLocalBean authLocal;
	protected AuthRemoteBean authRemote;
	protected Integer vnid;
	protected String baseInterface;
	protected Integer bandwidth;
	protected Integer bandrecv;
	protected String mac;
	protected VLANsBean vlaNs;
	private InterfaceBean interfacesBean;

	public InterfaceParametrsBean() {
	}

	public void setSeq(BooleanType value) {
		firePropertyChange("seq", this.seq, this.seq = value);
	}

	public void setChksum(BooleanType value) {
		firePropertyChange("chksum", this.chksum, this.chksum = value);
	}

	public void setTos(TOSBean tos) {
		tos.addPropertyChangeListener("copy", this);
		tos.addPropertyChangeListener("value", this);
		firePropertyChange("tos", this.tos, this.tos = tos);
	}

	public void setDf(InterfaceDFType value) {
		firePropertyChange("df", this.df, this.df = value);
	}

	public void setBoard(Short value) {
		firePropertyChange("board", this.board, this.board = value);
	}

	public void setFrame(Short value) {
		firePropertyChange("frame", this.frame, this.frame = value);
	}

	public void setBuf(Integer value) {
		firePropertyChange("buf", this.buf, this.buf = value);
	}

	public void setDelay(Integer value) {
		firePropertyChange("delay", this.delay, this.delay = value);
	}

	public void setInterval(Integer value) {
		firePropertyChange("interval", this.interval, this.interval = value);
	}

	public void setWait(Integer value) {
		firePropertyChange("wait", this.wait, this.wait = value);
	}

	public void setType(InterfaceParametrType value) {
		firePropertyChange("type", this.type, this.type = value);
	}

	public void setPorts(String value) {
		firePropertyChange("ports", this.ports, this.ports = value);
	}

	public void setScript(Script value) {
		firePropertyChange("script", this.script, this.script = value);
	}

	public void setSend(Integer value) {
		firePropertyChange("send", this.send, this.send = value);
	}

	public void setRecv(Integer value) {
		firePropertyChange("recv", this.recv, this.recv = value);
	}

	public void setMedia(InterfaceParametrsMediaType value) {
		firePropertyChange("media", this.media, this.media = value);
	}

	public void setMode(InterfaceParametrsModeType value) {
		firePropertyChange("mode", this.mode, this.mode = value);
	}

	public void setAuthLocal(AuthLocalBean value) {
		value.addPropertyChangeListener("auth", this);
		value.addPropertyChangeListener("name", this);
		value.addPropertyChangeListener("password", this);
		firePropertyChange("authLocal", this.authLocal, this.authLocal = value);
	}

	public void setAuthRemote(AuthRemoteBean value) {
		value.addPropertyChangeListener("auth", this);
		value.addPropertyChangeListener("name", this);
		value.addPropertyChangeListener("password", this);
		firePropertyChange("authRemote", this.authRemote,
				this.authRemote = value);
	}

	public void setVnid(Integer value) {
		firePropertyChange("vnid", this.vnid, this.vnid = value);
	}

	public void setBaseInterface(String value) {
		firePropertyChange("baseInterface", this.baseInterface,
				this.baseInterface = value);
	}

	public void setBandwidth(Integer value) {
		firePropertyChange("bandwidth", this.bandwidth, this.bandwidth = value);
	}

	public void setBandrecv(Integer value) {
		firePropertyChange("bandrecv", this.bandrecv, this.bandrecv = value);
	}

	public void setMac(String value) {
		firePropertyChange("mac", this.mac, this.mac = value);
	}

	public void setVlaNs(VLANsBean value) {
		value.addPropertyChangeListener("vlan", this);
		firePropertyChange("vlaNs", this.vlaNs, this.vlaNs = value);
	}

	public void setInterfacesBean(InterfaceBean interfacesBean) {
		this.interfacesBean = interfacesBean;
	}

	public TOSBean getTos() {
		return tos;
	}

	public InterfaceDFType getDf() {
		return df;
	}

	public Integer getVnid() {
		return vnid;
	}

	public VLANsBean getVlaNs() {
		return vlaNs;
	}

	public BooleanType getSeq() {
		return seq;
	}

	public BooleanType getChksum() {
		return chksum;
	}

	public Short getBoard() {
		return board;
	}

	public Short getFrame() {
		return frame;
	}

	public Integer getBuf() {
		return buf;
	}

	public Integer getDelay() {
		return delay;
	}

	public Integer getInterval() {
		return interval;
	}

	public Integer getWait() {
		return wait;
	}

	public InterfaceParametrType getType() {
		return type;
	}

	public String getPorts() {
		return ports;
	}

	public Script getScript() {
		return script;
	}

	public Integer getSend() {
		return send;
	}

	public Integer getRecv() {
		return recv;
	}

	public InterfaceParametrsMediaType getMedia() {
		return media;
	}

	public InterfaceParametrsModeType getMode() {
		return mode;
	}

	public AuthLocalBean getAuthLocal() {
		return authLocal;
	}

	public AuthRemoteBean getAuthRemote() {
		return authRemote;
	}

	public String getBaseInterface() {
		return baseInterface;
	}

	public Integer getBandwidth() {
		return bandwidth;
	}

	public Integer getBandrecv() {
		return bandrecv;
	}

	public String getMac() {
		return mac;
	}

	public InterfaceBean getInterfacesBean() {
		return interfacesBean;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (seq != null)
			builder.append(seq).append(" ");
		if (chksum != null)
			builder.append(chksum).append(" ");
		if (tos != null)
			builder.append(tos).append(" ");
		if (df != null)
			builder.append(df).append(" ");
		if (board != null)
			builder.append(board).append(" ");
		if (frame != null)
			builder.append(frame).append(" ");
		if (buf != null)
			builder.append(buf).append(" ");
		if (delay != null)
			builder.append(delay).append(" ");
		if (interval != null)
			builder.append(interval).append(" ");
		if (wait != null)
			builder.append(wait).append(" ");
		if (type != null)
			builder.append(type).append(" ");
		if (ports != null)
			builder.append(ports).append(" ");
		if (script != null)
			builder.append(script).append(" ");
		if (send != null)
			builder.append(send).append(" ");
		if (recv != null)
			builder.append(recv).append(" ");
		if (media != null)
			builder.append(media).append(" ");
		if (mode != null)
			builder.append(mode).append(" ");
		if (authLocal != null)
			builder.append(authLocal).append(" ");
		if (authRemote != null)
			builder.append(authRemote).append(" ");
		if (vnid != null)
			builder.append(vnid).append(" ");
		if (baseInterface != null)
			builder.append(baseInterface).append(" ");
		if (bandwidth != null)
			builder.append(bandwidth).append(" ");
		if (bandrecv != null)
			builder.append(bandrecv).append(" ");
		if (mac != null)
			builder.append(mac).append(" ");
		if (vlaNs != null)
			builder.append(vlaNs);
		return builder.toString();
	}
}
