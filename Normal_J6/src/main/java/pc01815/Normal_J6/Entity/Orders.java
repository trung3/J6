package pc01815.Normal_J6.Entity;
// Generated Jul 17, 2022, 5:56:00 PM by Hibernate Tools 4.3.6.Final

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * Orders generated by hbm2java
 */
@Data
@Entity
@Table(name = "orders", catalog = "normal_j6")
public class Orders implements java.io.Serializable {

	private Integer id;
	private Accounts accounts;
	private String username;
	private Date oderDate;

	private String address;

	

	private List<Orderdetails> orderDtails = new ArrayList<Orderdetails>();

	public Orders() {
	}

	public Orders(Accounts accounts,String username, Date oderDate, int telephone, String address, float amount, String description,
			boolean status) {
		this.accounts = accounts;
		this.username = username;
		this.oderDate = oderDate;
		this.address = address;


	}

	public Orders(Accounts accounts,String username, Date oderDate, int telephone, String address, float amount, String description,
			boolean status, List<Orderdetails> orderDtails) {
		this.accounts = accounts;
		this.username = username;
		this.oderDate = oderDate;
		this.address = address;
		this.orderDtails = orderDtails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUser", nullable = false)
	public Accounts getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "OderDate", nullable = false, length = 10)
	public Date getOderDate() {
		return this.oderDate;
	}

	public void setOderDate(Date oderDate) {
		this.oderDate = oderDate;
	}



	@Column(name = "address", nullable = false, length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "Username", nullable = false, length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}





	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orders")
	public List<Orderdetails> getOrderDtails() {
		return this.orderDtails;
	}

	public void setOrderDtails(List<Orderdetails> orderDtails) {
		this.orderDtails = orderDtails;
	}

}
