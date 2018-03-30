package commerce.users;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity(name = "users") // This tells Hibernate to make a table out of this class
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	private String first_name;
    private String last_name;
	private String pass_word;
	private String user_name;
	private String email;

	@Column(name = "first_name")
	public String getFirstName() {
		return first_name;
	}
	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return last_name;
	}
	public void setLastName(String lastName) {
		this.last_name = lastName;
	}

	@Column(name = "pass_word")
	public String getPassWord() {
		return pass_word;
	}
	public void setPassWord(String passWord) {
		this.pass_word = passWord;
	}

	@Column(name = "user_name")
	public String getUserName() {
		return user_name;
	}
	public void setUserName(String userName) {
		this.user_name = userName;
	}

	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}

