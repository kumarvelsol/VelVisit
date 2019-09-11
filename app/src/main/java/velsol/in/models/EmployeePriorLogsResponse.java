package velsol.in.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeePriorLogsResponse implements Serializable
{
    public String inviteeName;

    public String inviteeShceduledOn;

    public String inviteStatus;

    public EmployeePriorLogsResponse(String inviteeName, String inviteeShceduledOn, String inviteStatus)
    {

        this.inviteeName = inviteeName;
        this.inviteeShceduledOn = inviteeShceduledOn;
        this.inviteStatus = inviteStatus;
    }
}
