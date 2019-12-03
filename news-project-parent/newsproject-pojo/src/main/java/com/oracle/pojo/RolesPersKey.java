package com.oracle.pojo;

import java.io.Serializable;

public class RolesPersKey implements Serializable {
    private Integer roles;

    private Integer pers;

    private static final long serialVersionUID = 1L;

    public Integer getRoles() {
        return roles;
    }

    public void setRoles(Integer roles) {
        this.roles = roles;
    }

    public Integer getPers() {
        return pers;
    }

    public void setPers(Integer pers) {
        this.pers = pers;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        RolesPersKey other = (RolesPersKey) that;
        return (this.getRoles() == null ? other.getRoles() == null : this.getRoles().equals(other.getRoles()))
            && (this.getPers() == null ? other.getPers() == null : this.getPers().equals(other.getPers()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoles() == null) ? 0 : getRoles().hashCode());
        result = prime * result + ((getPers() == null) ? 0 : getPers().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roles=").append(roles);
        sb.append(", pers=").append(pers);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}