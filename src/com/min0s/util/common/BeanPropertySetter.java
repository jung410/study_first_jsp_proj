package com.min0s.util.common;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

// =========== reflact ===========

public class BeanPropertySetter {
	public static void setProps(HttpServletRequest req, Object bean) {
		Method[] methods = bean.getClass().getDeclaredMethods();
		
		for(Method m : methods) {
			Class<?>[] params = m.getParameterTypes();
			// setter를 가져오기 위한 조건
			try {
				if(m.getName().startsWith("set") && params.length == 1) {
					String paramName = m.getName().substring(3,4).toLowerCase() + m.getName().substring(4);
					String paramValue = req.getParameter(paramName);
					if(req != null && paramValue != null) {
						Object targetParam = paramValue;

						// parameter type 구분
						if(params[0] == Integer.class || params[0] == int.class) {
							// parseInt
							targetParam = Integer.parseInt(paramValue);
						}
						else if(params[0] == Double.class || params[0] == double.class) {
							// parseDouble
							targetParam = Double.parseDouble(paramValue);
						}
						else if(params[0] == Boolean.class || params[0] == boolean.class) {
							// parseDouble
							targetParam = paramValue.equals("0") ? false : true;
						}
						m.invoke(bean, targetParam);							
					}
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// file 전송을 위한 setProps (multirequest를 사용하기 위해)
	public static void setProps(MultipartRequest req, Object bean) {
		Method[] methods = bean.getClass().getDeclaredMethods();
		
		for(Method m : methods) {
			Class<?>[] params = m.getParameterTypes();
			// setter를 가져오기 위한 조건
			try {
				if(m.getName().startsWith("set") && params.length == 1) {
					String paramName = m.getName().substring(3,4).toLowerCase() + m.getName().substring(4);
					String paramValue = req.getParameter(paramName);
					if(req != null && paramValue != null) {
						Object targetParam = paramValue;

						// parameter type 구분
						if(params[0] == Integer.class || params[0] == int.class) {
							// parseInt
							targetParam = Integer.parseInt(paramValue);
						}
						else if(params[0] == Double.class || params[0] == double.class) {
							// parseDouble
							targetParam = Double.parseDouble(paramValue);
						}
						else if(params[0] == Boolean.class || params[0] == boolean.class) {
							// parseDouble
							targetParam = paramValue.equals("0") ? false : true;
						}
						m.invoke(bean, targetParam);							
					}
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
