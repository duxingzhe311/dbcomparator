package com.chicootec.dbcomparator;

import java.util.ArrayList;
import java.util.List;

public class MetadataTable {
  private String tableName = "";
  private List<MetadataColumn> cols = new ArrayList<>();

  public String getTableName() {
    return this.tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public List<MetadataColumn> getCols() {
    return this.cols;
  }

  public void setCols(List<MetadataColumn> cols) {
    this.cols = cols;
  }

  public int hashCode() {
    int prime = 31;
    int result = 1;
    result = prime * result + ((this.cols == null) ? 0 : this.cols.hashCode());
    result = prime * result + ((this.tableName == null) ? 0 : this.tableName.hashCode());
    return result;
  }

  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (super.getClass() != obj.getClass())
      return false;
    MetadataTable other = (MetadataTable) obj;
    if ((this.cols == null) && (other.cols != null)) {
      return false;
    }

    if (this.tableName == null)
      if (other.tableName != null)
        return false;
      else if (!(this.tableName.equals(other.tableName))) {
        return false;
      }
    return closEquals(this.cols, other.cols);
  }

  public String toString() {
    return "[tableName=" + this.tableName + ", cols=" + this.cols + "]";
  }

  private boolean closEquals(List<MetadataColumn> src, List<MetadataColumn> dest) {
    if (src.size() != dest.size()) {
      return false;
    }
    for (MetadataColumn cm : src) {
      if (!(dest.contains(cm))) {
        return false;
      }
    }
    return true;
  }
}
