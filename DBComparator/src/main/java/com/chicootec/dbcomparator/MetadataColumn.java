package com.chicootec.dbcomparator;

public class MetadataColumn {
  private String name = "";
  private String type = "";
  private int length = 0;

  public MetadataColumn() {}

  public MetadataColumn(String name, String type, int length) {
    this.name = name;
    this.type = type;
    this.length = length;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getLength() {
    return this.length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int hashCode() {
    int prime = 31;
    int result = 1;
    result = prime * result + this.length;
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
    return result;
  }

  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (super.getClass() != obj.getClass())
      return false;
    
    MetadataColumn other = (MetadataColumn) obj;
    if (this.length != other.length)
      return false;

    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!(this.name.equals(other.name))) {
      return false;
    }

    if (this.type == null) {
      if (other.type != null) {
        return false;
      }
    } else if (!(this.type.equals(other.type))) {
      return false;
    }
    return true;
  }

  public String toString() {
    return "[" + this.name + " : " + this.type + " " + this.length + "]";
  }
}
