package com.example.adminbaseball.common;

public class Value {
    private String section_no;
    private String seat_col;
    private String seat_row;

    public Value(String section_no, String seat_col, String seat_row) {
        this.section_no = section_no;
        this.seat_col = seat_col;
        this.seat_row = seat_row;
    }

    public String getSection_no() {
        return section_no;
    }

    public void setSection_no(String section_no) {
        this.section_no = section_no;
    }

    public String getSeat_col() {
        return seat_col;
    }

    public void setSeat_col(String seat_col) {
        this.seat_col = seat_col;
    }

    public String getSeat_row() {
        return seat_row;
    }

    public void setSeat_row(String seat_row) {
        this.seat_row = seat_row;
    }
}
