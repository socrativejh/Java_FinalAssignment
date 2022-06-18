package model;

import model.common.UserModule;
import service.ReserveService;

public class Teen extends User implements UserModule {

    public Teen(String id,
                String password,
                String name,
                String birth) {
        super(
                id,
                password,
                name,
                birth
        );
    }

    @Override // for returning the result of ReserveService
    public String reserve(Movie movie, int adult, int teen, int kid) {
        if (movie.getPg() >= 20) { // when pg is over 20 years old and buyer is a teenager
            return "user is too young to reserve";
        }
        return ReserveService.reserve(movie, adult, teen, kid); 
    }
}
