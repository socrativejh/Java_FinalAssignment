package service;

import database.DB;
import database.Status;
import model.Timeline;

import java.util.List;

import static java.util.Comparator.comparing;

public class TimelineService {

    public static List<Timeline> getTimeline() {
        String id = Status.getLoginUser();
        List<Timeline> timelineList = DB.getTimeline(id);
        timelineList.sort(comparing(Timeline::getPaymentDate));
        return timelineList;
    }

    public static String putTimeline(String id, Timeline timeline) {
    	 // for checking parameter here before put data into DB;
        try {
            DB.putTimeline(id, timeline);
            return "success";
        } catch (Exception e) {
            return "DB error";
        }
    }

}
