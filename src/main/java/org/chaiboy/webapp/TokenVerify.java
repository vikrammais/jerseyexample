package org.chaiboy.webapp;

//import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.Long.TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Vikram Aditya on 6/28/2017.
 */
//@NameBinding
@Retention(RUNTIME)
@Target({ElementType.TYPE})
public @interface TokenVerify {

}
