package org.dexefer.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a field as containing a collection of sub elements of the present element.
 * @author luisro
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)	
@Target(ElementType.FIELD)
public @interface DXFSubElements {

}
