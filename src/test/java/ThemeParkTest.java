import attractions.Attraction;
import attractions.Dodgems;
import attractions.Playground;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.ParkingSpot;
import stalls.Stall;
import stalls.TobaccoStall;


import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    ThemePark themePark;
    Visitor visitor;
    Dodgems dodgems;

    @Before
    public void before(){
        TobaccoStall tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 0);
        CandyflossStall candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1,0);
        visitor = new Visitor(14, 1.2, 40.0);
        dodgems = new Dodgems("Bumper Cars", 5);
        Playground playground = new Playground("Fun Zone", 7);
        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(dodgems);
        attractions.add(playground);
        ArrayList<Stall> stalls = new ArrayList<>();
        stalls.add(tobaccoStall);
        stalls.add(candyflossStall);
        themePark = new ThemePark(attractions, stalls);
        }

        @Test
        public void getAllReviewedCanHoldDifferentObjectsWithIReviewedInterface(){
            themePark.getAllReviewed();
            assertEquals(4, themePark.getSizeOfReviewed());
        }

        @Test
        public void visitWillIncreaseVisitCount(){
        themePark.visit(visitor, dodgems);
        assertEquals(1, dodgems.getVisitCount());
        }

        @Test
        public void attractionCanBeAddedToVisitedAttractionsList(){
        themePark.visit(visitor, dodgems);
        assertEquals(1,visitor.getVisitedAttractionsSize());
        }

        @Test
        public void hashMapwithReviewsIsCreated(){
        themePark.allReviews();
        assertEquals(4, themePark.getSizeOfReviewedHashMap());
        }

}
