package com.chicootec.dbcomparator;

public class DbCfg {
  private String url = "";
  private String userName = "";
  private String password = "";

  public DbCfg(String url, String userName, String password) {
    this.url = url;
    this.userName = userName;
    this.password = password;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String toString() {
    return "DbCfg [url=" + this.url + ", userName=" + this.userName + ", password=" + this.password
        + "]";
  }
}
