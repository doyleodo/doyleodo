package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {

   private Long id;
   private String username;
   @JsonIgnore
   private String password;
   @JsonIgnore
   private boolean activated;
   private Set<Authority> authorities = new HashSet<>();
   private String email;
	private String zipcode;
	private String city;
	private String state;
	private String region;
	private String firstName;
	private String lastName;

 

public User(Long id, String username, String password, String authorities, String email,
			String zipcode, String city, String state, String region, String firstName, String lastName) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.activated = true;
		this.email = email;
		this.zipcode = zipcode;
		this.city = city;
		this.region = region;
		this.state = state;
		this.firstName = firstName;
		this.lastName = lastName;
	}

public User(String username, String password, boolean activated, Set<Authority> authorities, String email,
		String zipcode, String city, String state, String region, String firstName, String lastName) {
	super();
	this.username = username;
	this.password = password;
	this.activated = activated;
	this.authorities = authorities;
	this.email = email;
	this.zipcode = zipcode;
	this.city = city;
	this.state = state;
	this.region = region;
	this.firstName = firstName;
	this.lastName = lastName;
}

public User() { }

   

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public boolean isActivated() {
      return activated;
   }

   public void setActivated(boolean activated) {
      this.activated = activated;
   }

   public Set<Authority> getAuthorities() {
      return authorities;
   }

   public void setAuthorities(Set<Authority> authorities) {
      this.authorities = authorities;
   }

   public void setAuthorities(String authorities) {
      String[] roles = authorities.split(",");
      for(String role : roles) {
         String authority = role.contains("ROLE_") ? role : "ROLE_" + role;
         this.authorities.add(new Authority(authority));
      }
   }
   public String getEmail() {
 		return email;
 	}

 	public void setEmail(String email) {
 		this.email = email;
 	}

 	public String getZipcode() {
 		return zipcode;
 	}

 	public void setZipcode(String zipcode) {
 		this.zipcode = zipcode;
 	}
 	public String getRegion() {
 		return region;
 	}
 	public void setRegion(String region) {
 		this.region = region;
 	}

 	public String getCity() {
 		return city;
 	}

 	public void setCity(String city) {
 		this.city = city;
 	}

 	public String getState() {
 		return state;
 	}

 	public void setState(String state) {
 		this.state = state;
 	}

 	public String getFirstName() {
 		return firstName;
 	}

 	public void setFirstName(String firstName) {
 		this.firstName = firstName;
 	}

 	public String getLastName() {
 		return lastName;
 	}

 	public void setLastName(String lastName) {
 		this.lastName = lastName;
 	}

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return id == user.id &&
              activated == user.activated &&
              Objects.equals(username, user.username) &&
              Objects.equals(password, user.password) &&
              Objects.equals(authorities, user.authorities);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, username, password, activated, authorities);
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", username='" + username + '\'' +
              ", activated=" + activated +
              ", authorities=" + authorities +
              ", email=" + email +
      		  ", city=" + city +
      		  ", state=" + state +
      		  ", region=" + region +
      		  ", firstName=" + firstName +
      		  ", lastName=" + lastName +
      		  ", zipcode=" + zipcode +
      		  '}';
   }
}
