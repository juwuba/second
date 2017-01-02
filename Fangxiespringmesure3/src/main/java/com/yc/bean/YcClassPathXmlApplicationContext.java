package com.yc.bean;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
public class YcClassPathXmlApplicationContext {
	private Map<String,Object> map=new HashMap<String,Object>();

	public YcClassPathXmlApplicationContext(String config) throws Exception {
		//ioc 托管bean
		SAXBuilder builder=new SAXBuilder();
		Document doc= builder.build(this.getClass().getClassLoader().getResourceAsStream(config));
		Element root=doc.getRootElement();
		List list=root.getChildren();
		for(int i=0;i<list.size();i++){
			Element beanElement=(Element) list.get(i);
			String id=beanElement.getAttributeValue("id");
			String clazz=beanElement.getAttributeValue("class");
			Object obj=Class.forName(clazz).newInstance();
			//di注入bean
			List<Element> propertyList=beanElement.getChildren();
			for(Element properElement: propertyList){
				String name=properElement.getAttributeValue("name");
				String value=properElement.getAttributeValue("value");
				String ref=properElement.getAttributeValue("ref");
				Method m=getObjMethod(obj,name);
				if(m==null){
					continue;
				}
				if(value!=null){
					String parameterType=m.getParameterTypes()[0].getName();//得到传进方法的参数值类型
					if("java.lang.Integer".equals(parameterType)|| "int".equals(parameterType)){
						m.invoke(obj, Integer.parseInt(value));
					}else if("java.lang.Double".equals(parameterType)|| "double".equals(parameterType)){
						m.invoke(obj, Double.parseDouble(value));
					}else if("java.lang.Float".equals(parameterType)|| "float".equals(parameterType)){
						m.invoke(obj, Float.parseFloat(value));
					}else if("java.lang.Long".equals(parameterType)|| "long".equals(parameterType)){
						m.invoke(obj, Long.parseLong(value));
					}else{
						m.invoke(obj, value);
					}
				}else if(ref !=null){
					Object refobj=map.get(ref);
					m.invoke(obj, refobj);
				}
			}
			map.put(id, obj);
		}

	}
	//获取要注入值的方法
	private Method getObjMethod(Object obj, String name) {
		String setMethodName= "set"+name.substring(0,1).toUpperCase()+name.substring(1);
		Method[] ms=obj.getClass().getMethods();
		for(Method m:ms){
			if(m.getName().equals(setMethodName)){
				return m;
			}
		}
		return null;
	}
	public Object getBean(String id){
		return map.get(id);
	}


}
