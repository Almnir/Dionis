package dionis.beans;

import dionis.xml.InterfaceAuthorityType;

public class AuthLocalBean extends ModelObject {

	protected InterfaceAuthorityType auth;
	protected String name;
	protected String password;

	public AuthLocalBean() {
	}

	public InterfaceAuthorityType getAuth() {
		return auth;
	}

	public void setAuth(InterfaceAuthorityType auth) {
		firePropertyChange("auth", this.auth, this.auth = auth);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		firePropertyChange("name", this.name, this.name = name);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		firePropertyChange("password", this.password, this.password = password);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AuthLocalBean [");
		if (auth != null) {
			builder.append("auth=");
			builder.append(auth);
			builder.append(", ");
		}
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		if (password != null) {
			builder.append("password=");
			builder.append(password);
		}
		builder.append("]");
		return builder.toString();
	}

}
