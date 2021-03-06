package rs.avicentic.restfullwebservices.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@ToString
//@AllArgsConstructor
@ApiModel(description = "All details about the user")
@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 2, message = "Name should hve at least 2 characters")
	@ApiModelProperty(notes = "Name should hve at least 2 characters")
	private String name;

	@Past
	@ApiModelProperty(notes = "Birth date cannot be in the past")
	private Date birthDate;

	@OneToMany(mappedBy="user")
	private List<Post> posts;

	public User() {
		super();
	}

	public User(Integer id, @Size(min = 2, message = "Name should hve at least 2 characters") String name,
			@Past Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
}
