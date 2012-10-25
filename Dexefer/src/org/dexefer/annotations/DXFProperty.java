package org.dexefer.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a field as a DXF property.
 * @author luisro
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)	
@Target(ElementType.FIELD)
public @interface DXFProperty {
	/**
	 * The code of the property. Codes are determined by the DXF Specification
	 * @return
	 */
	public int value();
}
