package sample.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@NotBlank
	@Column(name="name")
	private String name;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="product_relations", joinColumns=@JoinColumn(name="product_id"), inverseJoinColumns=@JoinColumn(name="related_product_id"))
	private Set<Product> relatedProducts;

	public Product() {
	}
	@JsonCreator
	public Product(@JsonProperty Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getRelatedProducts() {
		return relatedProducts;
	}

	public void setRelatedProducts(Set<Product> relatedProducts) {
		this.relatedProducts = relatedProducts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
