package com.sonpen;

/**
 * Created by sonikju on 2018-10-09.
 */
public class Meeting {

    private String title;
    private String address;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "title='" + title + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
