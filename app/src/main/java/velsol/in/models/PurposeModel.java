package velsol.in.models;

import lombok.Data;

@Data
public class PurposeModel
{
    private String purposeName;
    private String purposeImg;

    public PurposeModel(String purposeName) {
        this.purposeName = purposeName;
    }
}
