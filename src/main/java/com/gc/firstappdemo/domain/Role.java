package com.gc.firstappdemo.domain;

import javax.persistence.*;


@Entity
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  private String roleValue;
  private String roleName;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getRoleValue() {
    return roleValue;
  }

  public void setRoleValue(String roleValue) {
    this.roleValue = roleValue;
  }


  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

}
