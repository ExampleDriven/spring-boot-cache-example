package org.exampledriven.springcache.service;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Component("TransferKeyGenerator")
public class TransferKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        int i = 0;
        for (Parameter parameter : method.getParameters()) {
            if ("int".equals(parameter.getType().getName()) &&
                (
                    "id".equals(parameter.getName()) ||
                    "arg0".equals(parameter.getName())
                )
            ) {
                return params[i];
            }
            i++;
        }
        throw new RuntimeException("Method " + method.getDeclaringClass() +"."+ method.getName() + " does not have id parameter");
    }

}
