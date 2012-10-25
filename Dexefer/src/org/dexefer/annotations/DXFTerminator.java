package org.dexefer.annotations;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines the terminator string of a DXF element.
 * @author luisro *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)	
@Target(ElementType.TYPE)
public @interface DXFTerminator {
	/**
	 * The string used as element terminator.
	 * @return
	 */
	String value();
}
