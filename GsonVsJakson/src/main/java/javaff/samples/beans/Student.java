package javaff.samples.beans;

import io.github.rhkiswani.javaff.json.annotations.GsonBean;

@GsonBean
public class Student extends Person{

    private int stdId;

    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }
}
