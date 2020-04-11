package com.sjbb.entity;
// Generated Apr 11, 2020 1:08:06 AM by Hibernate Tools 5.2.12.Final

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
	@NamedQuery(name= "Category.findAll", query="SELECT c FROM Category c ORDER BY c.nameCategory"),
	@NamedQuery(name= "Category.countAll", query = "SELECT Count(*) FROM Category c" )
	//@NamedQuery(name= "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email" )
	
})
@Table(name = "category", catalog = "fyp")
public class Category implements java.io.Serializable {

	private Integer idCategory;
	private String nameCategory;
	private Set<Inventory> inventories = new HashSet<Inventory>(0);

	public Category() {
	}

	public Category(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public Category(String nameCategory, Set<Inventory> inventories) {
		this.nameCategory = nameCategory;
		this.inventories = inventories;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_category", unique = true, nullable = false)
	public Integer getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	@Column(name = "name_category", nullable = false, length = 30)
	public String getNameCategory() {
		return this.nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Inventory> getInventories() {
		return this.inventories;
	}

	public void setInventories(Set<Inventory> inventories) {
		this.inventories = inventories;
	}

}
