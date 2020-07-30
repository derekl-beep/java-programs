package com.derek;

public class TextBox {
    // Fields
    private String text = "";

    // Methods
    public void setText(String text) {
        this.text = text;
    }

    public void clear() {
        text = "";
    }

    public void print() {
        System.out.println(text);
    }
}
