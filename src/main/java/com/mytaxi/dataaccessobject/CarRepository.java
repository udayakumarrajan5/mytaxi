/**
 * 
 */
package com.mytaxi.dataaccessobject;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mytaxi.domainobject.CarDO;
import com.mytaxi.exception.EntityNotFoundException;

/**
 * @author udayakumar.rajan
 *
 */
public interface CarRepository extends CrudRepository<CarDO, Long>{
	
	CarDO findByLicensePlate (String plate); 
	void deleteByLicensePlate (String plate) ;

}
