/**
 * 
 */
package com.mytaxi.filter;

import java.util.List;

import com.mytaxi.datatransferobject.DriverDTO;


/**
 * @author Udayakumar.Rajan
 *
 */
public interface Criteria {
	
	 public List<DriverDTO> meetCriteria();

}
