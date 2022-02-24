package com.alm.onlinereservation;

import com.alm.onlinereservation.model.Floor;
import com.alm.onlinereservation.model.Side;
import com.alm.onlinereservation.model.Table;
import com.alm.onlinereservation.repository.FloorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class OnlineReservationApplication {

	private static final Logger log = LoggerFactory.getLogger(OnlineReservationApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OnlineReservationApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(FloorRepository repository){
		return (args) -> {
			Floor f1 = new Floor();
			Table t1 = new Table("01");

			List<Side> table1RightSide = new ArrayList<>(){{
				add(new Side("T01_R1",0,"available"));
				add(new Side("T01_R2",0,"available"));
				add(new Side("T01_R3",0,"available"));
				add(new Side("T01_R4",0,"available"));
			}};

			List<Side> table1LeftSide = new ArrayList<>(){{
				add(new Side("T01_L1",0,"available"));
				add(new Side("T01_L2",0,"available"));
				add(new Side("T01_L3",0,"available"));
				add(new Side("T01_L4",0,"available"));
			}};

			t1.setLeftSeats(table1LeftSide);
			t1.setRightSeats(table1RightSide);

			Table t2 = new Table("02");

			List<Side> table2RightSide = new ArrayList<>(){{
				add(new Side("T02_R1",0,"available"));
				add(new Side("T02_R2",0,"available"));
				add(new Side("T02_R3",0,"available"));
				add(new Side("T02_R4",0,"available"));
			}};

			List<Side> table2LeftSide = new ArrayList<>(){{
				add(new Side("T02_L1",0,"available"));
				add(new Side("T02_L2",0,"available"));
				add(new Side("T02_L3",0,"available"));
				add(new Side("T02_L4",0,"available"));
			}};

			t2.setLeftSeats(table2LeftSide);
			t2.setRightSeats(table2RightSide);

			Table t3 = new Table("03");

			List<Side> table3RightSide = new ArrayList<>(){{
				add(new Side("T03_R1",0,"available"));
				add(new Side("T03_R2",0,"available"));
				add(new Side("T03_R3",0,"available"));
				add(new Side("T03_R4",0,"available"));
			}};

			List<Side> table3LeftSide = new ArrayList<>(){{
				add(new Side("T03_L1",0,"available"));
				add(new Side("T03_L2",0,"available"));
				add(new Side("T03_L3",0,"available"));
				add(new Side("T03_L4",0,"available"));
			}};

			t3.setLeftSeats(table3LeftSide);
			t3.setRightSeats(table3RightSide);

			Table t4 = new Table("04");

			List<Side> table4RightSide = new ArrayList<>(){{
				add(new Side("T04_R1",0,"available"));
				add(new Side("T04_R2",0,"available"));
				add(new Side("T04_R3",0,"available"));
				add(new Side("T04_R4",0,"available"));
			}};

			List<Side> table4LeftSide = new ArrayList<>(){{
				add(new Side("T04_L1",0,"available"));
				add(new Side("T04_L2",0,"available"));
				add(new Side("T04_L3",0,"available"));
				add(new Side("T04_L4",0,"available"));
			}};

			t4.setLeftSeats(table4LeftSide);
			t4.setRightSeats(table4RightSide);

			List<Table> tables = new ArrayList<>();
			tables.add(t1);
			tables.add(t2);
			tables.add(t3);
			tables.add(t4);
			f1.setTables(tables);

			repository.save(f1);

			Floor f2 = new Floor();
			repository.save(f2);

			log.info("Floors found with findAll():");
			log.info("----------------------------");
//			log.info(String.valueOf(repository.findAll()));
//
//			for(Floor floor: repository.findAll())
//			{
//				List<Table> allTables = floor.getTables();
//
//				log.info(String.valueOf(allTables.size()));
//				for(Table currentTable: allTables)
//				{
//					List<Side> left = currentTable.getLeftSeats();
//					List<Side> right = currentTable.getRightSeats();
//
//					for(Side seat: left)
//					{
//						log.info("Seat Name: " +seat.getName() + " Seat TeamID: " + seat.getTeamID()
//						 + " Seat Status: " + seat.getStatus());
//
//					}
//
//					for(Side seat: right)
//					{
//						log.info("Seat Name: " +seat.getName() + " Seat TeamID: " + seat.getTeamID()
//								+ " Seat Status: " + seat.getStatus());
//
//					}
//				}
//			}
		};
	}

}
