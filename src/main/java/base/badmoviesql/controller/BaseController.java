package base.badmoviesql.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.List;

@RestController
@Order(Ordered.LOWEST_PRECEDENCE)
public class BaseController<T> {
    protected Logger logger = LoggerFactory.getLogger(BaseController.class);

    protected static final String APPLICATION_JSON = "application/json";

    @RequestMapping(value = {"/"},
            produces = {APPLICATION_JSON},
            method = {RequestMethod.GET}
    )
    public String index() {
        return "badmoviesql API";
    }

    protected HttpHeaders getDefaultHeaders(Object object, Class<? extends BaseController> clazz) {
        HttpHeaders headers = new HttpHeaders();
        return headers;
    }

    protected final ResponseEntity<T> responseEntity(Object resources, HttpHeaders headers, HttpStatus status) {
        if (resources != null) {
            return new ResponseEntity((resources instanceof Collection ? (List<T>) resources : (T) resources), headers, status);
        } else {
            return null;
        }
    }
}
