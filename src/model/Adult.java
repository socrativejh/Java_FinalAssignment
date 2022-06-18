package model;

import model.common.UserModule;
import service.ReserveService;

public class Adult extends User implements UserModule {

    public Adult(String id,
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
        return ReserveService.reserve(movie, adult, teen, kid);
    }
}
