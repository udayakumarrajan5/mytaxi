/**
 * 
 */
package com.mytaxi.service.car;

import java.util.List;

import com.mytaxi.domainobject.CarDO;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;

/**
 * @author udayakumar.rajan
 *
 */
public interface CarService {
	
    CarDO find(Long carId) throws EntityNotFoundException;

    CarDO create(CarDO carDO) throws ConstraintsViolationException;

    void delete(Long carId) throws EntityNotFoundException;

    CarDO find(String licensePlate) throws EntityNotFoundException;
    
    void delete(String licensePlate) throws EntityNotFoundException;
    
    List<CarDO> findAll ();

}
 