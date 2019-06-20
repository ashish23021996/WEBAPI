package Banks;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "branches")
public class Branches {

	private String ifsc;
	private int bank_id;
	private String branch;
	private String address;
	private String city;
	private String district;
	private String state;

	public Branches() {
		super();
	}

	public Branches(String ifsc, int bank_id, String branch, String address, String city, String district,
			String state) {
		super();
		this.ifsc = ifsc;
		this.bank_id = bank_id;
		this.branch = branch;
		this.address = address;
		this.city = city;
		this.district = district;
		this.state = state;
	}

	public String getIfsc() {
		return ifsc;
	}

	@XmlElement
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public int getBank_id() {
		return bank_id;
	}

	@XmlElement
	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}

	public String getBranch() {
		return branch;
	}

	@XmlElement
	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAddress() {
		return address;
	}

	@XmlElement
	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	@XmlElement
	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	@XmlElement
	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	@XmlElement
	public void setState(String state) {
		this.state = state;
	}

}
