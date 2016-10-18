/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.devpragmatic.lifetimerjavafxgui.control;

import javafx.scene.control.TextField;

/**
 *
 * @author devpragmatic
 */
public class NumberTextField extends TextField
{
    private int maxlength = 19;
    private long maxValue = Long.MAX_VALUE;
    public int getMaxlength() {
        return maxlength;
    }

    public void setMaxlength(int maxlength) {
        this.maxlength = maxlength;
    }

    public long getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(long maxValue) {
        this.maxValue = maxValue;
    }

    
    @Override
    public void replaceText(int start, int end, String text) {
        if (validate(text)){
            String changedText = changeText(text, start, end);
            if (text.equals("") || getText().length() < maxlength || end < getText().length() || (start != end && end == getText().length())) {
                if(text.equals(changedText))
                    super.replaceText(start, end, changedText);
                else{
                    super.replaceText(0, getText().length(), changedText);
                }
            }
        }
    }

    @Override
    public void replaceSelection(String text) {
        if (validate(text)) {
            if (text.equals("")) {
                 super.replaceSelection(changeText(text, -1, -1));
            } else if (getText().length() < maxlength) {
                if (text.length() > maxlength - getText().length()) {
                    text = text.substring(0, maxlength- getText().length());
                }
                super.replaceSelection(changeText(text, -1, -1));
            }
        }
    }

    private boolean validate(String text) {
        if(text.length() <= maxlength)
            return text.matches("[0-9]*");
        return false;
    }

    private String changeText(String text, int start, int end) {
        if(getText().length() > 0){
            String valueString;
            if(start == -1 || end == -1){
                valueString = text;
            }else if((start == end && getLength() == end) || (start != end && getLength() == end - 1)){
                valueString = getText() + text;
            }else{
                valueString = new StringBuilder(getText()).replace(start, end, text).toString();
            }
            if(valueString.length() > 0){
                long value = Long.valueOf(valueString);
                if(value > maxValue){
                    return String.valueOf(maxValue);
                }else{
                    return text;
                }
            }
        }
        return text;
    }
    
    /**
     * Return text as Integer
     * @return text as Integer
     */
    public Integer getInteger(){
        if(getText().length() < 1){
            return 0;
        }
        return Integer.valueOf(getText());
    }
}
