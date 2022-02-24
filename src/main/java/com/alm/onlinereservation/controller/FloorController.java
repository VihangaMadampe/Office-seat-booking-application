package com.alm.onlinereservation.controller;

import com.alm.onlinereservation.model.Floor;
import com.alm.onlinereservation.model.Side;
import com.alm.onlinereservation.model.Table;
import com.alm.onlinereservation.repository.FloorRepository;
import com.alm.onlinereservation.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FloorController {

    @Autowired
    FloorRepository floorRepository;

    @Autowired
    TableRepository tableRepository;

    @GetMapping("/floors")
    private List<Floor> getAllFloors()
    {
        return (List<Floor>) floorRepository.findAll();
    }

    @GetMapping("/{floorID}/tables")
    private List<Table> getFloorTables(@PathVariable("floorID") int floorID)
    {
        List<Floor> allFloors = (List<Floor>) floorRepository.findAll();
        return allFloors.get(floorID).getTables();
    }

    @GetMapping("/{floorID}/tables/{tableID}")
    private Table getTable(@PathVariable("floorID") int floorID, @PathVariable("tableID") int tableID)
    {
        List<Floor> allFloors = (List<Floor>) floorRepository.findAll();
        return allFloors.get(floorID).getTables().get(tableID);
    }

    @PutMapping("/set/{sideValue}/{floorID}/{tableID}/{seatElement}")
    @ResponseBody
    private Optional<String> bookSeat(@PathVariable("sideValue") String sideValue,
                                      @PathVariable("floorID") int floorID,
                                      @PathVariable("tableID") int tableID,
                                      @PathVariable("seatElement") int seatElement, @RequestBody Side side)
    {
        return floorRepository.findById(floorID).map(curFloor ->{
            String status = curFloor.getTables().get(tableID-1).setSeat(sideValue,seatElement-1,side);
            floorRepository.save(curFloor);
            return status;
        });
    }

    @PutMapping("/remove/{sideValue}/{floorID}/{tableID}/{seatElement}")
    @ResponseBody
    private Optional<String> removeBookedSeat(@PathVariable("sideValue") String sideValue,
                                     @PathVariable("floorID") int floorID,
                                     @PathVariable("tableID") int tableID,
                                     @PathVariable("seatElement") int seatElement, @RequestBody Side side)
    {
         return floorRepository.findById(floorID).map(curFloor ->{
             String status = curFloor.getTables().get(tableID-1).removeBooking(sideValue,seatElement-1,side);
             floorRepository.save(curFloor);
             return status;
        });
    }

}
