package service;

import database.DB;
import database.Status;
import model.Movie;
import model.Timeline;
import util.DateUtil;

import javax.xml.crypto.Data;

public class ReserveService {

    public static String reserve(Movie movie, int adult, int teen, int kid) {
        String id = Status.getLoginUser();
        if (id == null) {
            return "user not login";
        }
        String paymentDate = DateUtil.getToday(); // for storing paymentDate by today date and time
        if (adult == 0 && teen == 0 && kid == 0) { // if we doesn't buy any amount of ticket
            return "quantity is wrong";
        }
        
        // for calculating totalPrice by constant price(different by each age) and quantity of tickets
        int totalPrice = adult * DB.getAdult() + teen * DB.getTeen() + kid * DB.getKid(); 
        Timeline timeline = new Timeline(
                movie.getName(),
                paymentDate,
                adult,
                teen,
                kid,
                totalPrice
        );
        return TimelineService.putTimeline(id, timeline);
    }
}
