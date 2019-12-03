package com.oracle.pojo;

import java.io.Serializable;

public class Log implements Serializable {
    private Integer id;

    private String executemethodname;

    private String executetime;

    private String executorname;

    private String requestip;

    private String requestime;

    private String requestdesc;

    private String executeargs;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExecutemethodname() {
        return executemethodname;
    }

    public void setExecutemethodname(String executemethodname) {
        this.executemethodname = executemethodname == null ? null : executemethodname.trim();
    }

    public String getExecutetime() {
        return executetime;
    }

    public void setExecutetime(String executetime) {
        this.executetime = executetime == null ? null : executetime.trim();
    }

    public String getExecutorname() {
        return executorname;
    }

    public void setExecutorname(String executorname) {
        this.executorname = executorname == null ? null : executorname.trim();
    }

    public String getRequestip() {
        return requestip;
    }

    public void setRequestip(String requestip) {
        this.requestip = requestip == null ? null : requestip.trim();
    }

    public String getRequestime() {
        return requestime;
    }

    public void setRequestime(String requestime) {
        this.requestime = requestime == null ? null : requestime.trim();
    }

    public String getRequestdesc() {
        return requestdesc;
    }

    public void setRequestdesc(String requestdesc) {
        this.requestdesc = requestdesc == null ? null : requestdesc.trim();
    }

    public String getExecuteargs() {
        return executeargs;
    }

    public void setExecuteargs(String executeargs) {
        this.executeargs = executeargs == null ? null : executeargs.trim();
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
        Log other = (Log) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getExecutemethodname() == null ? other.getExecutemethodname() == null : this.getExecutemethodname().equals(other.getExecutemethodname()))
            && (this.getExecutetime() == null ? other.getExecutetime() == null : this.getExecutetime().equals(other.getExecutetime()))
            && (this.getExecutorname() == null ? other.getExecutorname() == null : this.getExecutorname().equals(other.getExecutorname()))
            && (this.getRequestip() == null ? other.getRequestip() == null : this.getRequestip().equals(other.getRequestip()))
            && (this.getRequestime() == null ? other.getRequestime() == null : this.getRequestime().equals(other.getRequestime()))
            && (this.getRequestdesc() == null ? other.getRequestdesc() == null : this.getRequestdesc().equals(other.getRequestdesc()))
            && (this.getExecuteargs() == null ? other.getExecuteargs() == null : this.getExecuteargs().equals(other.getExecuteargs()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getExecutemethodname() == null) ? 0 : getExecutemethodname().hashCode());
        result = prime * result + ((getExecutetime() == null) ? 0 : getExecutetime().hashCode());
        result = prime * result + ((getExecutorname() == null) ? 0 : getExecutorname().hashCode());
        result = prime * result + ((getRequestip() == null) ? 0 : getRequestip().hashCode());
        result = prime * result + ((getRequestime() == null) ? 0 : getRequestime().hashCode());
        result = prime * result + ((getRequestdesc() == null) ? 0 : getRequestdesc().hashCode());
        result = prime * result + ((getExecuteargs() == null) ? 0 : getExecuteargs().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", executemethodname=").append(executemethodname);
        sb.append(", executetime=").append(executetime);
        sb.append(", executorname=").append(executorname);
        sb.append(", requestip=").append(requestip);
        sb.append(", requestime=").append(requestime);
        sb.append(", requestdesc=").append(requestdesc);
        sb.append(", executeargs=").append(executeargs);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}