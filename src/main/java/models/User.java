package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Builder
@ToString

public class User {
  private String email;
  private String password;
  public User(){} //подсвечен constructor default

  public User(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public void setEmail(String email) {
    if(email != null && email.isEmpty())
      this.email = email;
  }
  public User withEmail(String email) {
    this.email = email;
    return this;
  }
  public void setPassword(String password) {
    if(password != null && password.isEmpty())
      this.password = password;
  }
  public User withPassword(String password) {
    this.password = password;
    return this;
  }
//  public String getEmail() {
//    return email;
//  }
//  public String getPassword() {
//    return password;
//  }
}
