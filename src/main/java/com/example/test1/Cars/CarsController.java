package com.example.test1.Cars;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.rest.webmvc.RepositoryRestController;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

@RepositoryRestController
public class CarsController {

    @Autowired
    CarsRepository carsRepository;
    @Autowired
    ApiModelToEntityAdapter apiModelToEntityAdapter;
    @PostMapping(path = "/cars")
    public ResponseEntity create(@RequestBody CarsApiModel carsApiModel) {
        try {
            Car car = this.apiModelToEntityAdapter.getNewCarEntity(carsApiModel);
            carsRepository.save(car);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
