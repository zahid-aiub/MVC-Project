package model.MVC;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class UserBean is acts as a model, it
 * also communicate to the database.
 * it perform to create table into database by using
 * diffrent type of annotations
 * 
 * @author zahid
 * @version 1.0
 * @since 2018-05-02
 *
 */
@Entity
@Table(name="student1")
public class UserBean {
	/**
	 * @Id annotation make this variable as a primary key
	 * @column annotation make perform to make it column name
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	//@Column(unique = true)
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	
	
	
	/**
	 * Empty constructor
	 */
	public UserBean() {
	}

	/**
	 * This parameterize constructor help to set the attribute values
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 */
	public UserBean(String firstName, String lastName, String email,String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
