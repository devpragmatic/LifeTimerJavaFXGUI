package pl.devpragmatic.lifetimerjavafxgui.control;

import javafx.scene.control.TextField;

/**
 *
 * @author devpragmatic
 */
public class NumberTextField extends TextField
{
    private int maxLength = 19;
    private long maxValue = Long.MAX_VALUE;
    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public long getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(long maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * Veryfing maxlength and number only text. Replace corrected text using super method.
     *
     * @param start The starting index in the range, inclusive. This must be &gt;= 0 and &lt; the end.
     * @param end The ending index in the range, exclusive. This is one-past the last character to
     *            delete (consistent with the String manipulation methods). This must be &gt; the start,
     *            and &lt;= the length of the text.
     * @param text The text that is to replace the range. This must not be null.
     */
    @Override
    public void replaceText(int start, int end, String text) {
        if (validate(text)){
            String changedText = changeText(text, start, end);
            if (text.equals("") || getText().length() < maxLength || end < getText().length() || (start != end && end == getText().length())) {
                if(text.equals(changedText))
                    super.replaceText(start, end, changedText);
                else{
                    super.replaceText(0, getText().length(), changedText);
                }
            }
        }
    }
    
    /**
     * Veryfing maxlength and number only text. Replace corrected text using super method.
     * @param text selection text to change
     */
    @Override
    public void replaceSelection(String text) {
        if (validate(text)) {
            if (text.equals("")) {
                 super.replaceSelection(changeText(text, -1, -1));
            } else if (getText().length() < maxLength) {
                if (text.length() > maxLength - getText().length()) {
                    text = text.substring(0, maxLength- getText().length());
                }
                super.replaceSelection(changeText(text, -1, -1));
            }
        }
    }

    private boolean validate(String text) {
        if(text.length() <= maxLength)
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
