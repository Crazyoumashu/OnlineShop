package com.hhw.beans;

public class Group {
    //主键
    private int jid;
    private int groupid;
    private String jsp;

    public Group(int groupid, String jsp) {
        this.groupid = groupid;
        this.jsp = jsp;
    }

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public String getJsp() {
        return jsp;
    }

    public void setJsp(String jsp) {
        this.jsp = jsp;
    }
}
