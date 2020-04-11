package com.sjbb.entity;
// Generated Apr 11, 2020 12:53:19 AM by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name= "Users.findAll", query="SELECT u FROM Users u ORDER BY u.nameCust"),
	@NamedQuery(name= "Users.countAll", query = "SELECT Count(*) FROM Users u" ),
	@NamedQuery(name= "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email" )
	
})
@Table(name = "users", catalog = "fyp")
public class Users implements java.io.Serializable {

	private Integer idCust;
	private String email;
	private String nameCust;
	private String password;
	private Set<Order> orders = new HashSet<Order>(0);

	public Users() {
	}
	
	public Users(String email, String nameCust, String password) {
		this.email = email;
		this.nameCust = nameCust;
		this.password = password;
	}
	

	public Users(Integer idCust, String email, String nameCust, String password) {
		
		this.idCust = idCust;
		this.email = email;
		this.nameCust = nameCust;
		this.password = password;
	}

	public Users(String email, String nameCust, String password, Set<Order> orders) {
		this.email = email;
		this.nameCust = nameCust;
		this.password = password;
		this.orders = orders;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_cust", unique = true, nullable = false)
	public Integer getIdCust() {
		return this.idCust;
	}

	public void setIdCust(Integer idCust) {
		this.idCust = idCust;
	}

	@Column(name = "email", nullable = false, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "name_cust", nullable = false, length = 20)
	public String getNameCust() {
		return this.nameCust;
	}

	public void setNameCust(String nameCust) {
		this.nameCust = nameCust;
	}

	@Column(name = "password", nullable = false, length = 10)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
