package com.shtp.zuul.bean;

public class PersonalizedUser {
    private int cuid;
    private int userid;

    public PersonalizedUser() {
    }

    public int getCuid() {
        return this.cuid;
    }

    public int getUserid() {
        return this.userid;
    }

    public void setCuid(int cuid) {
        this.cuid = cuid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PersonalizedUser)) return false;
        final PersonalizedUser other = (PersonalizedUser) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getCuid() != other.getCuid()) return false;
        if (this.getUserid() != other.getUserid()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PersonalizedUser;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getCuid();
        result = result * PRIME + this.getUserid();
        return result;
    }

    public String toString() {
        return "cuid=" + this.getCuid() + ", userid=" + this.getUserid() + ")";
    }
}
