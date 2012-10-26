package org.dexefer.annotations;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines type of the Element. When used, the 0 code (type) will be assigned to
 * the annotations value, and the 2 code (name) to the class' name (uppercased).
 * @author luisro 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)	
@Target(ElementType.TYPE)
public @interface DXFElementType {
	/**
	 * The string used as element's type.
	 * @return
	 */
	String value();
}