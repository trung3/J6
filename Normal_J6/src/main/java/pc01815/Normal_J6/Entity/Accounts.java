package pc01815.Normal_J6.Entity;
// Generated Jul 17, 2022, 5:56:00 PM by Hibernate Tools 4.3.6.Final

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
@Entity
@Table(name = "accounts", catalog = "normal_j6")
public class Accounts implements java.io.Serializable {

	
	private Integer id;
	@NotBlank(message = "")
	private String username;
	@NotBlank(message = "")
	private String password;
	@NotBlank(message = "")
	private String fullname;
	@NotBlank(message = "")
	@Email(message = "")
	private String email;
	


	private List<Authorities> authoritieses = new ArrayList<Authorities>();


	private Set<Orders> orderses = new HashSet<Orders>(0);

	public Accounts() {
	}

	public Accounts(String username, String password, String fullname, String email) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		
	}

	public Accounts(String username, String password, String fullname, String email,
			List<Authorities> authoritieses, Set<Comment> comments, Set<Orders> orderses) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		
		this.authoritieses = authoritieses;

		this.orderses = orderses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false, length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "fullname", nullable = false, length = 100)
	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Column(name = "email", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accounts")
	public List<Authorities> getAuthoritieses() {
		return this.authoritieses;
	}

	public void setAuthoritieses(List<Authorities> authoritieses) {
		this.authoritieses = authoritieses;
	}



	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accounts")
	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

}
