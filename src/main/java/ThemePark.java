import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;
    private ArrayList<IReviewed> reviewed;
    private HashMap<String, Integer> reviewHashMap;

    public ThemePark(ArrayList<Attraction> attractions, ArrayList<Stall> stalls) {
        this.attractions = attractions;
        this.stalls = stalls;
        this.reviewed = new ArrayList<>();
        reviewHashMap = new ArrayList<>();
    }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public void addAttractions(Attraction attractions) {
        this.attractions.add(attractions);
    }

    public ArrayList<Stall> getStalls() {
        return stalls;
    }

    public void addStalls(Stall stalls) {
        this.stalls.add(stalls);
    }

    public ArrayList<IReviewed> getAllReviewed() {
        for (Attraction attraction : attractions) {
            if (attraction instanceof IReviewed) {
                this.reviewed.add(attraction);
            }
        }
        for (Stall stall : stalls) {
            if (stall instanceof IReviewed) {
                this.reviewed.add(stall);
            }
        }
        return this.reviewed;
    }

    public int getSizeOfReviewed() {
        return this.reviewed.size();
    }

    public void visit(Visitor visitor, Attraction attraction){
        attraction.increaseVisitCount();
        visitor.addAttractionToVisitedAttractions(attraction);
    }

    public HashMap<String, Integer> allReviews(){
        for( IReviewed reviews: reviewed){
            reviewHashMap.put(reviews.getName(), reviews.getRating());
        }
        return reviewHashMap;
    }

    public int getSizeOfReviewedHashMap(){
        return this.reviewHashMap.size();
    }
}



