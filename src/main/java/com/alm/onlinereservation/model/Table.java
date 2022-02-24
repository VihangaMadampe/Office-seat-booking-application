package com.alm.onlinereservation.model;

import javax.persistence.*;
import java.util.List;


@Entity(name = "floor_tables")
public class Table {

    @ElementCollection
    private List<Side> leftSeats, rightSeats;

    @ManyToOne
    @JoinColumn(name = "FLOOR_ID")
    private Floor floor;

    @Id
    @Column
    private String tableName;

    public Table(String name) {
        this.tableName = name;
    }

    public Table() {
        System.out.println("Creating a table");
    }

    public List<Side> getLeftSeats() {
        return leftSeats;
    }

    public void setLeftSeats(List<Side> leftSeats) {
        this.leftSeats = leftSeats;
    }

    public List<Side> getRightSeats() {
        return rightSeats;
    }

    public void setRightSeats(List<Side> rightSeats) {
        this.rightSeats = rightSeats;
    }

    public String setSeat(String direction, int index, Side side)
    {
        String success = "Seat not Reserved";

        if(direction.equals("left"))
        {
            if(!leftSeats.get(index).getStatus().equals("reserved"))
            {
                int size = leftSeats.size() -1;
                boolean isReserved = false;
                boolean up = false,down = false;

                if((index-1) >= 0)
                {
                    if(leftSeats.get(index-1).getStatus().equals("reserved"))
                        isReserved = true;
                    up = true;
                }

                if((index+1) <=size)
                {
                    if(leftSeats.get(index+1).getStatus().equals("reserved"))
                        isReserved = true;
                    down = true;
                }

                if(!isReserved)
                {
                    leftSeats.set(index, side);
                    if(up)
                    {
                        Side tempSide = new Side(leftSeats.get(index - 1).getName(),
                                leftSeats.get(index - 1).getTeamID(), "blocked");
                        leftSeats.set((index - 1),tempSide);
                    }
                    if(down)
                    {
                        Side tempSide = new Side(leftSeats.get(index + 1).getName(),
                                leftSeats.get(index + 1).getTeamID(), "blocked");
                        leftSeats.set((index + 1),tempSide);
                    }

                    success = "Seat Reserved";
                }
                else
                    success = "Error:Seat already reserved/booked";
            }
            else
                success = "Error:Seat already reserved";
        }

        else if(direction.equals("right"))
        {
            if(!rightSeats.get(index).getStatus().equals("reserved"))
            {
                int size = rightSeats.size() -1;
                boolean isReserved = false;
                boolean up = false,down = false;

                if((index-1) >= 0)
                {
                    if(rightSeats.get(index-1).getStatus().equals("reserved"))
                        isReserved = true;
                    up = true;
                }

                if((index+1) <=size)
                {
                    if(rightSeats.get(index+1).getStatus().equals("reserved"))
                        isReserved = true;
                    down = true;
                }

                if(!isReserved)
                {
                    rightSeats.set(index, side);
                    if(up)
                    {
                        Side tempSide = new Side(rightSeats.get(index - 1).getName(),
                                rightSeats.get(index - 1).getTeamID(), "blocked");
                        rightSeats.set((index - 1),tempSide);
                    }
                    if(down)
                    {
                        Side tempSide = new Side(rightSeats.get(index + 1).getName(),
                                rightSeats.get(index + 1).getTeamID(), "blocked");
                        rightSeats.set((index + 1),tempSide);
                    }
                    success = "Seat Reserved";
                }
                else
                    success = "Error:Seat already reserved/booked";
            }
            else
                success = "Error:Seat already reserved";
        }
        return success;
    }

    public String removeBooking(String direction, int index, Side side)
    {
        String success = "";
        if(direction.equals("left"))
        {
            if(leftSeats.get(index).getStatus().equals("blocked"))
                success = "Error: You cannot remove blocked seats";

            else if(leftSeats.get(index).getStatus().equals("available"))
                success = "Error: Seat is already available";

            else
            {
                int size = leftSeats.size() - 1;
                boolean up = false, down = false;

                if((index-1) >= 0)
                {
                    if((index-2) >= 0)
                    {
                        if(!leftSeats.get(index-2).getStatus().equals("reserved"))
                            up = true;
                    }
                    else
                        up = true;
                }

                if((index+1) <=size)
                {
                    if((index+2) <=size)
                    {
                        if(!leftSeats.get(index+2).getStatus().equals("reserved"))
                            down = true;
                    }
                    else
                        down = true;
                }

                Side tempSide = new Side(leftSeats.get(index).getName(),
                        leftSeats.get(index).getTeamID(), "available");
                leftSeats.set(index, tempSide);

                if(up)
                {
                    tempSide = new Side(leftSeats.get(index - 1).getName(),
                            leftSeats.get(index - 1).getTeamID(), "available");
                    leftSeats.set((index - 1),tempSide);
                }

                if(down)
                {
                    tempSide = new Side(leftSeats.get(index + 1).getName(),
                            leftSeats.get(index + 1).getTeamID(), "available");
                    leftSeats.set((index + 1),tempSide);
                }
                success = "Booking successfully removed";
            }

        }

        else if(direction.equals("right"))
        {
            if(rightSeats.get(index).getStatus().equals("blocked"))
                success = "Error: You cannot remove blocked seats";

            else if(rightSeats.get(index).getStatus().equals("available"))
                success = "Error: Seat is already available";
            else
            {
                int size = rightSeats.size() - 1;
                boolean up = false, down = false;

                if((index-1) >= 0)
                {
                    if((index-2) >= 0)
                    {
                        if(!rightSeats.get(index-2).getStatus().equals("reserved"))
                            up = true;
                    }
                    else
                        up = true;
                }

                if((index+1) <=size)
                {
                    if((index+2) <=size)
                    {
                        if(!rightSeats.get(index+2).getStatus().equals("reserved"))
                            down = true;
                    }
                    else
                        down = true;
                }

                Side tempSide = new Side(rightSeats.get(index).getName(),
                        rightSeats.get(index).getTeamID(), "available");
                rightSeats.set(index, tempSide);

                if(up)
                {
                    tempSide = new Side(rightSeats.get(index - 1).getName(),
                            rightSeats.get(index - 1).getTeamID(), "available");
                    rightSeats.set((index - 1),tempSide);
                }

                if(down)
                {
                    tempSide = new Side(rightSeats.get(index + 1).getName(),
                            rightSeats.get(index + 1).getTeamID(), "available");
                    rightSeats.set((index + 1),tempSide);
                }
                success = "Booking successfully removed";
            }
        }
        return success;
    }
}
